package test_pojo;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Order {
private int id;
private Timestamp orderDate;
private int member_id;
private ArrayList<Goods> goods;
private int state;
public void setState(int state) {
	this.state = state;
}
public int getState() {
	return state;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Timestamp getOrderDate() {
	return orderDate;
}
public void setOrderDate(Timestamp orderDate) {
	this.orderDate = orderDate;
}
public int getMember_id() {
	return member_id;
}
public void setMember_id(int member_id) {
	this.member_id = member_id;
}
public ArrayList<Goods> getGoods() {
	return goods;
}
public void setGoods(ArrayList<Goods> goods) {
	this.goods = goods;
}
}
