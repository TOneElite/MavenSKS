package org.teamone.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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
import org.teamone.domain.User.User;
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
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/access/admin", method = RequestMethod.GET)
    public String adminView(
            @RequestParam(value = "con", required = false) String con, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        menuItems(model, auth);

        model.addAttribute("username", auth.getName());
        model.addAttribute("users", userJDBCTemplate.listUsersCon(con));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("roles", roleNameJDBCTemplate.listRoleName());

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
     * @param model - The model. This is for transferring from the controller to
     * the view.
     * @return
     */
    @RequestMapping(value = "/access/admin/addUser", method = RequestMethod.POST)
    public String addUserProcess(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "roles", required = false) String[] roles,
            @RequestParam(value = "subjects", required = false) String[] subjects,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        menuItems(model, auth);

        model.addAttribute("username", auth.getName());
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("roles", roleNameJDBCTemplate.listRoleName());
        User user = new User();
        Role role = new Role();
        user.setFirstName(firstName);
        user.setLastName(surname);
        user.setEmail(email);
        role.setEmail(email);
        user.setPassword(password);
        user.setDate(new Date());
        List<User> users = userJDBCTemplate.listUsers();
        Boolean exist = false;
        Boolean error = false;
        for (User emails : users) {
            if (emails.getEmail().equals(user.getEmail())) {
                exist = true;
            }
        }

        if (exist == false) {
            userJDBCTemplate.create(user);
        }
        List<String> sub = new ArrayList<String>();
        List<Role> rolecheck = roleJDBCTemplate.getSubjectRoles(email);
        System.out.println(rolecheck.size());
        if (rolecheck.size() == 0) {
            for (int i = 0; i < subjects.length; i++) {
                for (int j = 0; j < roles.length; j++) {
                    sub.add(subjects[i] + "/" + roles[j]);
                }
            }
        } else {
            for (Role rolee : rolecheck) {
                for (int i = 0; i < subjects.length; i++) {
                    for (int j = 0; j < roles.length; j++) {
                        if (subjects[i].equals(rolee.getSubjectCode()) && roles[j].equals(rolee.getRoleName())) {
                            System.out.println("role does");
                        } else {
                            System.out.println("role not");
                            sub.add(subjects[i] + "/" + roles[j]);
                        }
                    }
                }
            }
        }
        for (String works : sub) {
            String[] split = works.split("/");
            role.setRoleName(split[1]);
            role.setSubjectCode(split[0]);
            roleJDBCTemplate.create(role);
        }
        model.addAttribute("users", userJDBCTemplate.listUsers());
        return "admin";
    }

    @RequestMapping(value = "/access/adminAddSub", method = RequestMethod.POST)
    public String addSubject(
            @RequestParam(value = "code", required = false) String subjectCode,
            @RequestParam(value = "name", required = false) String subjectName,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        menuItems(model, auth);

        model.addAttribute("username", auth.getName());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("roles", roleNameJDBCTemplate.listRoleName());
        Subject subject = new Subject();
        List<Subject> subjects = subjectJDBCTemplate.listSubjects();
        Boolean exists = false;
        for (Subject subs : subjects) {
            System.out.println(subs.getCode() + " test " + subjectCode);
            if (subs.getCode().equals(subjectCode) || subs.getName().equals(subjectName)) {
                System.out.println("exists");
                exists = true;
            }
            System.out.println("test2");
        }

        if (exists == false) {
            subject.setCode(subjectCode);
            subject.setName(subjectName);
            subjectJDBCTemplate.addSubject(subject);
            model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
            return "admin";
        }
        return "admin";
    }

    /**
     * Shows the administrator home page. The home page shows all users,
     * subjects and rooms.
     *
     * @param model - The model. This is for transferring from the controller to
     * the view.
     * @return name for tilesViewResolver.
     */
    @RequestMapping(value = "/admin")
    public String adminHomeView(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        menuItems(model, auth);

        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("username", auth.getName());

        return "admin";
    }

    @RequestMapping(value = "/access/updateUser", method = RequestMethod.POST)
    public String updateUser(
            @RequestParam("email") String email,
            @RequestParam(value = "con", required = false) String con,
            Model model) {
        User user = userJDBCTemplate.getUserByEmail(email);
        if (con == null) {
            model.addAttribute("subject", roleJDBCTemplate.getSubjectRoles(email));
        } else {
            model.addAttribute("subject", roleJDBCTemplate.getSubjectRolesCon(email, con));
        }
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("roles", roleNameJDBCTemplate.listRoleName());
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("email", email);
        model.addAttribute("password", user.getPassword());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        menuItems(model, auth);
        return "endreBruker";
    }

    @RequestMapping(value = "/access/updateUserOK", method = RequestMethod.POST)
    public String updateUserOK(
            @RequestParam(value = "ssubject", required = false) String ssubject,
            @RequestParam(value = "srole", required = false) String srole,
            @RequestParam(value = "submit", required = false) String submit,
            @RequestParam(value = "firstname", required = false) String firstname,
            @RequestParam(value = "lastname", required = false) String lastname,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "Endre", required = false) String Endre,
            @RequestParam(value = "Avbryt", required = false) String Avbryt,
            Model model) {
        User user = userJDBCTemplate.getUserByEmail(email);
        System.out.println(user.getFirstName());
        List<User> users = userJDBCTemplate.listUsers();
        List<Role> roles = roleJDBCTemplate.getSubjectRoles(email);
        for (User use : users) {
            if (use.getEmail().equals(email)) {
                user = use;
            }
        }
        if (Avbryt != null) {
            return "redirect:admin";
        }
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPassword(password);
        if (Endre != null) {
            userJDBCTemplate.updateUser(user);
        }
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("email", email);
        model.addAttribute("password", user.getPassword());
        if (submit != null) {
            User user2 = userJDBCTemplate.getUserByEmail(email);
            model.addAttribute("firstname", user2.getFirstName());
            model.addAttribute("lastname", user2.getLastName());
            model.addAttribute("email", email);
            model.addAttribute("password", user2.getPassword());
            Role role = new Role();
            role.setEmail(email);
            role.setRoleName(srole);
            role.setSubjectCode(ssubject);
            Boolean rexist = false;
            for (Role roless : roles) {
                if (roless.getRoleName().equals(role.getRoleName())
                        && roless.getSubjectCode().equals(role.getSubjectCode())) {
                    rexist = true;
                }
            }
            if (rexist == false) {
                roleJDBCTemplate.create(role);
            }
            model.addAttribute("roles", roleNameJDBCTemplate.listRoleName());
            model.addAttribute("subject", roleJDBCTemplate.getSubjectRoles(email));
            model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
            return "endreBruker";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        menuItems(model, auth);
        return "endreBruker";
    }

    private void menuItems(Model model, Authentication auth) {
        model.addAttribute("username", auth.getName());
        model.addAttribute("studentsubjects", roleJDBCTemplate.getStudentSubjects(auth.getName()));
        model.addAttribute("teachersubjects", roleJDBCTemplate.getTeacherSubjects(auth.getName()));
        boolean admin = false;
        for (GrantedAuthority ga : auth.getAuthorities()) {
            if (ga.toString().equals("ROLE_ADMIN")) {
                admin = true;
                model.addAttribute("isAdmin", admin);
            }
        }
    }
}
