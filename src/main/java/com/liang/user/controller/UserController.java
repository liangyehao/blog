package com.liang.user.controller;

import com.liang.user.domain.User;
import com.liang.user.repositotry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @author liangyehao
 * @date 2020-01-17 16:00
 * @version 1.0.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * 查询用户资源库
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 用户列表接口
     *
     * @param model 视图
     * @return list页面
     */
    @GetMapping
    public ModelAndView userList(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户列表");
        return new ModelAndView("user/list", "userModel", model);
    }

    /**
     * @param id    用户id
     * @param model 视图
     * @return view页面
     */
    @GetMapping("/{id}")
    public ModelAndView findUserById(@PathVariable("id") Long id, Model model) {
        Optional<User> optionalUser = userRepository.findById(id);
        User returnUser = optionalUser.orElseGet(() -> new User(null, null, null));
        model.addAttribute("user", returnUser);
        model.addAttribute("title", "用户详情");
        return new ModelAndView("user/view", "userModel", model);
    }

    /**
     * @param id    用户主键
     * @param model 视图
     * @return form页面
     */
    @GetMapping("/modify/{id}")
    public ModelAndView creatForm(@PathVariable("id") Long id, Model model) {
        Optional<User> optionalUser = userRepository.findById(id);
        User returnUser = optionalUser.orElseGet(() -> new User(null, null, null));
        model.addAttribute("user", returnUser);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("user/form", "userModel", model);
    }

    /**
     * @param user  需要保存或更新的用户实体
     * @param model 视图
     * @return list页面
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user, Model model) {
        model.addAttribute("user", userRepository.save(user));
        model.addAttribute("title", "用户列表");
        return new ModelAndView("redirect:/users", "userModel", model);
    }

    /**
     *
     * @param id 用户id
     * @param model 视图
     * @return list页面
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id, Model model) {
        userRepository.deleteById(id);
        model.addAttribute("title", "用户列表");
        return new ModelAndView("redirect:/users", "userModel", model);
    }

    /**
     *
     * @param model 视图
     * @return form页面
     */
    @GetMapping("/create")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null, null, null));
        model.addAttribute("title", "创建新用户");
        return new ModelAndView("user/form", "userModel", model);
    }
}
