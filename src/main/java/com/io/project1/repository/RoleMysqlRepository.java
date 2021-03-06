package com.io.project1.repository;

import com.io.project1.entity.RoleMysql;
import com.io.project1.entity.StatusRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMysqlRepository extends JpaRepository<RoleMysql, Long> {
    // cria um metodo customizado com base na propriedade name da entidade user
    // mais exemplos em: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    RoleMysql findByName(String name);

    // busca por enum de status da role
    List<RoleMysql> findByStatus(StatusRole status);

    // fazer paginacao do resultado
    Page<RoleMysql> findAll(Pageable pageable);
}
