package org.teamone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.domain.QueueJDBCTemplate;
import org.teamone.domain.RoomJDBCTemplate;
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
    @Autowired
    RoomJDBCTemplate roomJDBCTemplate;

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
    @RequestMapping(value = "/access/password", method = RequestMethod.GET)
    public String passView() {
        return "usersettings";
    }

    @RequestMapping(value = "/access/home", method = RequestMethod.GET)
    public String homeView(Model model) {
        model.addAttribute("rooms", roomJDBCTemplate.listRoom());
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/access/passwordReset", method = RequestMethod.GET)
    public String forgotPassword() {
        return "passwordReset";
    }

    @RequestMapping(value = "/access/testDatabase", method = RequestMethod.GET)
    public String testDatabase(Model model) {
        model.addAttribute("persons", personJDBCTemplate.listUsers());
        return "testDatabase";
    }

    @RequestMapping(value = "/access/testDatabase2", method = RequestMethod.GET)
    public String testDatabase2(Model model) {
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        return "testDatabase2";
    }

    @RequestMapping("/access/teacherQueue")
    public String teacherQueue(Model model) {
        model.addAttribute("queues", queueJDBCTemplate.listQueue());
        return "teacherQueue";
    }

    @RequestMapping("/access/approveInQueue")
    public String approveInQueue() {
        return "approveInQueue";
    }

    @RequestMapping("/access/eksamensrapport")
    public String examOverview() {
        return "eksamensrapport";
    }
}
