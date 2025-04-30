package com.example.skillwavebackend.Services;

import com.example.skillwavebackend.Repositories.CourseRepository;
import com.example.skillwavebackend.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        course.setCreatedAt(new Date());
        course.setUpdatedAt(new Date());

        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        return courseRepository.findById(id).map(course -> {
            course.setTitle(courseDetails.getTitle());
            course.setDescription(courseDetails.getDescription());
            course.setImageUrl(courseDetails.getImageUrl());
            course.setPrice(courseDetails.getPrice());
            course.setCategory(courseDetails.getCategory());
            course.setInstructor(courseDetails.getInstructor());
            course.setUpdatedAt(new Date());
            return courseRepository.save(course);
        }).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}