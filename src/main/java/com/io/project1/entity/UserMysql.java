package com.io.project1.entity;

import lombok.*;

import javax.persistence.*;

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
    @ManyToOne //muitos usuarios para cada role
    private RoleMysql role;
    //private Set<RoleMysql> roles;

    public UserMysql(final String name, final String email, final RoleMysql role) {
        super();
        this.name = name;
        this.email = email;
        this.role = role;
    }
}
