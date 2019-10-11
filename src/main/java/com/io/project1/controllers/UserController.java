package com.io.project1.controllers;

import com.io.project1.entity.UserMongo;
import com.io.project1.entity.UserMysql;
import com.io.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    // @Autowired
    // private UserMongoRepository userMongoRepository;

    // @Autowired
    // private UserMysqlRepository userMysqlRepository;

    /* Se não usar o @Autowired(Injeção de Dependencia) acima, precisa criar o constutor abaixo
    public UserMongoController(final UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    public UserMysqlController(final UserMysqlRepository userMysqlRepository) {
        this.userMysqlRepository = userMysqlRepository;
    }
    */

    /*Quando usar @Autowired(Injeção de Dependencia), não precisa criar o construtor da classe */
    /*Utilizando a camada de serviço no controller ao invés de chamar o repository diretamente*/
    @Autowired
    private UserService userService;
    private UserMongo userMongo;

    @RequestMapping("/userMongo")
    public String getUsersMongo(final Model model) {
        /*por causa da DI(Injeção de Dependencia), não precisa fazer this.userService = new UserService() */
        model.addAttribute("userList", userService.findAllUserMongo());
        return "userMongo"; //nome do html
    }

    @RequestMapping("/userMysql")
    public String getUsersMySql(final Model model) {
        /*por causa da DI(Injeção de Dependencia), não precisa fazer this.userService = new UserService() */
        model.addAttribute("userList", userService.findAllUserMysql());
        return "userMysql"; //nome do html
    }

    /*exemplo de RequestMapping, para cair nesse metodo abrir o link: http://localhost:8080/mapping*/
    @RequestMapping("/mapping")
    public String mapping() {
        System.out.println("Executou UserController.mapping()");
        return "mapping"; //nome do html
    }

    /*exemplo de chamada do controller no Application.java*/
    public String helloWorld() {
        System.out.println("Executou UserController.helloWorld()");
        return "helloWorld";
    }

    /*exemplos de métodos HTTP*/
    @GetMapping("/userMongoHttp")
    public String getUserMongoHttp(final Model model) {
        model.addAttribute("userMongo", new UserMongo());
        return "userMongoHttp"; // nome do html
    }

    @PostMapping("/userMongoHttp")
    public String userSubmitMongoHttp(@ModelAttribute final UserMongo userMongo) {
        return "resultMongoHttp"; // nome do html
    }

    @GetMapping("/userMysqlHttp")
    public String getUserMysqlHttp(final Model model) {
        model.addAttribute("userMysql", new UserMysql());
        return "userMysqlHttp"; // nome do html
    }

    @PostMapping("/userMysqlHttp")
    public String userSubmitMysqlHttp(@ModelAttribute final UserMysql userMysql) {
        return "resultMysqlHttp"; // nome do html
    }
}
