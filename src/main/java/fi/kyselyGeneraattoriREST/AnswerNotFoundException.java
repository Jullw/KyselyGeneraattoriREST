package fi.kyselyGeneraattoriREST;


public class AnswerNotFoundException extends RuntimeException {

    AnswerNotFoundException(Long id) {
        super("Can't find answer " + id);
    }
}
