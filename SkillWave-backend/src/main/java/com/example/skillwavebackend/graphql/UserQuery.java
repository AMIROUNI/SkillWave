package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.models.User;
import com.example.skillwavebackend.Repositories.UserRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQuery {

    private final UserRepository userRepository;

    public UserQuery(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<User> users() {
        return userRepository.findAll();
    }
}
