package com.ruoyi.system;

import com.ruoyi.system.domain.Review;
import com.ruoyi.system.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    public void testCreateReview() {
        Review review = new Review();
        review.setSubmissionId(1);
        review.setExpertId(1);
        review.setScore(100);
        review.setComment("Excellent");

        int result = reviewService.createReview(review);
        assertEquals(1, result);
    }

    @Test
    public void testGetAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        assertNotNull(reviews);
        assertTrue(reviews.size() > 0);
    }
}
