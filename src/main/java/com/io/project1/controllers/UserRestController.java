package com.io.project1.controllers;

import com.io.project1.entity.UserMongo;
import com.io.project1.entity.UserMysql;
import com.io.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    /*exemplos de RequestMethod.GET, RequestMethod.POST, @RequestBody e @PathVariable*/

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

    @RequestMapping(value = "userMongo", method = RequestMethod.POST)
    public UserMongo setUserMongo(@RequestBody final UserMongo userMongo) {
        return userMongo;
        // para testar: abrir o Postman no endereço localhost:8080/userMongo
        // e no body, inserir: {"name": "nomeX", "email": "nomeX@gmail.com"}

    }

    @RequestMapping(value = "userMysql", method = RequestMethod.POST)
    public UserMysql setUserMysql(@RequestBody final UserMysql userMysql) {
        return userMysql;
        // para testar: abrir o Postman no endereço localhost:8080/userMongo
        // e no body, inserir: {"name": "nomeX", "email": "nomeX@gmail.com"}

    }

}
