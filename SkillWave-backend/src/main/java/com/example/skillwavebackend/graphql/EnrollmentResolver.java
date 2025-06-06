package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Services.EnrollmentService;
import com.example.skillwavebackend.Repositories.UserRepository;
import com.example.skillwavebackend.Repositories.CourseRepository;
import com.example.skillwavebackend.models.Enrollment;
import com.example.skillwavebackend.models.User;
import com.example.skillwavebackend.models.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class EnrollmentResolver {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @SchemaMapping(typeName = "Query", field = "getAllEnrollments")
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @SchemaMapping(typeName = "Query", field = "getEnrollmentById")
    public Enrollment getEnrollmentById(@Argument Long id) {
        return enrollmentService.getEnrollmentById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Mutation", field = "createEnrollment")
    public Enrollment createEnrollment(@Argument Long courseId, @Argument Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User student = userRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment.setEnrolledAt(new Date());

        return enrollmentService.createEnrollment(enrollment);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteEnrollment")
    public Boolean deleteEnrollment(@Argument Long id) {
        enrollmentService.deleteEnrollment(id);
        return true;
    }
}
