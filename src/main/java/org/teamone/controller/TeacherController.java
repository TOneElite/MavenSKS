package org.teamone.controller;

import java.util.Date;
import java.util.List;
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
import org.teamone.domain.Queue.Queue;
import org.teamone.domain.Role.Role;
import org.teamone.domain.Role.RoleJDBCTemplate;
import org.teamone.domain.Role.RoleNameJDBCTemplate;
import org.teamone.domain.Subject.Subject;
import org.teamone.domain.Subject.SubjectJDBCTemplate;
import org.teamone.domain.User.User;
import org.teamone.domain.User.UserJDBCTemplate;
import org.teamone.domain.ApprovedTasks.ApprovedTasksJDBCTemplate;
import org.teamone.domain.ApprovedTasks.ApprovedTasks;
import org.teamone.domain.Queue.QueueApprove;
import org.teamone.domain.Queue.QueueApproveJDBCTemplate;
import org.teamone.domain.room.RoomJDBCTemplate;
import org.teamone.domain.userRights.UserRights;
import org.teamone.domain.userRights.UserRightsJDBCTemplate;

@Controller
public class TeacherController {

    @Autowired
    private QueueJDBCTemplate queueJDBCTemplate;
    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    @Autowired
    private RoleJDBCTemplate roleJDBCTemplate;
    @Autowired
    private UserRightsJDBCTemplate userRightsJDBCTemplate;

    @Autowired
    private SubjectJDBCTemplate subjectJDBCTemplate;

    @Autowired
    private ApprovedTasksJDBCTemplate userTasksJDBCTemplate;

    @Autowired
    private RoomJDBCTemplate roomJDBCTemplate;

    @Autowired
    private QueueApproveJDBCTemplate QueueApproveJDBCTemplate;
    
    @Autowired
    private ApprovedTasksJDBCTemplate approvedTasksJDBCTemplate;


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
            @RequestParam(value = "queueId", required = false) String queueId,
            @RequestParam(value = "subjectcode", required = false) String subjectCode,
            @RequestParam(value = "currentSubject", required = false) String currentSubject,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String helper = "Får hjelp av " + auth.getName();
        model.addAttribute("username", auth.getName());

        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("activeSubject", subjectCode);

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

        if (remove != null) {
            int id = Integer.parseInt(queueId);
            queueJDBCTemplate.delete(id);
            model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        }
        if (postpone != null) {
            int id = Integer.parseInt(queueId);
            queueJDBCTemplate.status("Utsatt", id);
            model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        }
        if (help != null) {
            int id = Integer.parseInt(queueId);
            queueJDBCTemplate.status(helper, id);
            model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        }
        if (approve != null) {
            int id = Integer.parseInt(queueId);
            model.addAttribute("queues", QueueApproveJDBCTemplate.listQueueApproveID(id));
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
            @RequestParam("output") String fileread/*,
     @RequestParam("subject") String subjectcode*/) {
        String[] words = fileread.split("[,\\n]");
        User user = new User();
        Role role = new Role();
        String subjectcode = "TDAT1005";
        List<Subject> subjects = subjectJDBCTemplate.listSubjects();
        UserRights userRights = new UserRights();
        Boolean exist = false;
        Date date = new Date();
        for (int i = 0; i < (words.length / 4); i++) {
            user.setLastName(words[(i * 4)]);
            user.setFirstName(words[(i * 4) + 1]);
            user.setEmail(words[(i * 4) + 2]);
            role.setEmail(words[(i * 4) + 2]);
            user.setPassword(words[(i * 4) + 3]);
            role.setSubjectCode("TDAT-2007-13H");
            role.setRoleName("ROLE_USER");
            user.setDate(date);
            userRights.setRole(role);
            for (Subject subject : subjects) {
                if (subject.getCode().equals(subjectcode)) {
                    userRights.setSubject(subject);
                }
            }
            //user.addUserRights(userRights);
            List<User> users = userJDBCTemplate.listUsers();
            for (User email : users) {
                if (email.getEmail().equals(user.getEmail())) {
                    exist = true;
                }
            }
            if (exist == false) {
                userJDBCTemplate.create(user);
                roleJDBCTemplate.create(role);
            }
        }
        return "redirect:taskoverview";
    }

    @RequestMapping(value = "/access/teacherQueue", method = RequestMethod.POST)
    public String approve(
            @RequestParam(value = "cancel", required = false) String cancel,
            @RequestParam(value = "approved", required = false) String approve,
            @RequestParam(value = "task", required = false) String[] tasks,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        if (cancel != null) {
            //model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));

        }
        
        if (approve != null) {
            int queueID = -1;
            for (String t : tasks) {
                String[] info = t.split(";");
                queueID = Integer.parseInt(info[0]);
                String email = info[1];
                int taskNr = Integer.parseInt(info[2]);
                String subjectCode = queueJDBCTemplate.getQueue(queueID).getSubjectCode();
                ApprovedTasks at = new ApprovedTasks();
                at.setApprovedBy(auth.getName());
                at.setApprovedDate(new Date());
                at.setEmail(email);
                at.setSubjectCode(subjectCode);
                at.setTaskNr(taskNr);
                
                System.out.println(at.toString());
                approvedTasksJDBCTemplate.approve(at);
                
            }
            
            queueJDBCTemplate.delete(queueID);
            //model.addAttribute("queues", queueJDBCTemplate.listQueue(queueID).getSubjectCode());

        }
        return "home";
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
        return "teacherQueue";
    }

    @RequestMapping(value = "/access/subjectSettings", method = RequestMethod.GET)
    public String teacherSettings(Model model
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("rooms", roomJDBCTemplate.listRoom());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("isTeacher", true);
        System.out.println("IS HERE");
        return "teacherSettings";
    }

    @RequestMapping(value = "/access/subjectSettings/{subjectCode}", method = RequestMethod.GET)
    public String subjectSettings(Model model, @PathVariable String subjectCode) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Subject subject = subjectJDBCTemplate.getSubject(subjectCode);

        model.addAttribute("username", auth.getName());
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("subjectname", subject.getName());
        model.addAttribute("subjectTaskNr", subject.getNrOfTasks());
        model.addAttribute("isTeacher", true);

        return "subjectSettings";
    }

    @RequestMapping(value = "/access/usersearch", method = RequestMethod.GET)
    public String userSearch(
            @RequestParam(value = "con", required = false) String con, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("rooms", roomJDBCTemplate.listRoom());
        model.addAttribute("usercons", userJDBCTemplate.listUsersCon(con));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        // Check for admin rights
        boolean admin = false;
        boolean teacher = false;
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
        }
        return "usersearch";
    }
}
