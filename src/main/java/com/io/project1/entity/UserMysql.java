package com.io.project1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
// @AllArgsConstructor //não é possível usar o exclude nesse caso*/
@ToString(exclude = "id")
@EqualsAndHashCode
public class UserMysql {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    @ManyToMany
    private Set<RoleMysql> roles;

    public UserMysql(final String name, final String email) {
        super();
        this.name = name;
        this.email = email;
    }
}
