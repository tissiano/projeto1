package com.io.project1.repository;

import com.io.project1.entity.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserMongoRepository extends MongoRepository<UserMongo, Long> {
    // cria um metodo customizado com base na propriedade name da entidade user
    // mais exemplos em: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongodb.repositories.queries
    UserMongo findByName(String name);

    Long deleteByName(String name);

    @Query("{'email' : ?0}")
    UserMongo findByEmailCustomizado(String email);
}
