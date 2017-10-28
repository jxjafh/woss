package test_action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import test_pojo.Chatcontent;
import test_pojo.Goods;
import test_pojo.Sort;
import test_service.ChatcontentService;
import test_service.GoodsService;
import test_service.SortService;
@Controller
@Transactional
public class mainpage {
	@Autowired
private GoodsService goodsService;
	@Autowired
private SortService sortService;
	@Autowired
private ChatcontentService chatcontentService;
//最新10条分类
//最新10条商品	
	@RequestMapping("mainpage")
	private String mainpagegoods(ModelMap map){
		List<Goods> listgoods=goodsService.mainpage();
		List<Sort> listsort=sortService.mainpage();
		
		List<Goods> goodses = GoodsService.makeGoodsWidthFirstPic(listgoods);
		
		 map.addAttribute("listsort", listsort);
		 map.addAttribute("listgoods", goodses);
		 
	 return "forward:/mainpage.jsp";
	}
	@RequestMapping("lianxiren")
	private String lianxiren(String receiver,ModelMap map){
		List<Chatcontent> listlianxiren=chatcontentService.lianxiren(receiver);
		map.addAttribute("listlianxiren", listlianxiren);
		return "lianxiren";
	}
}
