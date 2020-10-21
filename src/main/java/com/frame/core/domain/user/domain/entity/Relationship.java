package com.frame.core.domain.user.domain.entity;

import com.mongodb.BasicDBObject;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collation = "col_relationship")
public class Relationship {
    @Id
    private String email;

    private BasicDBObject follower;

    private BasicDBObject following;
}
