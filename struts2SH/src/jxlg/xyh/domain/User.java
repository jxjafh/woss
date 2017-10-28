package jxlg.xyh.domain;

import java.util.Set;

public class User {
private int AlID;
private int StudentID;
private String StudentName;
private String Password;
private String StudentSex;
private String UserClass;
private String UserDepartment;
private Set<Registration> registration;
public User(){
	
}
public User(int studentID, String studentName, String password,
		String studentSex, String userClass, String userDepartment) {
	super();
	StudentID = studentID;
	StudentName = studentName;
	Password = password;
	StudentSex = studentSex;
	UserClass = userClass;
	UserDepartment = userDepartment;
}

public int getStudentID() {
	return StudentID;
}
public void setStudentID(int studentID) {
	StudentID = studentID;
}
public String getStudentName() {
	return StudentName;
}
public void setStudentName(String studentName) {
	StudentName = studentName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getStudentSex() {
	return StudentSex;
}
public void setStudentSex(String studentSex) {
	StudentSex = studentSex;
}
public String getUserClass() {
	return UserClass;
}
public void setUserClass(String userClass) {
	UserClass = userClass;
}
public String getUserDepartment() {
	return UserDepartment;
}
public void setUserDepartment(String userDepartment) {
	UserDepartment = userDepartment;
}
public Set<Registration> getRegistration() {
	return registration;
}
public void setRegistration(Set<Registration> registration) {
	this.registration = registration;
}

}