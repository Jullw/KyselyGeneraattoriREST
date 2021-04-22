package fi.kyselyGeneraattoriREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(QuizRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Quiz("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Quiz("Frodo Baggins", "thief")));
        };
    }
}
