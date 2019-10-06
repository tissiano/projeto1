package com.io.project1.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
public class RoleMongo {
    @Id
    private String id;
    private String name;
}
