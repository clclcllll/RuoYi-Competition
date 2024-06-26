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

    public int createReview(Review review) {
        return reviewMapper.insertReview(review);
    }

    public List<Review> getAllReviews() {
        return reviewMapper.selectAllReviews();
    }

    public List<Review> getReviewsBySubmissionId(Integer submissionId) {
        return reviewMapper.selectReviewsBySubmissionId(submissionId);
    }

    public int getTotalReviews() {
        return reviewMapper.selectAllReviews().size();
    }
}
