package fi.kyselyGeneraattoriREST.Web;

import fi.kyselyGeneraattoriREST.Domain.Answer;
import fi.kyselyGeneraattoriREST.Domain.AnswerRepository;
import fi.kyselyGeneraattoriREST.Domain.Question;
import fi.kyselyGeneraattoriREST.Domain.QuestionsRepository;
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
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionsRepository questionrepository;

    @CrossOrigin
    @GetMapping("/allAnswers")
    List<Answer> allAnswers() {
        return answerRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/getOneAnswer/{id}")
    Answer getOneAnswer(@PathVariable Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(id));
    }

    @CrossOrigin
    @GetMapping("/getAnswersFromQuestion/{id}")
    List<Answer> getAnswersFromQuestion(@PathVariable Long id) {
        Question q = questionrepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
        return answerRepository.findByQuestion(q);
    }

    @CrossOrigin
    @PostMapping("/addAnswer")
    Answer addAnswer(@RequestBody Answer newAnswer) {
        return answerRepository.save(newAnswer);
    }

    @CrossOrigin
    @PostMapping("/addAnswerToQuestion/{id}")
    Answer addNewQuestionToQuiz(@RequestBody Answer newAnswer, @PathVariable Long id) {

        Question q = questionrepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));

        newAnswer.setQuestion(q);
        return answerRepository.save(newAnswer);
    }

    @CrossOrigin
    @PutMapping("/replaceAnswer/{id}")
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

    @CrossOrigin
    @GetMapping("/deleteAnswer/{id}")
    void deleteAnswer(@PathVariable Long id) {
        answerRepository.deleteById(id);
    }
}
