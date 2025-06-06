package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Services.CourseService;
import com.example.skillwavebackend.Repositories.UserRepository;
import com.example.skillwavebackend.models.Course;
import com.example.skillwavebackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class CourseResolver {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserRepository userRepository;

    @SchemaMapping(typeName = "Query", field = "getAllCourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @SchemaMapping(typeName = "Query", field = "getCourseById")
    public Course getCourseById(@Argument Long id) {
        return courseService.getCourseById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Mutation", field = "createCourse")
    public Course createCourse(
            @Argument String title,
            @Argument String description,
            @Argument String imageUrl,
            @Argument Double price,
            @Argument String category,
            @Argument Long instructorId
    ) {
        User instructor = userRepository.findById(instructorId).orElseThrow(() -> new RuntimeException("Instructor not found"));

        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);
        course.setImageUrl(imageUrl);
        course.setPrice(price);
        course.setCategory(category);
        course.setInstructor(instructor);

        return courseService.createCourse(course);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateCourse")
    public Course updateCourse(
            @Argument Long id,
            @Argument String title,
            @Argument String description,
            @Argument String imageUrl,
            @Argument Double price,
            @Argument String category,
            @Argument Long instructorId
    ) {
        User instructor = userRepository.findById(instructorId).orElse(null);

        Course updated = new Course();
        updated.setTitle(title);
        updated.setDescription(description);
        updated.setImageUrl(imageUrl);
        updated.setPrice(price);
        updated.setCategory(category);
        updated.setInstructor(instructor);

        return courseService.updateCourse(id, updated);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteCourse")
    public Boolean deleteCourse(@Argument Long id) {
        courseService.deleteCourse(id);
        return true;
    }
}
