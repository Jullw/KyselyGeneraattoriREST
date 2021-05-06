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
    private AnswerRepository repository;
    
    @GetMapping("/answers")
    List<Answer> all() {
        return repository.findAll();
    }

    @PostMapping("/answer")
    Answer newAnswer(@RequestBody Answer newAnswer) {
        return repository.save(newAnswer);
    }

    @GetMapping("/answer/{id}")
    Answer one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(id));
    }

    @PutMapping("/answer/{id}")
    Answer replaceAnswer(@RequestBody Answer newAnswer, @PathVariable Long id) {

        return repository.findById(id)
                .map(answer -> {
                    answer.setAnswer(answer.getAnswer());
                    return repository.save(answer);
                })
                .orElseGet(() -> {
                    newAnswer.setId(id);
                    return repository.save(newAnswer);
                });
    }
    
    
    //quiz.setAnswer(newQuiz.getAnswer());
    
    @DeleteMapping("/answers/{id}")
    void deleteQuiz(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

    

