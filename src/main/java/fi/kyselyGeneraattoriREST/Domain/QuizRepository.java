
package fi.kyselyGeneraattoriREST.Domain;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
        List<Quiz> findByTitle(String title);
}

    

