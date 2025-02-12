package se2422.end.service;

import org.springframework.stereotype.Service;
import se2422.end.model.Candidate;
import se2422.end.repository.CandidateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Long id, Candidate newData) {
        return candidateRepository.findById(id)
                .map(existing -> {
                    existing.setName(newData.getName());
                    existing.setEmail(newData.getEmail());
                    existing.setExams(newData.getExams());
                    return candidateRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Candidate not found with id=" + id));
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

}
