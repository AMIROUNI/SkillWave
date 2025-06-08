package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Services.ReviewService;
import com.example.skillwavebackend.Repositories.CourseRepository;
import com.example.skillwavebackend.Repositories.UserRepository;
import com.example.skillwavebackend.models.Review;
import com.example.skillwavebackend.models.Course;
import com.example.skillwavebackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class ReviewResolver {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @SchemaMapping(typeName = "Query", field = "getAllReviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @SchemaMapping(typeName = "Query", field = "getReviewById")
    public Review getReviewById(@Argument Long id) {
        return reviewService.getReviewById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Query", field = "getReviewsByCourseId")
    public List<Review> getReviewsByCourseId(@Argument Long courseId) {
        return reviewService.getReviewsByCourseId(courseId);
    }

    @SchemaMapping(typeName = "Query", field = "getReviewsByStudentId")
    public List<Review> getReviewsByStudentId(@Argument Long studentId) {
        return reviewService.getReviewsByStudentId(studentId);
    }

    @SchemaMapping(typeName = "Mutation", field = "createReview")
    public Review createReview(
            @Argument Integer rating,
            @Argument String comment,
            @Argument Long courseId,
            @Argument Long studentId
    ) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User student = userRepository.findById(studentId).orElseThrow(() -> new RuntimeException("User not found"));

        Review review = new Review();
        review.setRating(rating);
        review.setComment(comment);
        review.setCourse(course);
        review.setStudent(student);
        review.setCreatedAt(new Date());

        return reviewService.createReview(review);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateReview")
    public Review updateReview(
            @Argument Long id,
            @Argument Integer rating,
            @Argument String comment
    ) {
        Review updated = new Review();
        updated.setRating(rating);
        updated.setComment(comment);
        return reviewService.updateReview(id, updated);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteReview")
    public Boolean deleteReview(@Argument Long id) {
        return reviewService.deleteReview(id);
    }
}
