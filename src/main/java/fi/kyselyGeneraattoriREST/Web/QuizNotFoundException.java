package fi.kyselyGeneraattoriREST.Web;

public class QuizNotFoundException extends RuntimeException {

    QuizNotFoundException(Long id) {
        super("Could not find quiz " + id);
    }
}

