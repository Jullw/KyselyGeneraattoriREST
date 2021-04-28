package fi.kyselyGeneraattoriREST;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Quiz {

    private @Id
    @GeneratedValue
    Long id;
    private String question;
    private String answer;
    private String href;

    public Quiz() {
        this.href = "https://kyselygeneraattori00.herokuapp.com/quizzes/"+id;
    }

    public Quiz(String question, String answer) {

        this.question = question;
        this.answer = answer;
        this.href = "https://kyselygeneraattori00.herokuapp.com/quizzes/"+id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
   
    public Long getId() {
        return this.id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        return Objects.equals(this.id, quiz.id) && Objects.equals(this.question, quiz.question)
                && Objects.equals(this.answer, quiz.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.question, this.answer);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.question + '\'' + ", role='" + this.answer + '\'' + '}';
    }
}
