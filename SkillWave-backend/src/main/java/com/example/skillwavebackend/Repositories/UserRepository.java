package com.example.skillwavebackend.Repositories;

import com.example.skillwavebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByEmail(String email);

    Optional<User> findByEmail(String email);
}

