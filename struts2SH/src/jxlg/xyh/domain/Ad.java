package jxlg.xyh.domain;

public class Ad {
private Integer id;
private String Name;
private String Password;

public Ad(){
	
}
public Ad(Integer id, String Name, String Password) {
	// TODO Auto-generated constructor stub
	this.id=id;
	this.Name=Name;
	this.Password=Password;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
}
