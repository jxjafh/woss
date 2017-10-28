package test_action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import test_service.Membercgservice;
@Controller
@Transactional

public class membercginfo {
	@Autowired
private Membercgservice membercgservice;
	//收藏
@RequestMapping("membercg")
public void cginsert(String member_id,String goods_id){
	
	
	System.out.println(member_id+"**************"+goods_id);
	int memberid=Integer.parseInt(member_id);
	int goodsid=Integer.parseInt(goods_id);
	System.out.println(memberid+"***"+goodsid);
	membercgservice.cginsert(memberid,goodsid);
}
}
