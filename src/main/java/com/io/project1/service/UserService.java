package com.io.project1.service;

import com.io.project1.entity.UserMongo;
import com.io.project1.entity.UserMysql;
import com.io.project1.repository.UserMongoRepository;
import com.io.project1.repository.UserMysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    /*Quando usar @Autowired(Injeção de Dependencia), não precisa criar o construtor da classe */
    @Autowired
    UserMongoRepository userMongoRepository;

    /*Quando usar @Autowired(Injeção de Dependencia), não precisa criar o construtor da classe */
    @Autowired
    UserMysqlRepository userMysqlRepository;

    public List<UserMongo> findAllUserMongo() {
        /*Essa classe é a de regra de negocio, se precisar por exemplo ordenar essa lista, a regra ficaria aqui*/
        return userMongoRepository.findAll();
    }

    public UserMongo findAllUserMongoByName(final String name) {
        /*Essa classe é a de regra de negocio, se precisar por exemplo ordenar essa lista, a regra ficaria aqui*/
        return userMongoRepository.findByName(name);
    }

    public List<UserMysql> findAllUserMysql() {
        /*Essa classe é a de regra de negocio, se precisar por exemplo ordenar essa lista, a regra ficaria aqui*/
        return userMysqlRepository.findAll();
    }

    public UserMysql findAllUserMysqlByName(final String name) {
        /*Essa classe é a de regra de negocio, se precisar por exemplo ordenar essa lista, a regra ficaria aqui*/
        return userMysqlRepository.findByName(name);
    }

}
