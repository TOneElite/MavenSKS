package org.teamone.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamone.domain.Role.Role;
import org.teamone.domain.Role.RoleJDBCTemplate;
import org.teamone.domain.Role.RoleNameJDBCTemplate;
import org.teamone.domain.Subject.Subject;
import org.teamone.domain.Subject.SubjectJDBCTemplate;
import org.teamone.domain.User.UserJDBCTemplate;

@Controller
public class AdminController {

    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    @Autowired
    private SubjectJDBCTemplate subjectJDBCTemplate;
    @Autowired
    private RoleNameJDBCTemplate roleNameJDBCTemplate;
    @Autowired
    private RoleJDBCTemplate roleJDBCTemplate;
    
    
    /**
     * TODO: Review: TO BE REMOVED ?
     * @param model
     * @return 
     */
    @RequestMapping(value = "/access/admin", method = RequestMethod.GET)
    public String adminView(
            @RequestParam(value = "con", required = false) String con, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("users", userJDBCTemplate.listUsersCon(con));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("roles", roleNameJDBCTemplate.listRoleName());
        // Check for admin rights
        boolean admin = false;
        for (GrantedAuthority ga : auth.getAuthorities()) {
            if (ga.toString().equals("ROLE_ADMIN")) {
                System.out.println("is ADMIN!");
                admin = true;
                model.addAttribute("isAdmin", admin);
            }
        }
        return "admin";
    }

    /**
     * Method for processing the registration form for users.
     * 
     * @param firstName - users first name
     * @param surname - users surname
     * @param email - users email / change this to auto-resolve
     * @param password - users password / change this to auto-resolve
     * @param roles - users roles.
     * @param model - The model. This is for transferring from the controller to the view.
     * @return 
     */
    @RequestMapping(value = "/access/admin/addUser", method = RequestMethod.POST)
    public String addUserProcess(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "roles", required = false) String[] roles,
            Model model) {

        org.teamone.domain.User.User user = new org.teamone.domain.User.User();
        user.setFirstName(firstName);
        user.setLastName(surname);
        user.setEmail(email);
        user.setPassword(password);

        if (user.checkUserData()) {
            userJDBCTemplate.create(user);
            for (int i = 0; i < roles.length; i++) {
                Role temp = new Role();
                temp.setRoleName(roles[i]);
                temp.setEmail(email);
                roleJDBCTemplate.create(temp);
            }
            return "redirect:/access/home";
        } else {
            model.addAttribute("error", true);
            return "admin";
        }

    }
    
    @RequestMapping(value = "/access/adminAddSub", method = RequestMethod.POST)
    public String addSubject(
            @RequestParam(value = "code", required = false) String subjectCode,
            @RequestParam(value = "name", required = false) String subjectName,
            @RequestParam(value = "tasks", required = false) String tasks,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("roles", roleNameJDBCTemplate.listRoleName());
        Subject subject = new Subject();
        List<Subject> subjects = subjectJDBCTemplate.listSubjects();
        Boolean exists = false;
        for(Subject subs : subjects){
            System.out.println(subs.getCode() + " test " + subjectCode);
            if(subs.getCode().equals(subjectCode) || subs.getName().equals(subjectName)){
                System.out.println("exists");
                exists = true;
            }
            System.out.println("test2");
        }
        
            if(exists == false){
                subject.setCode(subjectCode);
                subject.setName(subjectName);
                subject.setNrOfTasks(Integer.parseInt(tasks));
                subjectJDBCTemplate.addSubject(subject);
                model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
                return "admin";
            }
        return "admin";
    }
    
    /**
     * Shows the administrator home page.
     * The home page shows all users, subjects and rooms.
     * @param model - The model. This is for transferring from the controller to the view.
     * @return name for tilesViewResolver.
     */
    @RequestMapping(value="/admin")
    public String adminHomeView(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("username", auth.getName());
        
        return "admin";
    }

}