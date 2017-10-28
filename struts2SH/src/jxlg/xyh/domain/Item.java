package jxlg.xyh.domain;

public class Item {
private int itemID;
private String ItemName;
private String StudentNumber;
private String ItemTime;
private String ItemAddress;
private String History;
private String Introduce;
private int judgeDay;
public Item() {
	// TODO Auto-generated constructor stub
}
public Item(String itemName, String studentNumber,
		String itemTime, String itemAddress, String history, String introduce) {
	super();
	this.itemID = itemID;
	ItemName = itemName;
	StudentNumber = studentNumber;
	ItemTime = itemTime;
	ItemAddress = itemAddress;
	History = history;
	Introduce = introduce;
}
public int getItemID() {
	return itemID;
}
public void setItemID(int itemID) {
	this.itemID = itemID;
}
public String getItemName() {
	return ItemName;
}
public void setItemName(String itemName) {
	ItemName = itemName;
}
public String getStudentNumber() {
	return StudentNumber;
}
public void setStudentNumber(String studentNumber) {
	StudentNumber = studentNumber;
}
public String getItemTime() {
	return ItemTime;
}
public void setItemTime(String itemTime) {
	ItemTime = itemTime;
}
public String getItemAddress() {
	return ItemAddress;
}
public void setItemAddress(String itemAddress) {
	ItemAddress = itemAddress;
}
public String getHistory() {
	return History;
}
public void setHistory(String history) {
	History = history;
}
public String getIntroduce() {
	return Introduce;
}
public void setIntroduce(String introduce) {
	Introduce = introduce;
}
public int getJudgeDay() {
	return judgeDay;
}
public void setJudgeDay(int judgeDay) {
	this.judgeDay = judgeDay;
}

}