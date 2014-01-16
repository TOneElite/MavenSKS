package org.teamone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamone.domain.QueueJDBCTemplate;

@Controller
public class TeacherController {

    @Autowired
    private QueueJDBCTemplate queueJDBCTemplate;

    @RequestMapping("/access/teacherQueue")
    public String teacherQueue(Model model) {
        model.addAttribute("queues", queueJDBCTemplate.listQueue());
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

}
