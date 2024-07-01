package com.ruoyi.system.service;

import com.ruoyi.system.domain.Review;
import com.ruoyi.system.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    public List<Review> getAllReviews() {
        return reviewMapper.selectAllReviews();
    }

    public List<Review> getReviewsBySubmissionId(int submissionId) {
        return reviewMapper.selectReviewsBySubmissionId(submissionId);
    }

    public boolean createReview(Review review) {
        return reviewMapper.insertReview(review) > 0;
    }

    public int getTotalReviews() {
        return 0;
    }

    public boolean updateReview(Review review) {
        return reviewMapper.updateReview(review) > 0;
    }

    public boolean deleteReviewById(int id) {
        return reviewMapper.deleteReviewById(id) > 0;
    }
}
