package com.io.project1.repository;

import com.io.project1.entity.UserMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMysqlRepository extends JpaRepository<UserMysql, Long> {
    // cria um metodo customizado com base na propriedade name da entidade user
    // mais exemplos em: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    UserMysql findByName(String name);

    @Query("select u from UserMysql u where u.email = ?1")
    UserMysql findByEmailCustomizado(String email);

    @Query("select u from UserMysql u where u.email like %?1%")
    UserMysql findByEmailLike(String email);
}
