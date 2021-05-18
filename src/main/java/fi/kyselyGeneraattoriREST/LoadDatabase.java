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

            Quiz k1 = new Quiz("Mikä Eläin kyseessä kysely", new ArrayList<>());

            Quiz k2 = new Quiz("Vesityypit kysely", new ArrayList<>());

            Quiz k3 = new Quiz("Pääkaupunki visa", new ArrayList<>());

            Question ky1 = new Question("Mikä eläin on punainen ja sillä on pörröinen häntä?", k1);
            Question ky2 = new Question("Millä eläimellä on pitkä kaula?", k1);
            Question ky3 = new Question("Mikä eläin maukuu?", k1);
            Question ky4 = new Question("Mikä eläin ammuu?", k1);

            Question ky5 = new Question("Onko vesi märkää? ", k2);
            Question ky6 = new Question("Mikä vesi on märin vesi?", k2);
            Question ky7 = new Question("Millä tavalla vesi on märkää? ", k2);

            Question ky8 = new Question("Onko Turku suomen pääkaupunki?", k3);



            // Question ky6 = new Question("Kysymys 6 zz Kyselyyn 3 ", k3);
            // Question ky7 = new Question("Kysymys 7 zz Kyselyyn 3", k3);
            Answer a1 = new Answer("Kettu ", ky1);
            Answer a2 = new Answer("Kirahvi ", ky2);
            Answer a3 = new Answer("Kissa ", ky3);
            Answer a4 = new Answer("Lehmä ", ky4);

            Answer a5 = new Answer("Ei välttämättä ", ky5);
            Answer a6 = new Answer("Mineraalivesi ", ky6);
            Answer a7 = new Answer("Se on nestemmäistä ainetta", ky7);

            Answer a8 = new Answer("Kyllä ", ky8);
            Answer a9 = new Answer("Ei ", ky8);


            log.info("Preloading " + quizrepository.save(k1));
            log.info("Preloading " + quizrepository.save(k2));
            log.info("Preloading " + quizrepository.save(k3));

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
