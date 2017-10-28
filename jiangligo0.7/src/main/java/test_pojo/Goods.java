package test_pojo;

import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;

public class Goods {
private int id;
private String name;
private String info;
private int sort_id;
private Double price;
private int originalprice;
private String state;
private String pic;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date releasetime;
private int member_id;
private int order_id;
private int number;
private Member member;
public void setPic(String pic) {
	this.pic = pic;
}
public String getPic() {
	return pic;
}
public void setReleasetime(Date releasetime) {
	this.releasetime = releasetime;
}
public void setMember(Member member) {
	this.member = member;
}
public Date getReleasetime() {
	return releasetime;
}
public Member getMember() {
	return member;
}
public void setOriginalprice(int originalprice) {
	this.originalprice = originalprice;
}
public int getOriginalprice() {
	return originalprice;
}
public void setNumber(int number) {
	this.number = number;
}
public int getNumber() {
	return 1;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public int getSort_id() {
	return sort_id;
}
public void setSort_id(int sort_id) {
	this.sort_id = sort_id;
}
public void setPrice(Double price) {
	this.price = price;
}
public Double getPrice() {
	return price;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getMember_id() {
	return member_id;
}
public void setMember_id(int member_id) {
	this.member_id = member_id;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}

}
