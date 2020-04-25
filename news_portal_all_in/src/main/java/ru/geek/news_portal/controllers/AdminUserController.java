package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.RoleRepository;
import ru.geek.news_portal.dto.UserAccountDTO;
import ru.geek.news_portal.dto.UserModifyDTO;
import ru.geek.news_portal.services.UserService;
import ru.geek.news_portal.utils.SystemUser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 05.04.2020
 * @link https://github.com/Centnerman
 */

// Работаем с пользователями имея права админа -------------------------------------------

@Controller
public class AdminUserController {

    private final RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public AdminUserController(RoleRepository roleRepository,
                               UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    //---------------------------------------------------------------------------

    @GetMapping("/users")
    public String usersPage(Model model, HttpServletRequest request) {
//        if (!request.isUserInRole("ADMIN")) {
//            return "redirect:/";
//        }
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    //---------------------------------------------------------------------------

    @GetMapping({"/users/edit_user", "/users/edit_user/{id}"})
    public String editUser(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
//        if (!request.isRequestedSessionIdValid()) {
//            return "redirect:/";
//        }
        model.addAttribute("edit", true);
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "oneuser";
    }

    //---------------------------------------------------------------------------

    @GetMapping({"/users/create_user"})
    public String createUser(Model model) {
        UserModifyDTO userDTO = new UserModifyDTO();
        userDTO.setRoles(Arrays.asList(roleRepository.findOneByName("READER")));
        model.addAttribute("create", true);
        model.addAttribute("user", userDTO);
        model.addAttribute("roles", roleRepository.findAll());
        return "oneuser";
    }

    //---------------------------------------------------------------------------

    @PostMapping("/users/update_user")
    public String updateUser(@Valid @ModelAttribute("user") UserModifyDTO userDTO,
                             BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "users";
//        }
        userService.updateDTO(userDTO);
        model.addAttribute("users", userService.findAll());
        return "/users";
    }

    //---------------------------------------------------------------------------

    @GetMapping("/users/delete_user/{id}")
    public String deleteUser(Model model, @PathVariable("id") Long id) {
        userService.delete(id);
        model.addAttribute("users", userService.findAll());
        return "users";
    }
}
