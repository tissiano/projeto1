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
    // @ManyToOne //muitos usuarios para cada role
    //cascade = CascadeType.PERSIST = hibernate entende que pode inserir na role caso nao existe ainda o registro,
    //eliminando a necessidade de fazer save antes de usar essa role no usuario
    @ManyToOne(cascade = CascadeType.PERSIST)
    private RoleMysql role;
    //private Set<RoleMysql> roles;

    public UserMysql(final String name, final String email, final RoleMysql role) {
        super();
        this.name = name;
        this.email = email;
        this.role = role;
    }
}
