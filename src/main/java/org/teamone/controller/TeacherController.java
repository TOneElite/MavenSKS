package org.teamone.controller;

import java.util.Date;
import java.util.List;
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
import org.teamone.logic.RuleService;

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

    @RequestMapping(value = "/access/teacher{subjectCode}", method = RequestMethod.GET)
    public String teacherQueueView(Model model, @PathVariable String subjectCode
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("queues", queueJDBCTemplate.listQueue(subjectCode));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("currentS", subjectCode);
        model.addAttribute("thisSubject", subjectJDBCTemplate.getSubject(subjectCode));

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

    @RequestMapping(value = "/access/approveInQueue", method = RequestMethod.POST)
    public String options(
            @RequestParam(value = "empty", required = false) String empty,
            @RequestParam(value = "queueStatus", required = false) String queueStatus,
            @RequestParam(value = "remove", required = false) String remove,
            @RequestParam(value = "postpone", required = false) String postpone,
            @RequestParam(value = "help", required = false) String help,
            @RequestParam(value = "approve", required = false) String approve,
            @RequestParam(value = "queueId", required = false) String queueId,
            @RequestParam(value = "subjectCode", required = false) String subjectCode,
            @RequestParam(value = "currentSubject", required = false) String currentSubject,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String helper = "Får hjelp av " + auth.getName();
        model.addAttribute("username", auth.getName());

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

        if(empty != null){
            queueJDBCTemplate.empty(currentSubject);
        }
        if (queueStatus != null) {
            if (Integer.parseInt(queueStatus) == 0) {
                subjectJDBCTemplate.setStatus(1, currentSubject);
            } else {
                subjectJDBCTemplate.setStatus(0, currentSubject);
            }
        }
        if (remove != null) {
            int id = Integer.parseInt(queueId);
            queueJDBCTemplate.delete(id);
        }
        if (postpone != null) {
            int id = Integer.parseInt(queueId);
            queueJDBCTemplate.status("Utsatt", id);
        }
        if (help != null) {
            int id = Integer.parseInt(queueId);
            queueJDBCTemplate.status(helper, id);
        }
        if (approve != null) {
            int id = Integer.parseInt(queueId);
            model.addAttribute("current", currentSubject);
            model.addAttribute("queueInfo", QueueApproveJDBCTemplate.listQueueApproveID(id));
            return "approveInQueue";
        }
        return "redirect:/access/teacher" + currentSubject;
    }

    @RequestMapping(value = "/access/teacherQueue", method = RequestMethod.POST)
    public String approve(
            @RequestParam(value = "cancel", required = false) String cancel,
            @RequestParam(value = "approved", required = false) String approve,
            @RequestParam(value = "task", required = false) String[] tasks,
            @RequestParam(value = "currentSubject", required = false) String current,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());

        if (cancel != null) {
            return "redirect:/access/teacher" + current;
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

        }
        return "redirect:/access/teacher" + current;
    }

    @RequestMapping(value = "/access/readfile{subjectCode}", method = RequestMethod.GET)
    public String readfile(@PathVariable String subjectCode, Model model) {
        model.addAttribute("activeSubject", subjectCode);
        return "readfile";
    }

    @RequestMapping(value = "/access/fileread{subjectCode}", method = RequestMethod.POST)
    public String fileread(
            @RequestParam(value = "output", required = false) String fileread,
            @PathVariable String subjectCode) {
        if (fileread == null) {
            return "readfile";
        } else {
            String[] words = fileread.split("[,\\n]");
            User user = new User();
            Role role = new Role();
            List<Subject> subjects = subjectJDBCTemplate.listSubjects();
            UserRights userRights = new UserRights();
            Date date = new Date();
            Boolean error = false;
            int remove = words.length % 4;
            for (int i = 0; i < (words.length / 4); i++) {
                if (words[(i * 4) + 2].contains("@")) {
                } else {
                    JOptionPane.showMessageDialog(null, "There is an error in file format");
                    error = true;
                }
            }
            if (error == true) {
                return "admin";
            }
            int test = words.length - remove;
            for (int i = 0; i < (test / 4); i++) {
                user.setLastName(words[(i * 4)]);
                user.setFirstName(words[(i * 4) + 1]);
                user.setEmail(words[(i * 4) + 2]);
                role.setEmail(words[(i * 4) + 2]);
                user.setPassword(words[(i * 4) + 3]);
                role.setSubjectCode(subjectCode);
                System.out.println(subjectCode);
                role.setRoleName("ROLE_USER");
                user.setDate(date);
                userRights.setRole(role);
                List<User> users = userJDBCTemplate.listUsers();
                List<Role> roles = roleJDBCTemplate.getSubjectRoles(words[(i * 4) + 2]);
                Boolean exist = false;
                for (User email : users) {
                    if (email.getEmail().equals(user.getEmail())) {
                        exist = true;
                    }
                }
                if (exist == false) {
                    userJDBCTemplate.create(user);
                }
                Boolean rexist = false;
                for (Role rolee : roles) {
                    if (subjectCode.equals(rolee.getSubjectCode())) {
                        System.out.println(user.getEmail() + " code " + role.getSubjectCode() + " list " + rolee.getSubjectCode());
                        rexist = true;
                    }
                }
                if (rexist == false) {
                    roleJDBCTemplate.create(role);
                }
            }
            return "redirect:subjectSettings";
        }
    }

    /**
     * Proof on concept
     *
     * @param model
     * @param email
     * @param subjectCode
     * @return
     */
    @RequestMapping(value = "/access/vertifyTasks/{email}/{subjectCode}", method = RequestMethod.GET)
    public String vertifyTasksForStudent(Model model, @PathVariable String email, @PathVariable String subjectCode) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Subject subject = subjectJDBCTemplate.getSubject(subjectCode);
        List<ApprovedTasks> approvedTasks = approvedTasksJDBCTemplate.listApprovedTasks(email, subjectCode);

        boolean[] tasksDone = new boolean[subject.getNrOfTasks()];

        for (ApprovedTasks as : approvedTasks) {
            tasksDone[as.getTaskNr() - 1] = true;
        }

        boolean ready = new RuleService().vertifyRequirements(tasksDone, subject.getRules());

        System.out.println("Ready for exam?: " + ready);

        model.addAttribute("username", auth.getName());
        model.addAttribute("selectedSubject", subjectJDBCTemplate.getSubject(subjectCode));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("subjectname", subject.getName());
        model.addAttribute("subjectTaskNr", subject.getNrOfTasks());
        model.addAttribute("isTeacher", true);

        return "subjectSettings";
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

    @RequestMapping(value = "/access/subjectSettings{subjectCode}", method = RequestMethod.GET)
    public String subjectSettings(Model model, @PathVariable String subjectCode) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Subject subject = subjectJDBCTemplate.getSubject(subjectCode);

        model.addAttribute("username", auth.getName());
        model.addAttribute("selectedSubject", subjectJDBCTemplate.getSubject(subjectCode));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("subjectname", subject.getName());
        model.addAttribute("subjectTaskNr", subject.getNrOfTasks());
        model.addAttribute("isTeacher", true);

        return "subjectSettings";
    }

    @RequestMapping(value = "/access/examView{subjectCode}", method = RequestMethod.GET)
    public String examView(Model model, @PathVariable String subjectCode) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Subject subject = subjectJDBCTemplate.getSubject(subjectCode);

        model.addAttribute("username", auth.getName());
        model.addAttribute("selectedSubject", subjectJDBCTemplate.getSubject(subjectCode));
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        model.addAttribute("subjectname", subject.getName());
        model.addAttribute("subjectTaskNr", subject.getNrOfTasks());
        model.addAttribute("isTeacher", true);

        return "eksamensrapport";
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
