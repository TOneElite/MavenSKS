package org.teamone.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamone.domain.Queue;
import org.teamone.domain.QueueJDBCTemplate;

@Controller
public class QueueController {
    
    @Autowired
    private QueueJDBCTemplate queueJDBCTemplate;
    
    @RequestMapping(value = "/access/testqueue", method = RequestMethod.POST)
    public String form(@RequestParam("room") String room,
            @RequestParam("table") String table,
            @RequestParam("task") String[] task,
            @RequestParam("group") String group,
            @RequestParam("comment") String comment) {
        String tasks = "";
        for (int i = 0; i < task.length; i++) {
            tasks += task[i] + ", ";
        }
        Queue queue = new Queue();
        queue.setTables(room + ", " + table);
        queue.setOv(tasks);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (group.equals("Alene")) {
            queue.setUsers(auth.getName());
        } else {
            queue.setUsers(group);
        }
        queue.setComment(comment);
        Date a = new Date();
        queue.setDate(a);
        queue.setStatus(1);
        queueJDBCTemplate.create(queue);
        return "redirect:home";
    }
    
    @RequestMapping("/lagre")
    public String nyView(@ModelAttribute(value = "queue") Queue queue) {
        queueJDBCTemplate.create(queue);
        return "lagre";
    }
    
}
