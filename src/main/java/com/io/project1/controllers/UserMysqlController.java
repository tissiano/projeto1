package com.io.project1.controllers;

import com.io.project1.repository.UserMysqlRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserMysqlController {

    private final UserMysqlRepository userMysqlRepository;

    public UserMysqlController(final UserMysqlRepository userMysqlRepository) {
        this.userMysqlRepository = userMysqlRepository;
    }

    @RequestMapping("/userMysql")
    public String getUsersMySql(final Model model) {
        model.addAttribute("userList", userMysqlRepository.findAll());
        return "userMysql";
    }

}
