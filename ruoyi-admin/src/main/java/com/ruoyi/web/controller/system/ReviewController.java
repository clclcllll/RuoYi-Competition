package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.Review;
import com.ruoyi.system.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody Review review) {
        boolean result = reviewService.createReview(review);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Review created successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to create review", null));
        }
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/submission/{submissionId}")
    public ResponseEntity<List<Review>> getReviewsBySubmissionId(@PathVariable int submissionId) {
        return ResponseEntity.ok(reviewService.getReviewsBySubmissionId(submissionId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@PathVariable int id, @RequestBody Review review) {
        review.setReviewId(id);
        boolean result = reviewService.updateReview(review);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Review updated successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to update review", null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable int id) {
        boolean result = reviewService.deleteReviewById(id);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Review deleted successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to delete review", null));
        }
    }
}
