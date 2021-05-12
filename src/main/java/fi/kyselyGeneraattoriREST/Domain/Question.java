package fi.kyselyGeneraattoriREST.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {

    private @Id
    @GeneratedValue

    Long id;
    private String question;
    
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answers;
    
    @ManyToOne()
    @JoinColumn(name="quiz_id")
    Quiz quiz;

    public Question() {
        super();
    }

    public Question(String question) {
        super();
        this.question = question;
    }

    public Question(String question, Quiz quiz) {
        super();
        this.question = question;
        this.quiz = quiz;
    }

    public Question(String question, List<Answer> answers, Quiz quiz) {
        this.question = question;
        this.answers = answers;
        this.quiz = quiz;
    }
    
    
    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Long getId() {
        return this.id;
    }

    public String getQuestion() {
        return question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Question)) {
            return false;
        }
        Question question = (Question) o;
        return Objects.equals(this.id, question.id) && Objects.equals(this.question, question.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.question);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + "answer='" + this.question + '\'' + '}';
    }
}
