package test_pojo;

import java.sql.Timestamp;

public class Membercg {
private int id;
private Timestamp collectionDate;
private int member_id;
private int goods_id;
private Goods goods;
public void setGoods(Goods goods) {
	this.goods = goods;
}
public Goods getGoods() {
	return goods;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Timestamp getCollectionDate() {
	return collectionDate;
}
public void setCollectionDate(Timestamp collectionDate) {
	this.collectionDate = collectionDate;
}
public int getMember_id() {
	return member_id;
}
public void setMember_id(int member_id) {
	this.member_id = member_id;
}
public int getGoods_id() {
	return goods_id;
}
public void setGoods_id(int goods_id) {
	this.goods_id = goods_id;
}

}
