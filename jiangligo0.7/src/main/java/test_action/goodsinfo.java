package test_action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test_pojo.Goods;
import test_service.GoodsService;
import test_service.Memberservice;
@Controller
@Transactional
@RequestMapping("/admin")
public class goodsinfo {
	@Autowired
private GoodsService goodsService;
	@Autowired
private Memberservice memberservice;
	final int size=13;

//分页查询
	@RequestMapping("/audit")
public String auditgoods(int intal,ModelMap mp){
		List<Goods> list=goodsService.Auditgoods(intal,size);
		int sum=goodsService.sum();
		if(sum%size==0){
		mp.addAttribute("sum",sum/size-1);
		}else{
		mp.addAttribute("sum",sum/size);
		}
		if(intal/size-2<sum/size){
		mp.addAttribute("page",intal/size);
		}else {
		mp.addAttribute("page",sum/size);
		}
		mp.addAttribute("size",size);
		mp.addAttribute("list",list);
	return "adminmanage";
}
	//通过审查
	@RequestMapping("/goodschangebyid")
	public void changebyid(int id,HttpServletResponse arg1){
		 goodsService.changebyid(id);
		 arg1.setCharacterEncoding("utf-8");
	     try {
			arg1.getWriter().print("操作成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//商品详情
	@RequestMapping("/goodsdetails")
	public String goodsdetails(int id,ModelMap map){
		 Goods goods=goodsService.goodsdetails(id);
		 String membername=memberservice.findmembername(goods.getMember_id());
		 map.addAttribute("membername", membername);
		 map.addAttribute("goods", goods);
		 	return "gooddetails";
	}
	//批量通过审查
	@RequestMapping("/goodschangebyidpiliang")
	public void goodschangebyidpiliang(int id,HttpServletResponse arg1){
		for(int i=1;i<(id+size);i++){
			goodsService.changebyid(i);
		}
			 arg1.setCharacterEncoding("utf-8");
		     try {
				arg1.getWriter().print("批量操作成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
