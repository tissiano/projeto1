package com.io.project1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data //cria os getters/setters, EqualsAndHashCode etc
// @AllArgsConstructor //não é possível usar o exclude nesse caso*/
@NoArgsConstructor
@ToString(exclude = "id")
public class RoleMysql {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public RoleMysql(final String name) {
        super();
        this.name = name;
    }

}
