package test.domain;

public class QuestionItem {
private Integer id;
private String name;
private Question question;
private Integer isOk;
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
public Question getQuestion() {
	return question;
}
public void setQuestion(Question question) {
	this.question = question;
}
public Integer getIsOk() {
	return isOk;
}
public void setIsOk(Integer isOk) {
	this.isOk = isOk;
}
}
