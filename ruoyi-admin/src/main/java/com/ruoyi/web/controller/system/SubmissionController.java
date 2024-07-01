package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.Submission;
import com.ruoyi.system.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<?> createSubmission(@RequestBody Submission submission) {
        boolean result = submissionService.createSubmission(submission);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Submission created successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to create submission", null));
        }
    }

    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        return ResponseEntity.ok(submissionService.getAllSubmissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable int id) {
        return ResponseEntity.ok(submissionService.getSubmissionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubmission(@PathVariable int id, @RequestBody Submission submission) {
        submission.setSubmissionId(id);
        boolean result = submissionService.updateSubmission(submission);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Submission updated successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to update submission", null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubmission(@PathVariable int id) {
        boolean result = submissionService.deleteSubmissionById(id);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Submission deleted successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to delete submission", null));
        }
    }
}
