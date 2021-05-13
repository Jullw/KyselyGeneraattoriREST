package fi.kyselyGeneraattoriREST.Domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    
        List<Answer> findByQuestion(Question question);
       
        List<Answer> findByAnswer(String answer);
}

    

