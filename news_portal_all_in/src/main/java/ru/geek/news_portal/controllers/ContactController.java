/**
 * @Author Ostrovskiy Dmitriy
 * @Created 31/03/2020
 * ContactController for ContactUs Page
 * @version v1.0
 */

package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geek.news_portal.services.ContactService;
import ru.geek.news_portal.utils.SystemUser;

import javax.validation.Valid;

@Controller
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController (ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String contact() {

        return "ui/contact";
    }

    @PostMapping("/contact")
    public String processRegistrationForm(@Valid @ModelAttribute("systemUser") SystemUser systemUser,
                                          BindingResult bindingResult, Model model) {

        bindingResult.getAllErrors().forEach(System.out::println);

        String name = systemUser.getUsername();
        String email = systemUser.getEmail();
        if (bindingResult.hasErrors()) {
            return "ui/contact";
        }

        if (contactService.isNameExists(name))  {
            model.addAttribute("systemUser", systemUser);
            model.addAttribute("registrationError", "Username already exists!");
            return "ui/contact";
        }

        if (contactService.isEmailExists(email)) {
            model.addAttribute("systemUser", systemUser);
            model.addAttribute("registrationError", "Email already exists!");
            return "ui/contact";
        }

        contactService.save(systemUser);
        return "redirect:/contact";
    }

}
