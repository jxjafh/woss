package test.domain;
import java.util.Set;
public class Exam {
private Integer id;
private String name;
private Set<Question> question;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Question> getQuestion() {
	return question;
}
public void setQuestion(Set<Question> question) {
	this.question = question;
}

}
