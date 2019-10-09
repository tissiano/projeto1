package com.io.project1.config;

import com.io.project1.entity.UserMongo;
import com.io.project1.entity.UserMysql;
import com.io.project1.repository.UserMongoRepository;
import com.io.project1.repository.UserMysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserMysqlRepository userMysqlRepository;

    @Autowired
    UserMongoRepository userMongoRepository;

    /*Exemplo de como acessar as variaveis do application.properties*/
    @Value("${titi.name}")
    private String name;
    @Value("${titi.email}")
    private String email;

    /*Exemplo de como acessar as variaveis do application.yml*/
    @Value("${supportUser.name}")
    private String supportName;
    @Value("${supportUser.email}")
    private String supportEmail;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("================> DataInitializer - SEMPRE executa esse método quando iniciar a aplicação");

        /* mongoDB */
        // Busca todos registros da tabela User no Mongo
        final List<UserMongo> usersMongo = userMongoRepository.findAll();

        // Se nao existir registro, faz o insert do registro abaixo no Mongo
        if (usersMongo.isEmpty()) {
            createUserByNameAndEmail(name, email, false);
            createUserByNameAndEmail(supportName, supportEmail, false);
            createUserByNameAndEmail("teste", "teste@gmail.com", false);
            createUserByNameAndEmail("blablabla", "lorena@gmail.com", false);
            createUserByNameAndEmail("delete", "delete@gmail.com", false);
        }
/*
        // Busca o registro por nome
        final UserMongo userMongo2 = userMongoRepository.findByName("teste");
        System.out.println("FindByName no Mongo:: " + userMongo2.getName());

        // Deleta o registro por nome
        userMongoRepository.deleteByName("delete");

        // Alterar o registro de name = blablabla
        final UserMongo userMongo3 = userMongoRepository.findByName("blablabla");
        userMongo3.setName("Lorena");
        userMongoRepository.save(userMongo3);

        // Busca o registro de email = lorena@gmail.com
        final UserMongo userMongo4 = userMongoRepository.findByEmailCustomizado("lorena@gmail.com");
        System.out.println("findByEmailCustomizado no Mongo: " + userMongo4.getEmail());
*/


        /* MySql */
        // Busca todos registros da tabela User no Mysql
        final List<UserMysql> usersMysql = userMysqlRepository.findAll();

        // Se nao existir registro, faz o insert do registro abaixo no Mysql
        if (usersMysql.isEmpty()) {
            createUserByNameAndEmail(name, email, true);
            createUserByNameAndEmail(supportName, supportEmail, true);
            createUserByNameAndEmail("teste", "teste@gmail.com", true);
            createUserByNameAndEmail("blablabla", "lorena@gmail.com", true);
            createUserByNameAndEmail("delete", "delete@gmail.com", true);
        }
/*
        // Busca o registro por id
        final UserMysql userMysql = userMysqlRepository.getOne(1L);
        System.out.println("getOne no Mysql: " + userMysql.getName());

        // Deleta o registro de ID = 3
        userMysqlRepository.deleteById(3L);

        // Alterar o registro de name = blablabla
        final UserMysql userMysql3 = userMysqlRepository.findByName("blablabla");
        userMysql3.setName("Lorena");
        userMysqlRepository.save(userMysql3);

        // Busca o registro de email = lorena@gmail.com
        final UserMysql userMysql2 = userMysqlRepository.findByName("Lorena");
        System.out.println("findByName no mySql: " + userMysql2.getName());

        // Busca o registro de email = lorena@gmail.com
        final UserMysql userMysql4 = userMysqlRepository.findByEmailCustomizado("lorena@gmail.com");
        System.out.println("findByEmailCustomizado no Mysql: " + userMysql4.getEmail());

        // Busca o registro de email con like = lorena@gmail.com
        final UserMysql userMysql5 = userMysqlRepository.findByEmailLike("teste");
        System.out.println("findByEmailLike no Mysql: " + userMysql5.getEmail());
*/
    }

    public void createUserByNameAndEmail(final String name, final String email, final Boolean isMysql) {

        // Salva o registro
        if (isMysql) {
            final UserMysql user = new UserMysql(name, email);
            userMysqlRepository.save(user);
        } else {
            final UserMongo user = new UserMongo(name, email);
            userMongoRepository.save(user);
        }
    }
}
