package com.liang.user.controller;

import com.liang.user.repositotry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
