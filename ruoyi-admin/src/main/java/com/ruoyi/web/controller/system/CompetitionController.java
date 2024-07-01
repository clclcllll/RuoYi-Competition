package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.Competition;
import com.ruoyi.system.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @PostMapping
    public ResponseEntity<?> createCompetition(@RequestBody Competition competition) {
        boolean result = competitionService.createCompetition(competition);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Competition created successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to create competition", null));
        }
    }

    @GetMapping
    public ResponseEntity<List<Competition>> getAllCompetitions() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompetition(@PathVariable int id, @RequestBody Competition competition) {
        competition.setCompetitionId(id);
        boolean result = competitionService.updateCompetition(competition);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Competition updated successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to update competition", null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompetition(@PathVariable int id) {
        boolean result = competitionService.deleteCompetitionById(id);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Competition deleted successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to delete competition", null));
        }
    }
}
