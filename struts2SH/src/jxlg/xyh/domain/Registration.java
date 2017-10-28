package jxlg.xyh.domain;
public class Registration {
private int AthleteNo;
private Item item;
private String UserName;
private int StudentID;
private int itemID;
private String UserClass;
private String UserDepartment;
private String ItemName;
private String UserScore;
private String ClassScore;
private String DeptScore;
private Double Result ;
public Registration() {
	// TODO Auto-generated constructor stub
}
public Registration(Item item,String userName, int studentID,
		int itemID, String userClass, String userDepartment, String itemName,
		String userScore, String classScore, String deptScore, Double result) {
	super();
	item=item;
	UserName = userName;
	StudentID = studentID;
	this.itemID = itemID;
	UserClass = userClass;
	UserDepartment = userDepartment;
	ItemName = itemName;
	UserScore = userScore;
	ClassScore = classScore;
	DeptScore = deptScore;
	Result = result;
}

public Item getItem() {
	return item;
}
public void setItem(Item item) {
	this.item = item;
}
public int getAthleteNo() {
	return AthleteNo;
}
public void setAthleteNo(int athleteNo) {
	AthleteNo = athleteNo;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public int getStudentID() {
	return StudentID;
}
public void setStudentID(int studentID) {
	StudentID = studentID;
}
public int getItemID() {
	return itemID;
}
public void setItemID(int itemID) {
	this.itemID = itemID;
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
public String getItemName() {
	return ItemName;
}
public void setItemName(String itemName) {
	ItemName = itemName;
}
public String getUserScore() {
	return UserScore;
}
public void setUserScore(String userScore) {
	UserScore = userScore;
}
public String getClassScore() {
	return ClassScore;
}
public void setClassScore(String classScore) {
	ClassScore = classScore;
}
public String getDeptScore() {
	return DeptScore;
}
public void setDeptScore(String deptScore) {
	DeptScore = deptScore;
}
public Double getResult() {
	return Result;
}
public void setResult(Double result) {
	Result = result;
}

}
