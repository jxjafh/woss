package test_pojo;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ordersandgoods {
	private int id;
	private Timestamp orderDate;
	private ArrayList<Goods> goods;
	private String goodsoperation;
	private String orderstate;
	private String orderoperation;
	public String getGoodsoperation() {
		return goodsoperation;
	}
	public void setGoodsoperation(String goodsoperation) {
		this.goodsoperation = goodsoperation;
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
public ArrayList<Goods> getGoods() {
	return goods;
}
public void setGoods(ArrayList<Goods> goods) {
	this.goods = goods;
}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public String getOrderoperation() {
		return orderoperation;
	}
	public void setOrderoperation(String orderoperation) {
		this.orderoperation = orderoperation;
	}
	
}
