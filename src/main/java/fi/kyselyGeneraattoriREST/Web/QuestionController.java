package fi.kyselyGeneraattoriREST.Web;

import fi.kyselyGeneraattoriREST.Domain.QuestionsRepository;
import fi.kyselyGeneraattoriREST.Domain.Question;
import fi.kyselyGeneraattoriREST.Domain.Quiz;
import fi.kyselyGeneraattoriREST.Domain.QuizRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionsRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

 /*   @CrossOrigin
    @GetMapping("/questions")
    List<Question> all() {
        return questionRepository.findAll();
    } */

    @GetMapping(value = "/questions")
    List<Question> all() {
        return questionRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion) {
        return questionRepository.save(newQuestion);
    }

    @CrossOrigin
    @GetMapping("/getQuestionsFromQuiz/{id}")
    List<Question> getQuestionsFromQuiz(@PathVariable Long id) {
        Quiz q = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
        return questionRepository.findByQuiz(q);
    }

    @CrossOrigin
    @GetMapping("/questions/{id}")
    Question one(@PathVariable Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
    }

    @CrossOrigin
    @PutMapping("/questions/{id}")
    Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {

        return questionRepository.findById(id)
                .map(question -> {
                    question.setQuestion(newQuestion.getQuestion());
                    return questionRepository.save(question);
                })
                .orElseGet(() -> {
                    newQuestion.setId(id);
                    return questionRepository.save(newQuestion);
                });
    }

    @CrossOrigin
    @GetMapping("/question_quiz/{id}")
    Quiz findQuizWhereQuestionBelongs(@PathVariable Long id) {
        Question q = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));

        return q.getQuiz();

        /* return quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id)); */
    }

    //quiz.setAnswer(newQuiz.getAnswer());
    @CrossOrigin
    @DeleteMapping("/questions/{id}")
    void deletenewQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }

}
