package com.io.project1.repository;

import com.io.project1.entity.RoleMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMysqlRepository extends JpaRepository<RoleMysql, Long> {
    // cria um metodo customizado com base na propriedade name da entidade user
    // mais exemplos em: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    RoleMysql findByName(String name);

}
