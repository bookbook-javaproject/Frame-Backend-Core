package com.frame.core.domain.user.domain.entity;

import com.mongodb.BasicDBObject;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Getter
@Document(collection = "col_relationship")
public class Relationship {
    @Id
    private String email;

    private List<String> follower;

    private List<String> following;
}
