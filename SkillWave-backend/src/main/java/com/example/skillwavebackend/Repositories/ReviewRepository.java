package com.example.skillwavebackend.Repositories;

import com.example.skillwavebackend.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository  extends JpaRepository<Review,Long> {
    List<Review> findByCourseId(Long courseId);
    List<Review> findByStudentId(Long studentId);
}
