package com.io.project1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private StatusRole status;

    public RoleMysql(final String name) {
        super();
        this.name = name;
        status = StatusRole.ATIVO;
    }

    public RoleMysql(final String name, final StatusRole status) {
        super();
        this.name = name;
        this.status = status;
    }

}
