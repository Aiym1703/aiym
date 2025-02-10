package se2422.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se2422.end.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
