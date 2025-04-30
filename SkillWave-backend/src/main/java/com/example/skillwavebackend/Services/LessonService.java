package com.example.skillwavebackend.Services;

import com.example.skillwavebackend.Repositories.LessonRepository;
import com.example.skillwavebackend.models.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Optional<Lesson> getLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Long id, Lesson lessonDetails) {
        return lessonRepository.findById(id).map(lesson -> {
            lesson.setTitle(lessonDetails.getTitle());
            lesson.setContent(lessonDetails.getContent());
            lesson.setVideoUrl(lessonDetails.getVideoUrl());
            lesson.setLessonOrder(lessonDetails.getLessonOrder());
            lesson.setCourse(lessonDetails.getCourse());
            return lessonRepository.save(lesson);
        }).orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
