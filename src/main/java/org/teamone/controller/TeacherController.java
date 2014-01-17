package org.teamone.controller;

import java.util.StringTokenizer;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/access/teacherQueue")
    public String teacherQueue(Model model) {
        model.addAttribute("queues", queueJDBCTemplate.listQueue());
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        return "teacherQueue";
    }

    @RequestMapping("/access/eksamensrapport")
    public String examOverview() {
        return "eksamensrapport";
    }

    @RequestMapping(value = "/access/approveInQueue", method = RequestMethod.POST)
    public String teacherQueuePost(
            @RequestParam(value = "remove", required = false) String remove,
            @RequestParam(value = "postpone", required = false) String postpone,
            @RequestParam(value = "help", required = false) String help,
            @RequestParam(value = "approve", required = false) String approve,
            @RequestParam("queueId") String queueId,
            Model model) {
        int id = Integer.parseInt(queueId);
        if (remove != null) {
            queueJDBCTemplate.delete(id);
            model.addAttribute("queues", queueJDBCTemplate.listQueue());
        }
        if (postpone != null) {
            queueJDBCTemplate.status(id, 2);
            model.addAttribute("queues", queueJDBCTemplate.listQueue());
        }
        if (help != null) {
            queueJDBCTemplate.status(id, 3);
            model.addAttribute("queues", queueJDBCTemplate.listQueue());
        }
        if (approve != null) {
            model.addAttribute("queue", queueJDBCTemplate.getQueue(id));
            return "approveInQueue";
        }
        return "teacherQueue";
    }
    
    @RequestMapping(value = "/access/readfile")
    public String readfile(){
        return "readfile";
    }
    
    @RequestMapping(value = "/access/fileread", method = RequestMethod.POST)
    public String fileread(
            @RequestParam("output") String fileread){
        StringTokenizer stringTokenizer = new StringTokenizer(fileread);
        String forr = stringTokenizer.nextToken();
        String last = stringTokenizer.nextToken();
        String email = stringTokenizer.nextToken();
        String pw = stringTokenizer.nextToken();
        String[] words= fileread.split("\\s+");
        User user = new User();
        Role role = new Role();
        for(int i = 0; i < (words.length/4) - 1; i++){
            forr = stringTokenizer.nextToken().replace("_", " ");
            user.setFirstName(forr);
            last = stringTokenizer.nextToken().replace("_", " ");
            user.setSurname(last);
            email = stringTokenizer.nextToken();
            user.setEmail(email);
            pw = stringTokenizer.nextToken();
            user.setPassword(pw);
            role.setRoleName("ROLE_USER");
            role.setUsername(email);
            userJDBCTemplate.create(user);
            roleJDBCTemplate.create(role);
        }
        return "redirect:home";
    }

    @RequestMapping(value = "/access/teacherQueue", method = RequestMethod.POST)
    public String approve(
            @RequestParam(value = "cancel", required = false) String cancel,
            @RequestParam(value = "approved", required = false) String approve,
            @RequestParam("task") String[] tasks,
            @RequestParam("queueId") String queueId,
            Model model) {
        if (cancel != null) {
            model.addAttribute("queues", queueJDBCTemplate.listQueue());
            return "teacherQueue";
        }
        if (approve != null) {
            for (int i = 0; i < tasks.length; i++) {
                String[] temp = tasks[i].split(", ");
                UserTask userTask = new UserTask();
                userTask.setEmail(temp[0]);
                userTask.setSubjectCode("TDAT1005");
                userTask.setTaskNr(Integer.parseInt(temp[1]));
                userTasksJDBCTemplate.approve(userTask);
            }
            queueJDBCTemplate.delete(Integer.parseInt(queueId));
            model.addAttribute("queues", queueJDBCTemplate.listQueue());
            return "teacherQueue";

        }
        return "teacherQueue";
    }
}

