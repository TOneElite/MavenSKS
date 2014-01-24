package org.teamone.controller;

import javax.mail.MessagingException;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamone.logic.EmailService;
import org.teamone.domain.User.UserJDBCTemplate;
import org.teamone.domain.Role.RoleJDBCTemplate;

@Controller
public class AccountController {

    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    @Autowired
    private RoleJDBCTemplate roleJDBCTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/open/passwordReset", method = RequestMethod.GET)
    public String forgotPassword() {
        return "passwordReset";
    }

    @RequestMapping("/access/change-password")
    public String changePasswordView(Model model) {
        menuItems(model);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "change-password";
    }

    @RequestMapping(value = "/access/change-password/process", method = RequestMethod.POST)
    public String changePasswordProcess(
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "repeatPassword") String repeatPassword,
            Model model) {
        
        menuItems(model);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Get old password from database
        org.teamone.domain.User.User user = userJDBCTemplate.getUserByEmail(auth.getName());
        String dbOldPassword = user.getPassword();

        boolean error = false;
        if (dbOldPassword.equals(oldPassword)) {
            if (newPassword.equals(repeatPassword)) {
                user.setPassword(newPassword);
                userJDBCTemplate.updateUser(user);
                return "redirect:/access/home";
            } else {
                error = true;
                model.addAttribute("error", error);
                model.addAttribute("errorMessage", "Passordene er ikke like.");
                return "change-password";
            }
        } else {
            error = true;
            model.addAttribute("error", error);
            model.addAttribute("errorMessage", "Gammelt passord er feil.");
            return "change-password";
        }
    }

    @RequestMapping(value = "/open/passwordReset/process")
    public String processPasswordReset(@RequestParam("emailReset") String emailReset, Model model) throws MessagingException {
        menuItems(model);
        String password = RandomStringUtils.random(8, true, true);
        String email = "Hei, \n det nye passordet ditt er : "
                + password + "\n Ha en fin dag!ø \n Mvh.\nSKS";
        boolean valid = userJDBCTemplate.setPassword(password, emailReset);
        boolean error = false;
        boolean check = false;

        if (valid) {
            EmailService es = new EmailService("noreply.skssystem@gmail.com", "weareteamone");
            es.sendMail(emailReset, "Reset password notification", email);

            check = true;
            model.addAttribute("check", check);
            model.addAttribute("infoMessage", "Passordet er sendt til eposten du registerte");
            return "passwordReset";
        } else {
            error = true;
            model.addAttribute("error", error);
            model.addAttribute("errorMessage", "Eposten er feil");
            return "passwordReset";
        }
    }

    private void menuItems(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("studentsubjects", roleJDBCTemplate.getStudentSubjects(auth.getName()));
        model.addAttribute("teachersubjects", roleJDBCTemplate.getTeacherSubjects(auth.getName()));
    }
}
