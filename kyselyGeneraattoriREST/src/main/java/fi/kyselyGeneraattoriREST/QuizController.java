package fi.kyselyGeneraattoriREST;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class QuizController {

    private final QuizRepository repository;

    QuizController(QuizRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/quizzes")
    List<Quiz> all() {
        return repository.findAll();
    }


    @PostMapping("/quizzes")
    Quiz newQuiz(@RequestBody Quiz newQuiz) {
        return repository.save(newQuiz);
    }


    @GetMapping("/quizzes/{id}")
    Quiz one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
    }

    @PutMapping("/quizzes/{id}")
    Quiz replaceQuiz(@RequestBody Quiz newQuiz, @PathVariable Long id) {

        return repository.findById(id)
                .map(quiz -> {
                    quiz.setQuestion(newQuiz.getQuestion());
                    quiz.setAnswer(newQuiz.getAnswer());
                    return repository.save(quiz);
                })
                .orElseGet(() -> {
                    newQuiz.setId(id);
                    return repository.save(newQuiz);
                });
    }

    @DeleteMapping("/quizzes/{id}")
    void deleteQuiz(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
