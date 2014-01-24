package org.teamone.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.teamone.domain.ApprovedTasks.ApprovedTasks;
import org.teamone.domain.Role.RoleJDBCTemplate;
import org.teamone.domain.Subject.Subject;
import org.teamone.domain.User.User;
import org.teamone.logic.RuleService;

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
    @Autowired
    private RoleJDBCTemplate roleJDBCTemplate;

    @RequestMapping(value = "/access/{subjectCode}", method = RequestMethod.GET)
    public String homeView(Model model, @PathVariable String subjectCode) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        menuItems(model);
        model.addAttribute("username", auth.getName());
        model.addAttribute("rooms", roomJDBCTemplate.listRoom());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("activeSubject", subjectCode);
        model.addAttribute("userTasks", userTaskJDBCTemplate.listApprovedTasksWithoutSubject(auth.getName()));
        model.addAttribute("usersubjects", roleJDBCTemplate.getSubjectRoles(auth.getName()));
        model.addAttribute("queueStatus", subjectJDBCTemplate.getSubject(subjectCode));
        // Check for admin rights
        boolean admin, teacher, user = false;
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

    @RequestMapping(value = "/access/taskoverview", method = RequestMethod.GET)
    public String taskOverview(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<ApprovedTasks> listApprovedTasks = userTaskJDBCTemplate.listApprovedTasksWithoutSubject(auth.getName());
        List<Subject> listYourSubjects = subjectJDBCTemplate.getYourSubjects("ROLE_USER", auth.getName());
        List<Subject> listCompletedSubjects = new ArrayList<Subject>();

        for (Subject s : listYourSubjects) {
            List<ApprovedTasks> approvedTasks = userTaskJDBCTemplate.listApprovedTasks(auth.getName(), s.getCode());
            boolean[] tasksDone = new boolean[s.getNrOfTasks()];
            for (ApprovedTasks as : approvedTasks) {
                tasksDone[as.getTaskNr() - 1] = true;
            }
            boolean ready = new RuleService().vertifyRequirements(tasksDone, s.getRules());
            if(ready){
                listCompletedSubjects.add(s);
            }
        }

        model.addAttribute("username", auth.getName());
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("userTasks", userTaskJDBCTemplate.listApprovedTasksWithoutSubject(auth.getName()));
        model.addAttribute("usersubjects", roleJDBCTemplate.getSubjectRoles(auth.getName()));
        menuItems(model);
        // Check for admin rights
        boolean admin, teacher, user = false;
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
        return "taskoverview";
    }

    private void menuItems(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("studentsubjects", roleJDBCTemplate.getStudentSubjects(auth.getName()));
        model.addAttribute("teachersubjects", roleJDBCTemplate.getTeacherSubjects(auth.getName()));
    }
}
