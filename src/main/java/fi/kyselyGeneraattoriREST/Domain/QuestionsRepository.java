package fi.kyselyGeneraattoriREST.Domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionsRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuestion(String question);
    List<Question> findByQuiz(Quiz quiz);
       
}
