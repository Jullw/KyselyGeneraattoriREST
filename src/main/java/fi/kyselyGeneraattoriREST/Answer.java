package fi.kyselyGeneraattoriREST;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
        

    @ManyToOne()
    @JoinColumn(name ="question_id")
    private Question question;
    
    private String answer;
      
    public Answer() {
        super();
        
    }

    public Answer(String answer) {
        super();
        this.answer = answer;
    }

    public Answer(String answer, Question question) {
        this.answer = answer;
        this.question = question;
    }
    

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    
    public Long getId() {
        return this.id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Answer)) {
            return false;
        }
        Answer answer = (Answer) o;
        return Objects.equals(this.id, answer.id) && Objects.equals(this.answer,answer.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.answer);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + "answer='" + this.answer + '\'' + '}';
    }
}




