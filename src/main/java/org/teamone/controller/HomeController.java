package org.teamone.controller;

import java.util.Date;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamone.domain.Queue;
import org.teamone.domain.QueueJDBCTemplate;
import org.teamone.domain.RoomJDBCTemplate;
import org.teamone.domain.UserJDBCTemplate;
import org.teamone.domain.SubjectJDBCTemplate;

@Controller
public class HomeController {

    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("rooms", roomJDBCTemplate.listRoom());
        model.addAttribute("users", userJDBCTemplate.listUsers());
        model.addAttribute("queues", queueJDBCTemplate.listQueue());
        model.addAttribute("subjects", subjectJDBCTemplate.listSubjects());
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/open/passwordReset", method = RequestMethod.GET)
    public String forgotPassword() {
        return "passwordReset";
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
    
   @RequestMapping("/lagre")
    public String nyView(@ModelAttribute(value="queue") Queue queue){
        queueJDBCTemplate.create(queue);
        return "lagre";
    }
    
    @RequestMapping("/access/change-password")
    public String changePasswordView(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "change-password";
    }
    
    @RequestMapping(value="/access/change-password/process", method = RequestMethod.POST)
    public String changePasswordProcess(
            @RequestParam(value="oldPassword")String oldPassword,
            @RequestParam(value="newPassword")String newPassword,
            @RequestParam(value="repeatPassword")String repeatPassword,
            Model model){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Get old password from database
        org.teamone.domain.User user = userJDBCTemplate.getUserByEmail(auth.getName());
        String dbOldPassword = user.getPassword();
        
        boolean error = false;
        if(dbOldPassword.equals(oldPassword)){
            if(newPassword.equals(repeatPassword)){
                user.setPassword(newPassword);
                userJDBCTemplate.updateUser(user);
                return "redirect:/access/home";
            }else{
                error = true;
                model.addAttribute("error", error);
                model.addAttribute("errorMessage", "Passordene er ikke like.");
                return "change-password";
            }
        }else{
            error = true;
            model.addAttribute("error", error);
            model.addAttribute("errorMessage", "Gammelt passord er feil.");
            return "change-password";
        }
    }
   
   @RequestMapping(value="/access/testqueue", method = RequestMethod.POST)
   public String form(@RequestParam("room") String room,
   @RequestParam("table") String table,
   @RequestParam("task")String[] task,
   @RequestParam("group") String group,
   @RequestParam("comment") String comment){
       String tasks = "";
       for(int i = 0; i < task.length; i++){
           tasks += task[i] + ", ";
       }
       Queue queue = new Queue();
       queue.setTables(room + ", " + table);
       queue.setOv(tasks);
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if(group.equals("Alene")){
           queue.setUsers(auth.getName());
       }else{
           queue.setUsers(group);
       }
       queue.setComment(comment);
       Date a = new Date();
       queue.setDate(a);
       queue.setStatus(1);
       queueJDBCTemplate.create(queue);
       return "redirect:home";
   }
   
   @RequestMapping(value="/open/passwordReset/process")
   public String processPasswordReset(@RequestParam("emailReset")String emailReset){
       
       
       return "redirect:/login";
   }
   
}
