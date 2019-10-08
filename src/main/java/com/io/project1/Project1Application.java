package com.io.project1;

import com.io.project1.controllers.UserController;
import com.io.project1.demoQualifier.CarComponent;
import com.io.project1.demoQualifier.MotorcycleComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Project1Application {

    public static void main(final String[] args) {
        /* quando criamos um projeto novo, fica conforme abaixo */
        // SpringApplication.run(Project1Application.class, args);

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

    }

}
