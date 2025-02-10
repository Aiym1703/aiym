package se2422.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se2422.end.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}