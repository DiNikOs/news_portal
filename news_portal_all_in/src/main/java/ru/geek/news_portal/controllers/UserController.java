package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.RoleRepository;
import ru.geek.news_portal.dto.NewPasswordDTO;
import ru.geek.news_portal.dto.UpdatePasswordDTO;
import ru.geek.news_portal.dto.UserAccountDTO;
import ru.geek.news_portal.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.03.2020
 * @link https://github.com/Centnerman
 * fix Dmitriy Ostrovskiy
 */

@Controller
public class UserController {
    private final RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public UserController(RoleRepository roleRepository,
                          UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/edituser", "/user/edituser/{username}"})
    public String editUserGet(Model model, @PathVariable(value = "username", required = false) String username,
                              Principal principal, HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        UserAccountDTO userDTO;

        if (username == null || (principal.getName().equals(username) && userService.isUserExist(username))) {
            userDTO = userService.userToDTO(principal.getName());
            model.addAttribute("user", userDTO);
        } else {
            return "redirect:/";
        }
//        model.addAttribute("edit", true);
        return "ui/personal";
    }

    //-------------------------------------------------------------------------------

    @PostMapping("/user/edituser")
    public String editUserPost(Model model, @ModelAttribute("user") @Valid UserAccountDTO userAccountDTO,
                               Principal principal, HttpServletRequest request) {
//        if (!request.isRequestedSessionIdValid()) {
//            return "ui/personal";
//        }
        if (!userAccountDTO.getUsername().equals(principal.getName())) {
            model.addAttribute("error","Username wrong");
        } else if (userAccountDTO.getFirstName().length() < 2 || userAccountDTO.getFirstName() == null) {
            model.addAttribute("error", "The first name must be longer than or equal to 1 characters");
        } else if (userAccountDTO.getLastName().length() < 2 || userAccountDTO.getLastName() == null) {
            model.addAttribute("error", "The last name must be longer than or equal to 1 characters");
        } else if (userAccountDTO.getEmail().length() < 6 || userAccountDTO.getEmail() == null) {
            model.addAttribute("error", "The email is not correctly");
        } else {
            userService.saveDTO(userAccountDTO);
            model.addAttribute("success", "The changing succesful");
        }
        model.addAttribute("user", userService.userToDTO(principal.getName()));
        return "ui/personal";
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/favorite", "/user/favorite/{username}"})
    public String userFavorites(Model model, @PathVariable(value = "username", required = false) String username,
                                HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        model.addAttribute("user", userService.findByUsername(username));
        return "ui/user_favorites";
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/comment", "/user/comment/{username}"})
    public String userComments(Model model, @PathVariable(value = "username", required = false) String username,
                               HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        model.addAttribute("user", userService.findByUsername(username));
        return "ui/user_comments";
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/change_password", "/user/change_password/{username}"})
    public String userChangePassword(Model model, @PathVariable(value = "username", required = false) String username,
                                        HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        return "ui/changepass";
    }

    //-------------------------------------------------------------------------------

    @PostMapping("/user/change_password")
    public String userChangePassword(@ModelAttribute("password") @Valid UpdatePasswordDTO updatePasswordDTO,
                                         BindingResult bindingResult, Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());

        if (!userService.checkPassword(user, updatePasswordDTO.getOldPassword())) {
            model.addAttribute("error", "Wrong current password");
            return "ui/changepass";
        }

        if (!updatePasswordDTO.getNewPassword().equals(updatePasswordDTO.getMatchingPassword())) {
            model.addAttribute("error", "The password fields must match");
            return "ui/changepass";
        }

        userService.updatePassword(user, updatePasswordDTO.getNewPassword());
        model.addAttribute("success", "The password change successful");
        return "ui/changepass";
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/setting", "/user/setting/{username}"})
    public String userSettings(Model model, @PathVariable(value = "username", required = false) String username,
                               HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        model.addAttribute("user", userService.findByUsername(username));
        return "ui/settings";
    }

    //-------------------------------------------------------------------------------

    @GetMapping("/forgot")
    public String forgotPassword() {
        return "ui/forgot";
    }

    //-------------------------------------------------------------------------------

    @GetMapping("/reset")
    public String resetPassword(Model model, Principal principal) {
        return "ui/reset";
    }

    //-------------------------------------------------------------------------------

    @PostMapping("/reset")
    public String resetPassword(@ModelAttribute("password") NewPasswordDTO newPassword,
                        Principal principal, Model model) {

        User user = userService.findByUsername(principal.getName());

        if (!newPassword.getNewPassword().equals(newPassword.getMatchingPassword())) {
            model.addAttribute("error", "The password fields must match");
            return "ui/reset";
        }

        userService.updatePassword(user, newPassword.getNewPassword());
        model.addAttribute("success", "The password change successful");

        return "ui/reset";
    }

    //-------------------------------------------------------------------------------
}
