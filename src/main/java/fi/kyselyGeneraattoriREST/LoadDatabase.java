package fi.kyselyGeneraattoriREST;

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
    CommandLineRunner initDatabase(QuizRepository quizrepository, QuestionsRepository questionrepository, AnswerRepository answerRepository) {

        return args -> {
/*
         long i = 1L;

            Quiz q = new Quiz("Kysely 1?", new ArrayList<>());
            Quiz a = new Quiz("Kysely 2", new ArrayList<>());

            Quiz qa = new Quiz("Kysely 3", new ArrayList<>());
            Quiz aq = new Quiz("Kysely 4", new ArrayList<>());

            Question k1 = new Question("Vastaan Kyselyyn 1", q);
            Question k2 = new Question("Vastaan Kyselyyn 1", q);
            Question k3 = new Question("Vastaan Kyselyyn 1", q);
            Question k8 = new Question("Vastaan Kyselyyn 2", q);
            
            
            Question k4 = new Question("Vastaan Kyselyyn 2", a);
            Question k5 = new Question("Vastaan Kyselyyn 2", a);
            
            Question k6 = new Question("Vastaan Kyselyyn 3", qa);
            Question k7 = new Question("Vastaan Kyselyyn 3", qa);
            
            Question k9 = new Question("Vastaan kyselyyn 4", aq);
            
    
            log.info("Preloading " + quizrepository.save(q));
            log.info("Preloading " + quizrepository.save(a));

            log.info("Preloading " + quizrepository.findByTitle("Hei maailma?dd").get(0).getHref());

            questionrepository.save(new Question("Hei lllkjlk",
                    quizrepository.findByTitle("Hei maailma?").get(0)));

            questionrepository.save(new Question("Tänne samaan",
                    quizrepository.findByTitle("Hei maailma?").get(0)));

            answerRepository.save(new Answer("Vastaan lllkjkl",
                    questionrepository.findByQuestion("Hei lllkjlk").get(0)));
*/
        };
    }
}
