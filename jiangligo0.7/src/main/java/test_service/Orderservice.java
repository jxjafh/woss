package test_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test_interface.AdminMapper;
import test_interface.OrderMapper;
import test_pojo.Admin;
import test_pojo.Order;
@Service
public class Orderservice {
	
@Autowired
private OrderMapper orderMapper;


public List<Order> selectGoods(int id){
    List<Order> listid=orderMapper.selectByMebID(id);
    List<Order> listorder = new ArrayList<Order>();
    //System.out.println("订单数量"+listid.size());
    int i=0;
    for(;i<listid.size();i++)
	{
    Order order=orderMapper.selectGoods(listid.get(i).getId());
    //System.out.println(order);
    listorder.add(order);
	}
    //System.out.println("订单数量:"+i);
    //System.out.println("商品数量:"+listorder.size());
    return listorder;
}

public List<Order> selectByHandID(int id){
    List<Order> listid=orderMapper.selectByHandID(id);
    List<Order> listorder = new ArrayList<Order>();
    //System.out.println("订单数量"+listid.size());
    int i=0;
    for(;i<listid.size();i++)
	{
    Order order=orderMapper.selectGoods(listid.get(i).getId());
    //System.out.println(order);
    listorder.add(order);
	}
    //System.out.println("订单数量:"+i);
    //System.out.println("商品数量:"+listorder.size());
    return listorder;
}

public List<Order> selectByEvalID(int id){
    List<Order> listid=orderMapper.selectByEvalID(id);
    List<Order> listorder = new ArrayList<Order>();
    //System.out.println("订单数量"+listid.size());
    int i=0;
    for(;i<listid.size();i++)
	{
    Order order=orderMapper.selectGoods(listid.get(i).getId());
    //System.out.println(order);
    listorder.add(order);
	}
    //System.out.println("订单数量:"+i);
    //System.out.println("商品数量:"+listorder.size());
    return listorder;
}
//插入
public void insertbyid(int goodsid, int goodsid2) {
	// TODO Auto-generated method stub
	orderMapper.insertbyid(goodsid,goodsid2);
}
//查最大id
public int selectmaxid() {
	// TODO Auto-generated method stub
	return orderMapper.selectmaxid();
}
public void delectorder(int orderid) {
	// TODO Auto-generated method stub
	orderMapper.delete(orderid);
}
//收货
public void changeorder(int orderid) {
	// TODO Auto-generated method stub
	orderMapper.changeorder(orderid);
}

public Order selectByID(int orderid) {
	// TODO Auto-generated method stub
	return orderMapper.selectByID(orderid);
}
}
