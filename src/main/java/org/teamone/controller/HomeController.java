package org.teamone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.domain.Queue.QueueJDBCTemplate;
import org.teamone.domain.room.RoomJDBCTemplate;
import org.teamone.domain.User.UserJDBCTemplate;
import org.teamone.domain.ApprovedTasks.ApprovedTasksJDBCTemplate;
import org.teamone.domain.Subject.SubjectJDBCTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    @Autowired
    private SubjectJDBCTemplate subjectJDBCTemplate;
    @Autowired
    private QueueJDBCTemplate queueJDBCTemplate;
    @Autowired
    private RoomJDBCTemplate roomJDBCTemplate;
    @Autowired
    private ApprovedTasksJDBCTemplate userTaskJDBCTemplate;

    @RequestMapping(value = "/access/home", method = RequestMethod.GET)
    public String homeView(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("rooms", roomJDBCTemplate.listRoom());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("queues", queueJDBCTemplate.listQueue());
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        System.out.println("test: " + auth.getAuthorities());
        // Check for admin rights
        boolean admin = false;
        boolean teacher = false;
        boolean user = false;
        for (GrantedAuthority ga : auth.getAuthorities()) {
            if (ga.toString().equals("ROLE_ADMIN")) {
                System.out.println("is ADMIN!");
                admin = true;
                model.addAttribute("isAdmin", admin);
            }
            if (ga.toString().equals("ROLE_TEACHER")) {
                System.out.println("is TEACHER!");
                teacher = true;
                model.addAttribute("isTeacher", teacher);
            }
            if (ga.toString().equals("ROLE_USER")) {
                System.out.println("is USER!");
                user = true;
                model.addAttribute("isUser", user);
            }
            if (ga.toString().equals("ROLE_USER")) {
                System.out.println("is USER!");
                user = true;
                model.addAttribute("isUser", user);
            }
            if (ga.toString().equals("ROLE_USER")) {
                System.out.println("is USER!");
                user = true;
                model.addAttribute("isUser", user);
            }
        }

        return "home";
    }

    @RequestMapping(value = "/access/{subjectCode}", method = RequestMethod.GET)
    public String homeView(Model model, @PathVariable String subjectCode) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("rooms", roomJDBCTemplate.listRoom());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("activeSubject", subjectCode);
        System.out.println("test: " + auth.getAuthorities());
        // Check for admin rights
        boolean admin = false;
        boolean teacher = false;
        boolean user = false;
        for (GrantedAuthority ga : auth.getAuthorities()) {
            if (ga.toString().equals("ROLE_ADMIN")) {
                System.out.println("is ADMIN!");
                admin = true;
                model.addAttribute("isAdmin", admin);
            }
            if (ga.toString().equals("ROLE_TEACHER")) {
                System.out.println("is TEACHER!");
                teacher = true;
                model.addAttribute("isTeacher", teacher);
            }
            if (ga.toString().equals("ROLE_USER")) {
                System.out.println("is USER!");
                user = true;
                model.addAttribute("isUser", user);
            }
            if (ga.toString().equals("ROLE_USER")) {
                System.out.println("is USER!");
                user = true;
                model.addAttribute("isUser", user);
            }
            if (ga.toString().equals("ROLE_USER")) {
                System.out.println("is USER!");
                user = true;
                model.addAttribute("isUser", user);
            }
        }

        return "home";
    }

    @RequestMapping(value = "/access/testDatabase", method = RequestMethod.GET)
    public String testDatabase(Model model) {
        model.addAttribute("persons", userJDBCTemplate.listUsers());
        return "testDatabase";
    }

    @RequestMapping(value = "/access/testDatabase2", method = RequestMethod.GET)
    public String testDatabase2(Model model) {
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        return "testDatabase2";
    }

    @RequestMapping(value = "/access/taskoverview", method = RequestMethod.GET)
    public String taskOverview(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("userTasks", userTaskJDBCTemplate.listApprovedTasksWithoutSubject(auth.getName()));
        return "taskoverview";
    }
}
