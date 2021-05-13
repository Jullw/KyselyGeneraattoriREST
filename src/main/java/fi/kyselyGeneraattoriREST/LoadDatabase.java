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
    CommandLineRunner initDatabase(QuizRepository quizrepository, QuestionsRepository questionrepository, AnswerRepository answerRepository) {

        return args -> {

            long i = 1L;

            Quiz k1 = new Quiz("Kysely 1", new ArrayList<>());
            Quiz k2 = new Quiz("Kysely 2", new ArrayList<>());
            Quiz k3 = new Quiz("Kysely 3 ", new ArrayList<>());
            Quiz k4 = new Quiz("Kysely 4", new ArrayList<>());

            Question ky1 = new Question("Kysymys 1 --> Kyselyyn 1", k1);
            Question ky2 = new Question("Kysymys 2 --> Kyselyyn 1", k1);
            Question ky3 = new Question("Kysymys 3 --> Kyselyyn 1", k1);

            Question ky4 = new Question("Kysymys 4 == Kyselyyn 2 ", k2);
            Question ky5 = new Question("Kysymys 5 == Kyselyyn 2", k2);

            Question ky6 = new Question("Kysymys 6 zz Kyselyyn 3 ", k3);
            Question ky7 = new Question("Kysymys 7 zz Kyselyyn 3", k3);

            Question ky8 = new Question("Kysymys 8 ## Kyselyyn 4 ", k4);
            
            Answer a1 = new Answer("VASTAUS 1  KYSYMYKSEEN 1 ",ky1);
            Answer a2 = new Answer("VASTAUS 2  KYSYMYKSEEN 1 ",ky1);
            
            Answer a3 = new Answer("VASTAUS 3  KYSYMYKSEEN 2 ",ky2);
            Answer a4 = new Answer("VASTAUS 4  KYSYMYKSEEN 2 ",ky2);
            Answer a5 = new Answer("VASTAUS 5  KYSYMYKSEEN 2 ",ky2);
            
            Answer a6 = new Answer("VASTAUS 6  KYSYMYKSEEN 3 ",ky3);
            Answer a7 = new Answer("VASTAUS 7  KYSYMYKSEEN 3 ",ky3);
            Answer a8 = new Answer("VASTAUS 8  KYSYMYKSEEN 3  ",ky3);
            
            Answer a9 = new Answer("VASTAUS 9  KYSYMYKSEEN 4 ",ky4);
            

            log.info("Preloading " + quizrepository.save(k1));
            log.info("Preloading " + quizrepository.save(k2));
            log.info("Preloading " + quizrepository.save(k3));
            log.info("Preloading " + quizrepository.save(k4));

            questionrepository.save(ky1);
            questionrepository.save(ky2);
            questionrepository.save(ky3);
            questionrepository.save(ky4);
            questionrepository.save(ky5);
            questionrepository.save(ky6);
            questionrepository.save(ky7);
            questionrepository.save(ky8);
            
            answerRepository.save(a1);
            answerRepository.save(a2);
            answerRepository.save(a3);
            answerRepository.save(a4);
            answerRepository.save(a5);
            answerRepository.save(a6);
            answerRepository.save(a7);
            answerRepository.save(a8);
            answerRepository.save(a9);



        };
    }
}
