package com.ruoyi.web.controller.system;

import com.ruoyi.system.service.CompetitionService;
import com.ruoyi.system.service.SubmissionService;
import com.ruoyi.system.service.UserService;
import com.ruoyi.system.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/statistics")
    public ResponseEntity<?> getStatistics() {
        int totalSubmissions = submissionService.getTotalSubmissions();
        int totalUsers = userService.getTotalUsers();
        int totalCompetitions = competitionService.getTotalCompetitions();
        int totalReviews = reviewService.getTotalReviews();
        return ResponseEntity.ok(new StatisticsResponse(totalSubmissions, totalUsers, totalCompetitions, totalReviews));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/submissions")
    public ResponseEntity<?> getAllSubmissions() {
        return ResponseEntity.ok(submissionService.getAllSubmissions());
    }

    @GetMapping("/reviews")
    public ResponseEntity<?> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }
}

class StatisticsResponse {
    private int totalSubmissions;
    private int totalUsers;
    private int totalCompetitions;
    private int totalReviews;

    public StatisticsResponse(int totalSubmissions, int totalUsers, int totalCompetitions, int totalReviews) {
        this.totalSubmissions = totalSubmissions;
        this.totalUsers = totalUsers;
        this.totalCompetitions = totalCompetitions;
        this.totalReviews = totalReviews;
    }

    // getters and setters
}
