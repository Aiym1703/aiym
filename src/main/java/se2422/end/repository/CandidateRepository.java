package se2422.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se2422.end.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
