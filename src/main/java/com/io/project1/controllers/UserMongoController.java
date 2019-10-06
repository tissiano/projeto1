package com.io.project1.controllers;

import com.io.project1.repository.UserMongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserMongoController {

    private final UserMongoRepository userMongoRepository;

    public UserMongoController(final UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @RequestMapping("/userMongo")
    public String getUsersMongo(final Model model) {
        model.addAttribute("userList", userMongoRepository.findAll());
        return "userMongo";
    }
}
