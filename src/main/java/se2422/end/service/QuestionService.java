package se2422.end.service;

import org.springframework.stereotype.Service;
import se2422.end.model.Question;
import se2422.end.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question newData) {
        return questionRepository.findById(id)
                .map(q -> {
                    q.setText(newData.getText());
                    q.setOptionA(newData.getOptionA());
                    q.setOptionB(newData.getOptionB());
                    q.setOptionC(newData.getOptionC());
                    q.setOptionD(newData.getOptionD());
                    q.setCorrectAnswer(newData.getCorrectAnswer());
                    q.setExam(newData.getExam());
                    return questionRepository.save(q);
                })
                .orElseThrow(() -> new RuntimeException("Question not found with id=" + id));
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
