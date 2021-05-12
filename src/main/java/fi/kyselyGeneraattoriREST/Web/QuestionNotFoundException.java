package fi.kyselyGeneraattoriREST.Web;

public class QuestionNotFoundException extends RuntimeException {

    QuestionNotFoundException(Long id) {
        super("Can't find question " + id);
    }
}
