package com.example.skillwavebackend.Controllers;


import com.example.skillwavebackend.Services.LessonService;
import com.example.skillwavebackend.models.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id).orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson lesson) {
        return lessonService.updateLesson(id, lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }
}

