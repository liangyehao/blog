package com.liang.user.controller;

import com.liang.user.domain.User;
import com.liang.user.repositotry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liangyehao
 * @date 2020-01-17 16:00
 * @version 1.0.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView userList(Model model) {
        model.addAttribute("userList", userRepository.findUserList());
        model.addAttribute("title", "用户列表");
        return new ModelAndView("user/list", "userModel", model);
    }

    @GetMapping("/{id}")
    public ModelAndView findUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.findUser(id));
        model.addAttribute("title", "用户详情");
        return new ModelAndView("user/view", "userModel", model);
    }

    @GetMapping("/modify/{id}")
    public ModelAndView creatForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.findUser(id));
        model.addAttribute("title", "修改用户");
        return new ModelAndView("user/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user, Model model) {
        model.addAttribute("user", userRepository.saveOrUpdateUser(user));
        model.addAttribute("title", "用户列表");
        return new ModelAndView("redirect:/users", "userModel", model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id, Model model) {
        userRepository.deleteUser(id);
        model.addAttribute("title", "用户列表");
        return new ModelAndView("redirect:/users", "userModel", model);
    }

    @GetMapping("/create")
    public ModelAndView createForm(User user, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建新用户");
        return new ModelAndView("user/form", "userModel", model);
    }
}
