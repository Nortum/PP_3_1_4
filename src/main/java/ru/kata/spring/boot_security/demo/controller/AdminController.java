package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String index(Model model, Principal principal) {
        model.addAttribute("current_user", userService.getUserByName(principal.getName()));
        model.addAttribute("users", userService.getAllUser());
        model.addAttribute("rolesList", roleService.getAll());
        model.addAttribute("newUser", new User());
        return "admin";
    }

//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        model.addAttribute("rolesList", roleService.getAll());
//        return "admin";
//    }
//
//    @PatchMapping("/update/{id}")
//    public String update(@ModelAttribute("user") User user,
//                         @PathVariable("id") int id,
//                         @RequestParam String[] roles1) {
//        List<Role> listroles = new ArrayList<>();
//        for (String s : roles1) {
//            listroles.add(roleService.getByName(s));
//        }
//        user.setRoles(listroles);
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userService.deleteUserById(id);
//        return "redirect:/admin";
//    }
//
////    @PostMapping
////    public String create(@ModelAttribute("user") User user, @RequestParam String[] roles1) {
////        List<Role> listroles = new ArrayList<>();
////        for (String s : roles1) {
////            listroles.add(roleService.getByName(s));
////        }
////        user.setRoles(listroles);
////        userService.addUser(user);
////        return "redirect:/admin";
////    }
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute("user") User user, @RequestParam String[] roles1) {
//        List<Role> listroles = new ArrayList<>();
//        for (String s : roles1) {
//            listroles.add(roleService.getByName(s));
//        }
//        user.setRoles(listroles);
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
}