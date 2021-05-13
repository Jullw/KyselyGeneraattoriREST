package fi.kyselyGeneraattoriREST.Web;

import fi.kyselyGeneraattoriREST.Domain.Question;
import fi.kyselyGeneraattoriREST.Domain.QuestionsRepository;
import fi.kyselyGeneraattoriREST.Domain.QuizRepository;
import fi.kyselyGeneraattoriREST.Domain.Quiz;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class QuizController {

    @Autowired
    private QuizRepository repository;

    @Autowired
    private QuestionsRepository questionRepository;
    
    @CrossOrigin
    @GetMapping("/quizzes")
    List<Quiz> all() {
        return repository.findAll();
    }
    
    @CrossOrigin
    @PostMapping("/quizzes")
    Quiz newQuiz(@RequestBody Quiz newQuiz) {
        return repository.save(newQuiz);
    }
    
    @CrossOrigin
    @GetMapping("/quizzes/{id}")
    Quiz one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
    }

    /*  @GetMapping("/sss/{id}")
    List<Question> returnQuestions(@PathVariable Long id){
        
        return repository.findById();
                

} */

    @CrossOrigin
    @GetMapping("/questionFrom")
    List<Question> questionsFromQuiz() {
        return questionRepository.findAll();
    }
    
    @CrossOrigin
    @PutMapping("/quizzes/{id}")
    Quiz replaceQuiz(@RequestBody Quiz newQuiz, @PathVariable Long id) {

        return repository.findById(id)
                .map(quiz -> {
                    quiz.setTitle(newQuiz.getTitle());
                    return repository.save(quiz);
                })
                .orElseGet(() -> {
                    newQuiz.setId(id);
                    return repository.save(newQuiz);
                });
    }

    //quiz.setAnswer(newQuiz.getAnswer());
    @CrossOrigin
    @DeleteMapping("/quizzes/{id}")
    void deleteQuiz(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
