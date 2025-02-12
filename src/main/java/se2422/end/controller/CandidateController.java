package se2422.end.controller;

import org.springframework.web.bind.annotation.*;
import se2422.end.model.Candidate;
import se2422.end.service.CandidateService;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // GET all
    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    // GET by ID

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        try {
            return candidateService.getCandidateById(id)
                    .orElseThrow(() -> new RuntimeException("Candidate not found with id=" + id));
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving candidate: " + e.getMessage());
        }
    }



    // CREATE
    @PostMapping
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.createCandidate(candidate);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Candidate updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
    }




}
