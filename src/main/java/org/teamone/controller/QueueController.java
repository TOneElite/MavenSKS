package org.teamone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamone.domain.Queue.Queue;
import org.teamone.domain.Queue.QueueGroup;
import org.teamone.domain.Queue.QueueJDBCTemplate;

@Controller
public class QueueController {

    @Autowired
    private QueueJDBCTemplate queueJDBCTemplate;

    @RequestMapping(value = "/access/testqueue", method = RequestMethod.POST)
    public String form(
            @RequestParam("room") String room,
            @RequestParam("table") String table,
            @RequestParam("task") int[] tasks,
            @RequestParam("groupMembers") String[] group,
            @RequestParam("comment") String comment,
            @RequestParam("subjectCode") String subjectCode) {

        Queue queue = new Queue();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        /* Group, Task handler */
        if (group.length <= 1) {
            group[0] = auth.getName(); // Changes "Alene" to the current users name
            queue.setUsers(auth.getName());
        } else {
            String groupString = "";
            for (int i = 0; i < group.length; i++) {
                if (i == (group.length - 1)) {
                    groupString += group[i];
                } else {
                    groupString += group[i] + ", ";
                }
            }
            group[0] = auth.getName(); // Changes "Alene" to the current users name
            queue.setUsers(groupString);
        }

        QueueGroup queueGroup = new QueueGroup();
        queueGroup.setUsers(group);
        queueGroup.setTaskNrs(tasks);

        /* Location handler */
        room = room.split("#")[0];
        if (room.equals("Se kommentar")) {
            queue.setLocation("Se kommentar");
        } else {
            queue.setLocation(room + ", " + table);
        }

        /* Comment, date, status and subject code handler */
        queue.setComment(comment);
        queue.setDate(new java.sql.Date(new java.util.Date().getTime()));
        queue.setStatus("Venter");
        queue.setSubjectCode(subjectCode);
        queueJDBCTemplate.create(queue, queueGroup);
        return "redirect:" + subjectCode;
    }
    
    @RequestMapping(value = "/access/delete")
    public String deleteQueueTag(@RequestParam int id, Model model){
        Queue q = queueJDBCTemplate.getQueue(id);        
        queueJDBCTemplate.delete(id);
        return "redirect:/access/" + q.getSubjectCode();
    }
}
