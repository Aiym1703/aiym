package se2422.end.service;

import org.springframework.stereotype.Service;
import se2422.end.model.Exam;
import se2422.end.repository.ExamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Optional<Exam> getExamById(Long id) {
        return examRepository.findById(id);
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }
    public Exam updateExam(Long id, Exam newData) {
        try {
            Optional<Exam> examOptional = examRepository.findById(id);

            if (examOptional.isPresent()) {
                Exam existing = examOptional.get();
                existing.setTitle(newData.getTitle());
                return examRepository.save(existing);
            } else {
                throw new RuntimeException("Exam not found with id=" + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating exam: " + e.getMessage());
        }
    }



    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
