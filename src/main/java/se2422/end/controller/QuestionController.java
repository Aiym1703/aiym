package se2422.end.controller;

import org.springframework.web.bind.annotation.*;
import se2422.end.model.Question;
import se2422.end.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // GET all
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id=" + id));
    }

    // CREATE
    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question updated) {
        return questionService.updateQuestion(id, updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}
