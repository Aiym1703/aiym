package se2422.end.controller;

import org.springframework.web.bind.annotation.*;
import se2422.end.model.Exam;
import se2422.end.service.ExamService;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    // GET all
    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examService.getExamById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found with id=" + id));
    }

    // CREATE
    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        return examService.updateExam(id, exam);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}
