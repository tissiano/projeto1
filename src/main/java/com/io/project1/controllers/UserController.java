package com.io.project1.controllers;

import com.io.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
