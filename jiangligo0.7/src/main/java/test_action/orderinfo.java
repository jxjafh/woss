package test_action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test_interface.OrderMapper;
import test_pojo.Admin;
import test_pojo.Goods;
import test_pojo.Order;
import test_pojo.ordersandgoods;
import test_service.GoodsService;
import test_service.Orderservice;

@Controller
@Transactional
public class orderinfo {
@Autowired
	private Orderservice orderservice; 
@Autowired
  private GoodsService goodsService;

//购买商品
@RequestMapping("/insertgoods")
public void insertgoods(int goodsid,int memberid){
	//最大id+1
	int maxid=orderservice.selectmaxid();
	//插入memberid到order表
	orderservice.insertbyid(maxid+1,memberid);
	goodsService.shop(goodsid, maxid+1);
}
//收货
@RequestMapping("/changeorder")
public void changeorder(int orderid){
	orderservice.changeorder(orderid);
}
//删除表单
@RequestMapping("/delectorder")
public void delectorder(int orderid){
	//String[] id=orderid.split(",");
	if(goodsService.goodsdetails(orderid)!=null){
		Goods orderidd=goodsService.goodsdetails(orderid);
	System.out.println("-----------------------------------------------------------------"+orderid);
	System.out.println("-----------------------------------------------------------------"+orderidd.getOrder_id());
	goodsService.updatebyorderid(orderid);
	if(goodsService.selectByID(orderid)==null||goodsService.selectByID(orderid).isEmpty()){
		orderservice.delectorder(orderidd.getOrder_id());
	}
	
	
	//orderservice.delectorder(Integer.parseInt(id[0]));
}
}
	@RequestMapping("/getallorder") 
	public String selectGoods(int id,ModelMap map){
		String[] goods1={"购买","确认收货","退款/退换"};
		String[] order2={"购买","正在交易","订单完成"};
		String[] order1={"购买","取消商品","评价"};
 	List<Order> list=orderservice.selectGoods(id);
 	List<ordersandgoods> lastlist=new ArrayList<ordersandgoods>();
	for (int i = 0; i < list.size(); i++) {
		ordersandgoods og=new ordersandgoods();
		og.setId(list.get(i).getId());
		og.setGoods(list.get(i).getGoods());
		og.setOrderDate(list.get(i).getOrderDate());
		og.setOrderoperation(order1[list.get(i).getState()]);
		og.setOrderstate(order2[list.get(i).getState()]);
		og.setGoodsoperation(goods1[list.get(i).getState()]);
		lastlist.add(og);
	}
	
	map.addAttribute("lastlist",lastlist);
		return "allorder";
	}
	
	@RequestMapping("/getHandorder") 
	public String selectHandGoods(int id,ModelMap map){
		String[] goods1={"购买","确认收货","退款/退换"};
		String[] order2={"购买","正在交易","订单完成"};
		String[] order1={"购买","取消订单","评价"};
 	List<Order> list=orderservice.selectByHandID(id);
	List<ordersandgoods> lastlist=new ArrayList<ordersandgoods>();
 	if(list!=null&&list.size()!=0){
	for (int i = 0; i < list.size(); i++) {
		ordersandgoods og=new ordersandgoods();
		og.setId(list.get(i).getId());
		og.setGoods(list.get(i).getGoods());
		og.setOrderDate(list.get(i).getOrderDate());
		og.setOrderoperation(order1[list.get(i).getState()]);
		og.setOrderstate(order2[list.get(i).getState()]);
		og.setGoodsoperation(goods1[list.get(i).getState()]);
		lastlist.add(og);
	}
 	}
	map.addAttribute("lastlist",lastlist);
		return "allorder";
	}
	
	@RequestMapping("/selectevaluate") 
	public String selectevaluateGoods(int id,ModelMap map){
		String[] goods1={"购买","确认收货","退款/退换"};
		String[] order2={"购买","正在交易","订单完成"};
		String[] order1={"购买","取消订单","评价"};
 	List<Order> list=orderservice.selectByEvalID(id);
 	List<ordersandgoods> lastlist=new ArrayList<ordersandgoods>();
	for (int i = 0; i < list.size(); i++) {
		ordersandgoods og=new ordersandgoods();
		og.setId(list.get(i).getId());
		og.setGoods(list.get(i).getGoods());
		og.setOrderDate(list.get(i).getOrderDate());
		og.setOrderoperation(order1[list.get(i).getState()]);
		og.setOrderstate(order2[list.get(i).getState()]);
		og.setGoodsoperation(goods1[list.get(i).getState()]);
		lastlist.add(og);
	}
	map.addAttribute("lastlist",lastlist);
		return "allorder";
	}
}
