package fi.kyselyGeneraattoriREST;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionsRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/answers")
    List<Answer> all() {
        return answerRepository.findAll();
    }

    @PostMapping("/answer")
    Answer newAnswer(@RequestBody Answer newAnswer) {
        return answerRepository.save(newAnswer);
    }

    @GetMapping("/answer/{id}")
    Answer one(@PathVariable Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(id));
    }

    @PutMapping("/answer/{id}")
    Answer replaceAnswer(@RequestBody Answer newAnswer, @PathVariable Long id) {

        return answerRepository.findById(id)
                .map(answer -> {
                    answer.setAnswer(answer.getAnswer());
                    return answerRepository.save(answer);
                })
                .orElseGet(() -> {
                    newAnswer.setId(id);
                    return answerRepository.save(newAnswer);
                });
    }

    @GetMapping("/answer_question/{id}")
    Question findQuestionWhereAnswerBelongs(@PathVariable Long id) {
        Answer a = answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(id));
        return a.getQuestion();

    }

    //quiz.setAnswer(newQuiz.getAnswer());
    @DeleteMapping("/answers/{id}")
    void deleteQuiz(@PathVariable Long id) {
        answerRepository.deleteById(id);
    }
}
