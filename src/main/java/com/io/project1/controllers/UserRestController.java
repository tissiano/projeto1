package com.io.project1.controllers;

import com.io.project1.entity.UserMongo;
import com.io.project1.entity.UserMysql;
import com.io.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "userRestMongo", method = RequestMethod.GET)
    public List<UserMongo> getUsersMongo() {
        // por causa da DI(Injeção de Dependencia), não precisa fazer this.userService = new UserService()
        return userService.findAllUserMongo();
        // para executar esse metodo, chamar: http://localhost:8080/userRestMongo
    }

    @RequestMapping(value = "userRestMongo/{name}", method = RequestMethod.GET)
    public UserMongo getUsersMongoByName(@PathVariable final String name) {
        // por causa da DI(Injeção de Dependencia), não precisa fazer this.userService = new UserService()
        return userService.findAllUserMongoByName(name);
        // para executar esse metodo, chamar: http://localhost:8080/userRestMongo/Tissiano
    }

    @RequestMapping(value = "userRestMysql", method = RequestMethod.GET)
    public List<UserMysql> getUsersMySql() {
        // por causa da DI(Injeção de Dependencia), não precisa fazer this.userService = new UserService()
        return userService.findAllUserMysql();
        // para executar esse metodo, chamar: http://localhost:8080/userRestMysql
    }

    @RequestMapping(value = "userRestMysql/{name}", method = RequestMethod.GET)
    public UserMysql getUsersMySqlByName(@PathVariable final String name) {
        // por causa da DI(Injeção de Dependencia), não precisa fazer this.userService = new UserService()
        return userService.findAllUserMysqlByName(name);
        // para executar esse metodo, chamar: http://localhost:8080/userRestMysql/Tissiano
    }
}
