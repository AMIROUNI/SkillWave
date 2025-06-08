package com.example.skillwavebackend.Services;

import com.example.skillwavebackend.Repositories.ReviewRepository;
import com.example.skillwavebackend.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByCourseId(Long courseId) {
        return reviewRepository.findByCourseId(courseId);
    }

    public List<Review> getReviewsByStudentId(Long studentId) {
        return reviewRepository.findByStudentId(studentId);
    }

    public Review createReview(Review review) {
        review.setCreatedAt(new Date());
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepository.findById(id).map(review -> {
            if (updatedReview.getRating() != null) review.setRating(updatedReview.getRating());
            if (updatedReview.getComment() != null) review.setComment(updatedReview.getComment());
            return reviewRepository.save(review);
        }).orElse(null);
    }

    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
