package fi.kyselyGeneraattoriREST.Web;

import fi.kyselyGeneraattoriREST.Domain.QuestionsRepository;
import fi.kyselyGeneraattoriREST.Domain.Question;
import fi.kyselyGeneraattoriREST.Domain.Quiz;
import fi.kyselyGeneraattoriREST.Domain.QuizRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @CrossOrigin
    @GetMapping("/allQuestions")
    List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/addQuestion")
    Question addQuestion(@RequestBody Question newQuestion) {
        return questionRepository.save(newQuestion);
    }

    @CrossOrigin
    @PostMapping("addQuestionToQuiz/{id}")
    Question addNewQuestionToQuiz(@RequestBody Question newQuestion, @PathVariable Long id) {

        Quiz q = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
        newQuestion.setQuiz(q);
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
    @GetMapping("/getOneQuestion/{id}")
    Question getOneQuestion(@PathVariable Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
    }

    @CrossOrigin
    @PutMapping("/replaceQuestions/{id}")
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
    @GetMapping("/getQuizWhereQuestionBelongs/{id}")
    Quiz findQuizWhereQuestionBelongs(@PathVariable Long id) {
        Question q = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));

        return q.getQuiz();

        /* return quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id)); */
    }

    @CrossOrigin
    @GetMapping("/deleteQuestion/{id}")
    void deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }

}
