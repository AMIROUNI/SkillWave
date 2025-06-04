package com.example.skillwavebackend.graphql;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {
    @QueryMapping
    public String hello() {
        return "Hello, GraphQL!";
    }
}