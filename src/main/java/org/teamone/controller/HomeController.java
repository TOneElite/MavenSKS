package org.teamone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.domain.QueueJDBCTemplate;
import org.teamone.domain.RoomJDBCTemplate;
import org.teamone.domain.UserJDBCTemplate;
import org.teamone.domain.SubjectJDBCTemplate;
import org.springframework.security.core.GrantedAuthority;

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

    /*
    @RequestMapping(value = "/access/password", method = RequestMethod.GET)
    public String passView() {
        return "usersettings";
    }
    */

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
        for (GrantedAuthority ga : auth.getAuthorities()) {
            if (ga.toString().equals("ROLE_ADMIN")) {
                System.out.println("is ADMIN!");
                admin = true;
                model.addAttribute("isAdmin", admin);
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

}