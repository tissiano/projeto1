package com.io.project1.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Set;

@NoArgsConstructor
/*@AllArgsConstructor //não é possível usar o exclude nesse caso*/
@ToString(exclude = "id")
@EqualsAndHashCode
@Document
public class UserMongo {
    @Id
    @Getter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private Set<RoleMongo> roles;

    public UserMongo(final String name, final String email) {
        super();
        this.name = name;
        this.email = email;
    }
}
