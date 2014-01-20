package org.teamone.controller;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamone.domain.Queue.QueueJDBCTemplate;
import org.teamone.domain.Role.Role;
import org.teamone.domain.Role.RoleJDBCTemplate;
import org.teamone.domain.Subject.SubjectJDBCTemplate;
import org.teamone.domain.User.User;
import org.teamone.domain.User.UserJDBCTemplate;
import org.teamone.domain.UserTask.UserTaskJDBCTemplate;
import org.teamone.domain.UserTask.UserTask;
import org.teamone.domain.room.RoomJDBCTemplate;

@Controller
public class TeacherController {

    @Autowired
    private QueueJDBCTemplate queueJDBCTemplate;
    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    @Autowired
    private RoleJDBCTemplate roleJDBCTemplate;

    @Autowired
    private SubjectJDBCTemplate subjectJDBCTemplate;

    @Autowired
    private UserTaskJDBCTemplate userTasksJDBCTemplate;

    @Autowired
    private RoomJDBCTemplate roomJDBCTemplate;

    /*
     @RequestMapping("/access/teacherQueue")
     public String teacherQueue(Model model) {
     model.addAttribute("queues", queueJDBCTemplate.listQueue());
     model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
     return "teacherQueue";
     }*/
    @RequestMapping("/access/eksamensrapport")
    public String examOverview() {
        return "eksamensrapport";
    }

    @RequestMapping(value = "/access/approveInQueue", method = RequestMethod.POST)
    public String options(
            @RequestParam(value = "remove", required = false) String remove,
            @RequestParam(value = "postpone", required = false) String postpone,
            @RequestParam(value = "help", required = false) String help,
            @RequestParam(value = "approve", required = false) String approve,
            @RequestParam("queueId") String queueId,
            @RequestParam("subjectcode") String subjectCode,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String helper = "Får hjelp av " + auth.getName();
        model.addAttribute("username", auth.getName());
        int id = Integer.parseInt(queueId);
        if (remove != null) {
            queueJDBCTemplate.delete(id);
            model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        }
        if (postpone != null) {
            queueJDBCTemplate.status("Utsatt", id);
            model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        }
        if (help != null) {
            queueJDBCTemplate.status(helper, id);
            model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        }
        if (approve != null) {
            model.addAttribute("queue", queueJDBCTemplate.getQueue(id));
            return "approveInQueue";
        }
        return "teacherQueue";
    }

    @RequestMapping(value = "/access/readfile")
    public String readfile() {
        return "readfile";
    }

    @RequestMapping(value = "/access/fileread", method = RequestMethod.POST)
    public String fileread(
            @RequestParam("output") String fileread) {
        String[] words = fileread.split("[,\\n]");
        User user = new User();
        Role role = new Role();
        for (int i = 0; i < (words.length / 4); i++) {
            user.setSurname(words[(i * 4)]);
            user.setFirstName(words[(i * 4) + 1]);
            user.setEmail(words[(i * 4) + 2]);
            role.setUsername(words[(i * 4) + 2]);
            user.setPassword(words[(i * 4) + 3]);
            role.setRoleName("ROLE_USER");
            userJDBCTemplate.create(user);
            roleJDBCTemplate.create(role);
        }
        return "redirect:home";
    }

    @RequestMapping(value = "/access/teacherQueue", method = RequestMethod.POST)
    public String approve(
            @RequestParam(value = "cancel", required = false) String cancel,
            @RequestParam(value = "approved", required = false) String approve,
            @RequestParam(value = "task", required = false) String[] tasks,
            @RequestParam(value = "queueId") String queueId,
            @RequestParam(value = "subjectCode") String subjectCode,
            @RequestParam(value = "some", required = false) String some,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        System.out.println("Dette er task 0: " + tasks[0] + " task 1: " + tasks[1]);
        if (cancel != null) {
            model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
            return "teacherQueue";
        }
        if (approve != null) {
            if (tasks[0].contains(",")) {
                for (String s : tasks) {
                    String[] temp = s.split(", ");
                    UserTask userTask = new UserTask();
                    userTask.setEmail(temp[0]);
                    userTask.setSubjectCode(subjectCode);
                    userTask.setTaskNr(Integer.parseInt(temp[1]));
                    userTasksJDBCTemplate.approve(userTask);
                    System.out.println("dette er temp 1 " + temp[1] + " dette er temp 0 " + temp[0]);
                }
            } else {
                UserTask userTask = new UserTask();
                userTask.setEmail(tasks[0]);
                userTask.setSubjectCode(subjectCode);

                userTask.setTaskNr(Integer.parseInt(tasks[1]));
                userTasksJDBCTemplate.approve(userTask);
                System.out.println("dette er tasks 1 " + tasks[1] + " dette er tasks 0 " + tasks[0]);
            }

            queueJDBCTemplate.delete(Integer.parseInt(queueId));
            model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
            return "teacherQueue";
        }
        return "teacherQueue";
    }

    @RequestMapping(value = "/access/teacher{subjectCode}", method = RequestMethod.GET)
    public String teacherQueueView(Model model, @PathVariable String subjectCode
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("activeSubject", subjectCode);
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
        return "teacherQueue";
    }

    @RequestMapping(value = "/access/subjectSettings", method = RequestMethod.GET)
    public String teacherSettings(Model model, @PathVariable String subjectCode
    ) {
        
        return "subjectSettings";
    }
}
