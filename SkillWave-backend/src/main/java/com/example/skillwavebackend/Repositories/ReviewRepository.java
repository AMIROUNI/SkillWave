package com.example.skillwavebackend.Repositories;

import com.example.skillwavebackend.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository  extends JpaRepository<Review,Long> {
}
