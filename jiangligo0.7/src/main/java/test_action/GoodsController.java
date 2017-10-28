package test_action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import test_pojo.Footmark;
import test_pojo.Goods;
import test_pojo.Member;
import test_pojo.Membercg;
import test_service.GoodsService;
import test_service.SortService;
import test_util.JLGOUtil;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	private int size = 20;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private SortService sortService;
/*
 * jsp页面
 */
	@RequestMapping(value="rel")
	public String rel(){
		return "member/release";
	}
	@RequestMapping(value="reld")
	public String reld(){
		return "member/goods-released";
	}
	@RequestMapping(value="col")
	public String col(){
		return "member/goods-collection";
	}
	@RequestMapping(value="fm")
	public String fm(){
		return "member/footmark";
	}
	
	
	@RequestMapping(value="/release",method=RequestMethod.POST)
	public String release(Goods goods,HttpServletRequest req) throws IllegalStateException, IOException{
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		
		List<MultipartFile> pics = multipartRequest.getFiles("pics");
		
		String pics_path = "";
		for(MultipartFile p:pics){
			
			if(!p.isEmpty()){
				
				String p_name =JLGOUtil.generateFileName(p.getOriginalFilename());
				String p_path = JLGOUtil.pic_save_path+"/"+p_name;
				p.transferTo(new File(p_path));
				pics_path+=JLGOUtil.virtual_path+"/"+p_name+":";
			}
		}
		
		//获取当前用户id
		Object object = req.getSession().getAttribute("member");  
        Member member = object == null ? null : (Member) object;  
		int member_id = member.getId();
		
		goods.setMember_id(member_id);
		goods.setPic(pics_path);
		goodsService.release(goods);
//		System.out.println("发布中");
		return "redirect:/goods/released.do";
	}
	
	@RequestMapping("/released")
	public String released(HttpServletRequest req){
	
		//获取当前用户id
		Object object = req.getSession().getAttribute("member");  
        Member member = object == null ? null : (Member) object;  
		int member_id = member.getId();
		List<Goods> released = goodsService.released(member_id);
		for(Goods g:released){
			if(g.getPic()!=null){
			
			String picName = g.getPic().split(":")[0];
			g.setPic(picName);
			}
		}
		req.setAttribute("released", released);
		return "forward:/goods/reld.do";
	}
	
	@RequestMapping("/del-released")
	public String del(int id){
		goodsService.del(id);
		return "forward:/goods/released.do";
	}
	
	@RequestMapping("/collection")
	public String collection(HttpServletRequest req){
		//获取当前用户id
		Object object = req.getSession().getAttribute("member");  
        Member member = object == null ? null : (Member) object;  
		int member_id = member.getId();
		
		//获取收藏列表
		List<Membercg> membercgs = goodsService.listCollection(member_id);
		for(Membercg m:membercgs){
			Goods g = m.getGoods();
			if(g.getPic()!=null){
				String picName = g.getPic().split(":")[0];
				g.setPic(picName);
			}
		}
		req.setAttribute("membercgs", membercgs);
		return "forward:/goods/col.do";
	}
	
	@RequestMapping("/footmark")
	public String footmark(HttpServletRequest req){
		//获取当前用户id
		Object object = req.getSession().getAttribute("member");  
        Member member = object == null ? null : (Member) object;  
		int member_id = member.getId();
		
		List<Footmark> footmarks = goodsService.listFootmark(member_id);
		
		req.setAttribute("footmarks", footmarks);
		return "forward:/goods/fm.do";
	}
	
	@RequestMapping("/listBySortLimit")
	public String listBySortLimit(int sort_id,int page,HttpServletRequest request){

		String key = sortService.findSort(sort_id).getSortname();
		
		List<Goods> listBySort = goodsService.listBySortLimit(sort_id, (page-1)*size, size);
		
		//分页所需参数
//		request.setAttribute("orderName", null); 
//		request.setAttribute("DESC", 0);
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("sum", goodsService.getSumBySortId(sort_id)/size+1);
		
		request.setAttribute("sort_id", sort_id);
		request.setAttribute("key", key);
		request.setAttribute("list", listBySort);
		return "/goodslist";
	}
	
	@RequestMapping("/listBySortLimitOrderByPrice")
	public String listBySortLimitOrderByPrice(int sort_id,int page,HttpServletRequest request){

		String key = sortService.findSort(sort_id).getSortname();
		
		List<Goods> listBySort = goodsService.listBySortLimitOrderByPrice(sort_id,(page-1)*size, size);
		
		//分页所需参数
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("sum", goodsService.getSumBySortId(sort_id)/size+1);
		
		request.setAttribute("page", sort_id+1);
		request.setAttribute("sort_id", sort_id);
		request.setAttribute("key", key);
		request.setAttribute("list", listBySort);
		return "/goodslist";
	}
	
	@RequestMapping("/listBySortLimitOrderByPriceDesc")
	public String listBySortLimitOrderByPriceDesc(int sort_id,int page,HttpServletRequest request){

		String key = sortService.findSort(sort_id).getSortname();
		
		List<Goods> listBySort = goodsService.listBySortLimitOrderByPriceDesc(sort_id,(page-1)*size, size);
		
		//分页所需参数
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("sum", goodsService.getSumBySortId(sort_id)/size+1);
		
		request.setAttribute("sort_id", sort_id);
		request.setAttribute("key", key);
		request.setAttribute("list", listBySort);
		return "/goodslist";
	}
	
	@RequestMapping("/listByNameLikeLimit")
	public String listByNameLikeLimit(String key,int page,HttpServletRequest request){

		List<Goods> listBySort = goodsService.listByNameLikeLimit(key, (page-1)*size, size);
		
		//分页所需参数
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("sum", goodsService.getSumByNameLike(key)/size+1);
		
		request.setAttribute("sort_id", -1);
		request.setAttribute("key", key);
		request.setAttribute("list", listBySort);
		return "/goodslist";
	}
	
	@RequestMapping("/listByNameLikeLimitOrderByPrice")
	public String listByNameLikeLimitOrderByPrice(String key,int page,HttpServletRequest request){

		List<Goods> listBySort = goodsService.listByNameLikeLimitOrderByPrice(key, (page-1)*size, size);
		
		//分页所需参数
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("sum", goodsService.getSumByNameLike(key)/size+1);
		
		request.setAttribute("sort_id", -1);
		request.setAttribute("key", key);
		request.setAttribute("list", listBySort);
		return "/goodslist";
	}
	
	@RequestMapping("/listByNameLikeLimitOrderByPriceDesc")
	public String listByNameLikeLimitOrderByPriceDesc(String key,int page,HttpServletRequest request){

		List<Goods> listBySort = goodsService.listByNameLikeLimitOrderByPriceDesc(key, (page-1)*size, size);
		
		//分页所需参数
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("sum", goodsService.getSumByNameLike(key)/size+1);
		
		request.setAttribute("sort_id", -1);
		request.setAttribute("key", key);
		request.setAttribute("list", listBySort);
		return "/goodslist";
	}
}
	
	
	
	
