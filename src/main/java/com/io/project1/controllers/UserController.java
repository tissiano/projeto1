package com.io.project1.controllers;

import com.io.project1.repository.UserMongoRepository;
import com.io.project1.repository.UserMysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    /*Quando usar @Autowired(Injeção de Dependencia), não precisa criar o construtor da classe */
    @Autowired
    private UserMongoRepository userMongoRepository;

    @Autowired
    private UserMysqlRepository userMysqlRepository;

    /* Se não usar o @Autowired(Injeção de Dependencia) acima, precisa criar o constutor abaixo
    public UserMongoController(final UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    public UserMysqlController(final UserMysqlRepository userMysqlRepository) {
        this.userMysqlRepository = userMysqlRepository;
    }
    */

    @RequestMapping("/userMongo")
    public String getUsersMongo(final Model model) {
        model.addAttribute("userList", userMongoRepository.findAll());
        return "userMongo";
    }

    @RequestMapping("/userMysql")
    public String getUsersMySql(final Model model) {
        model.addAttribute("userList", userMysqlRepository.findAll());
        return "userMysql";
    }
}
