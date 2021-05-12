package fi.kyselyGeneraattoriREST.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String href = "localhost:8080/quizzes/";

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quiz")
    private List<Question> questions;

    public Quiz() {
        super();
        this.href = this.href + String.valueOf(getId());
    }

    public Quiz(String title) {
        super();
        this.href = this.href + String.valueOf(getId());
        this.title = title;

    }

    public Quiz(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
        this.href = this.href + String.valueOf(getId());
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question q) {
        this.questions.add(q);
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Quiz)) {
            return false;
        }
        Quiz quiz = (Quiz) o;
        return Objects.equals(this.id, quiz.id) && Objects.equals(this.title, quiz.title);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title);
    }

    @Override
    public String toString() {
        return "Quiz{" + "id=" + this.id + ", title='" + this.title + '\'' + '}';
    }
}
