package org.teamone.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamone.domain.Queue.Queue;
import org.teamone.domain.Queue.QueueJDBCTemplate;

@Controller
public class QueueController {
    
    @Autowired
    private QueueJDBCTemplate queueJDBCTemplate;
    
    @RequestMapping(value = "/access/testqueue", method = RequestMethod.POST)
    public String form(
            @RequestParam("room") String room,
            @RequestParam("table") String table,
            @RequestParam("task") String[] task,
            @RequestParam("groupList") String[] group,
            @RequestParam("comment") String comment, 
            @RequestParam("subjectCode") String subjectCode) {
        String tasks = "";
        room = room.split("#")[0];
        if (table == null) table = "asd";
        for (int i = 0; i < task.length; i++) {
            if (i==(task.length - 1)) {
                tasks += task[i];
            } else {
                tasks += task[i] + ", ";
            }
        }
        Queue queue = new Queue();
        queue.setLocation(room + ", " + table); // Has the name "location" in the database
        //queue.setOv(tasks);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (group.length <= 1) {
            queue.setUsers(auth.getName());
        } else {
            queue.setUsers(auth.getName()); // Insert loop with setUsers for each item in group, when database can handle it.
        }
        for (int i=0;i<group.length;i++) System.out.println(" *** " + group[i]);
        queue.setComment(comment);
        queue.setDate(new Date(new java.util.Date().getTime()));
        queue.setStatus("");
        queue.setSubjectCode(subjectCode);
        //queueJDBCTemplate.create(queue);
        return "redirect:"+subjectCode;
    }
    
    @RequestMapping("/lagre")
    public String nyView(@ModelAttribute(value = "queue") Queue queue) {
        //queueJDBCTemplate.create(queue);
        return "lagre";
    }
    
    @RequestMapping(value = "/access/{id}", method = RequestMethod.GET)
    public String remove(Model model, @PathVariable String id) {
        queueJDBCTemplate.delete(Integer.parseInt(id));
        return "home";
    }
    
}
