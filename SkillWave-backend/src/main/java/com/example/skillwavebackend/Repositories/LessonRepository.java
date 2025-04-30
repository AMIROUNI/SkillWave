package com.example.skillwavebackend.Repositories;

import com.example.skillwavebackend.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {
}
