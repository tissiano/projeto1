package com.io.project1;

import com.io.project1.controllers.UserController;
import com.io.project1.demoQualifier.CarComponent;
import com.io.project1.demoQualifier.MotorcycleComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*exemplo de ComponentScan*/
@ComponentScan(basePackages = {"com.io.project1.service", "com.io.project1.controllers", "com.io.project1.demoQualifier"})
public class Project1Application {

    public static void main(final String[] args) {
        /* quando criamos um projeto novo, fica conforme abaixo */
        //SpringApplication.run(Project1Application.class, args);

        /* exemplo de SpringContext, ou seja, como chamar o controller direto da classe principal */
        final ApplicationContext applicationContext = SpringApplication.run(Project1Application.class, args);
        final UserController userController = (UserController) applicationContext.getBean("userController");
        userController.helloWorld();

        /* exemplo de uso da annotation @Qualifier("carBean") */
        final CarComponent carComponent = (CarComponent) applicationContext.getBean("carComponent");
        carComponent.service();

        /* exemplo de uso da annotation @Qualifier("motorcycleBean") */
        final MotorcycleComponent motorcycleComponent = (MotorcycleComponent) applicationContext.getBean("motorcycleComponent");
        motorcycleComponent.service();

        /*exemplo de RequestMapping, para cair novamente nesse metodo abrir o link: http://localhost:8080/mapping*/
        userController.mapping();
    }

}
