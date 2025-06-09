package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.models.User;
import com.example.skillwavebackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserResolver {

    @Autowired
    private UserService userService;

    // ===**************************************** QUERIES ===

    @SchemaMapping(typeName = "Query", field = "users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @SchemaMapping(typeName = "Query", field = "userById")
    public User getUserById(@Argument Long id) {
        return userService.getUserById(id);
    }

    // === ************************************MUTATIONS ===

    @SchemaMapping(typeName = "Mutation", field = "signUp")
    public User signUp(@Argument String name, @Argument String email, @Argument String password) {
        return userService.registerUser(name, email, password);
    }

    @SchemaMapping(typeName = "Mutation", field = "signIn")
    public User signIn(@Argument String email, @Argument String password) {
        return userService.findByCredentials(email, password);
    }


    @SchemaMapping(typeName = "Mutation", field = "updateUser")
    public User updateUser(
            @Argument Long id,
            @Argument String name,
            @Argument String email,
            @Argument String phone,
            @Argument String bio
    ) {
        return userService.updateUser(id, name, email, phone, bio);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteUser")
    public Boolean deleteUser(@Argument Long id) {
        return userService.deleteUser(id);
    }
}
