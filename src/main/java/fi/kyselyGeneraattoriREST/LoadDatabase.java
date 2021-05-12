package fi.kyselyGeneraattoriREST;

import fi.kyselyGeneraattoriREST.Domain.QuestionsRepository;
import fi.kyselyGeneraattoriREST.Domain.Question;
import fi.kyselyGeneraattoriREST.Domain.QuizRepository;
import fi.kyselyGeneraattoriREST.Domain.Answer;
import fi.kyselyGeneraattoriREST.Domain.Quiz;
import fi.kyselyGeneraattoriREST.Domain.AnswerRepository;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(QuizRepository quizrepository, QuestionsRepository questionrepository, AnswerRepository answerRepository  ) {

        return args -> {

            long i = 1L;

            Quiz q = new Quiz("Hei maailma?", new ArrayList<>());
            Quiz a = new Quiz("Hei maailma?dd", new ArrayList<>());
            
            Question oo = new Question("jsjdjd", q);
            Question oa = new Question("jsadsad", q);

            log.info("Preloading " + quizrepository.save(q));
            log.info("Preloading " + quizrepository.save(a));
            

            
            questionrepository.save(new Question("Hei lllkjlk",
                    quizrepository.findByTitle("Hei maailma?").get(0)));

            questionrepository.save(new Question("Tänne samaan",
                    quizrepository.findByTitle("Hei maailma?").get(0)));

            
            answerRepository.save(new Answer("Vastaan lllkjkl",
                    questionrepository.findByQuestion("Hei lllkjlk").get(0)));

        };
    }
}
