package org.teamone.controller;

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
    
    

    @RequestMapping(value = "/access/admin")
    public String adminView(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
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
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);

        if (user.checkUserData()) {
            userJDBCTemplate.create(user);
            for (int i = 0; i < roles.length; i++) {
                Role temp = new Role();
                temp.setRoleName(roles[i]);
                temp.setUsername(email);
                roleJDBCTemplate.create(temp);
            }
            return "redirect:/access/home";
        } else {
            model.addAttribute("error", true);
            return "admin";
        }

    }
    
    @RequestMapping(value="/admin")
    public String adminHomeView(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("username", auth.getName());
        
        return "admin";
    }

}
