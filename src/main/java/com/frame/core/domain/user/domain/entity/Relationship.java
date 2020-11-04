package com.frame.core.domain.user.domain.entity;

import com.mongodb.BasicDBObject;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Builder
@Document(collation = "col_relationship")
public class Relationship {
    @Id
    private String email;

    private List<String> follower;

    private List<String> following;
}
