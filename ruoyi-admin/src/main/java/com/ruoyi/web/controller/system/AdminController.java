package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.Competition;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.service.CompetitionService;
import com.ruoyi.system.service.SubmissionService;
import com.ruoyi.system.service.UserService;
import com.ruoyi.system.service.ReviewService;
import com.ruoyi.system.service.LogService;
import com.ruoyi.system.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private LogService logService;

    @GetMapping("/registrations")
    public ResponseEntity<List<User>> getAllRegistrations() {
        return ResponseEntity.ok(userService.getAllPendingRegistrations());
    }

    @PutMapping("/registrations/{userId}")
    public ResponseEntity<?> approveRegistration(@PathVariable int userId) {
        userService.approveRegistration(userId);
        return ResponseEntity.ok("Registration approved successfully");
    }

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

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/competitions")
    public ResponseEntity<?> getAllCompetitions() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }

    @PostMapping("/competitions")
    public ResponseEntity<?> createCompetition(@RequestBody Competition competition) {
        competitionService.createCompetition(competition);
        return ResponseEntity.status(HttpStatus.CREATED).body("Competition created successfully");
    }

    @PutMapping("/competitions/{id}")
    public ResponseEntity<?> updateCompetition(@PathVariable int id, @RequestBody Competition competition) {
        competitionService.updateCompetition(id, competition);
        return ResponseEntity.ok("Competition updated successfully");
    }

    @DeleteMapping("/competitions/{id}")
    public ResponseEntity<?> deleteCompetition(@PathVariable int id) {
        competitionService.deleteCompetitionById(id);
        return ResponseEntity.ok("Competition deleted successfully");
    }

    @GetMapping("/submissions")
    public ResponseEntity<?> getAllSubmissions() {
        return ResponseEntity.ok(submissionService.getAllSubmissions());
    }

    @DeleteMapping("/submissions/{id}")
    public ResponseEntity<?> deleteSubmission(@PathVariable int id) {
        submissionService.deleteSubmissionById(id);
        return ResponseEntity.ok("Submission deleted successfully");
    }

    @GetMapping("/reviews")
    public ResponseEntity<?> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/logs")
    public ResponseEntity<?> getAllLogs() {
        List<Log> logs = logService.getAllLogs();
        return ResponseEntity.ok(logs);
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

    // Getters and setters
}
