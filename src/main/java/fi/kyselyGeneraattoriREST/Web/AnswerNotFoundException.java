package fi.kyselyGeneraattoriREST.Web;


public class AnswerNotFoundException extends RuntimeException {

    AnswerNotFoundException(Long id) {
        super("Can't find answer " + id);
    }
}
