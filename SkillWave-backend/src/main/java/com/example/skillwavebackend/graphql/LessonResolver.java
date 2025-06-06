package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Services.LessonService;
import com.example.skillwavebackend.models.Course;
import com.example.skillwavebackend.models.Lesson;
import com.example.skillwavebackend.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LessonResolver {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private CourseRepository courseRepository;

    @SchemaMapping(typeName = "Query", field = "getLessonById")
    public Lesson getLessonById(@Argument Long id) {
        return lessonService.getLessonById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Query", field = "getAllLessons")
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @SchemaMapping(typeName = "Mutation", field = "addLesson")
    public Lesson addLesson(
            @Argument String title,
            @Argument String content,
            @Argument String videoUrl,
            @Argument Integer lessonOrder,
            @Argument Long courseId
    ) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            throw new RuntimeException("Course not found with id: " + courseId);
        }

        Lesson lesson = new Lesson();
        lesson.setTitle(title);
        lesson.setContent(content);
        lesson.setVideoUrl(videoUrl);
        lesson.setLessonOrder(lessonOrder);
        lesson.setCourse(course);

        return lessonService.createLesson(lesson);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateLesson")
    public Lesson updateLesson(
            @Argument Long id,
            @Argument String title,
            @Argument String content,
            @Argument String videoUrl,
            @Argument Integer lessonOrder,
            @Argument Long courseId
    ) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            throw new RuntimeException("Course not found with id: " + courseId);
        }

        Lesson updatedLesson = new Lesson();
        updatedLesson.setTitle(title);
        updatedLesson.setContent(content);
        updatedLesson.setVideoUrl(videoUrl);
        updatedLesson.setLessonOrder(lessonOrder);
        updatedLesson.setCourse(course);

        return lessonService.updateLesson(id, updatedLesson);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteLesson")
    public Boolean deleteLesson(@Argument Long id) {
        lessonService.deleteLesson(id);
        return true;
    }
}
