package test.domain;

public class Question {
private Integer id;
private String name;
private Integer isRadio;
private Exam exam;
private float point;
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
public Integer getIsRadio() {
	return isRadio;
}
public void setIsRadio(Integer isRadio) {
	this.isRadio = isRadio;
}
public Exam getExam() {
	return exam;
}
public void setExam(Exam exam) {
	this.exam = exam;
}
public float getPoint() {
	return point;
}
public void setPoint(float point) {
	this.point = point;
}

}
