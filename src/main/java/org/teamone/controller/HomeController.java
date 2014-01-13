package org.teamone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teamone.domain.QueueJDBCTemplate;
import org.teamone.domain.UserJDBCTemplate;
import org.teamone.domain.SubjectJDBCTemplate;

@Controller
public class HomeController {

    @Autowired
    private UserJDBCTemplate personJDBCTemplate;
    @Autowired
    private SubjectJDBCTemplate subjectJDBCTemplate;
    @Autowired
    QueueJDBCTemplate queueJDBCTemplate;

    /*
     @RequestMapping("/*")
     public String testView(Model model) {
     model.addAttribute("queues", queueJDBCTemplate.listQueue());
     return "home";
     }
     */
    /*
     * 
     @RequestMapping("/*")
     public String testView() {
     return "home";
     }
     */
    @RequestMapping("/access/password")
    public String passView() {
        return "usersettings";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/access/passwordReset")
    public String forgotPassword() {
        return "passwordReset";
    }

    @RequestMapping(value = "queueOverlay.htm")
    public String overlay() {
        return "queueOverlay";
    }

    @RequestMapping("/access/testDatabase")
    public String testDatabase(Model model) {
        model.addAttribute("persons", personJDBCTemplate.listUsers());
        return "testDatabase";
    }

    @RequestMapping("/access/testDatabase2")
    public String testDatabase2(Model model) {
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        return "testDatabase2";
    }

    @RequestMapping("/teacherQueue")
    public String teacherQueue(Model model) {
        model.addAttribute("queues", queueJDBCTemplate.listQueue());
        return "teacherQueue";
    }

    @RequestMapping("/approveInQueue")
    public String approveInQueue() {
        return "approveInQueue";
    }

    @RequestMapping("/access/eksamensrapport")
    public String examOverview() {
        return "eksamensrapport";
    }
}
