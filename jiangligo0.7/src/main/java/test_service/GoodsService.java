package test_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test_interface.FootmarkMapper;
import test_interface.GoodsMapper;
import test_interface.MembercgMapper;
import test_pojo.Footmark;
import test_pojo.Goods;
import test_pojo.Membercg;
@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private MembercgMapper membercgMapper;

	@Autowired
	private FootmarkMapper footmarkMapper;
//分页查询
public List<Goods> Auditgoods(int intal,int size){
	System.out.println(intal);
	return goodsMapper.Auditgoods(intal,size);
}
//表总行数
public int sum(){
	return goodsMapper.sum();	
}
//xhx
public void release(Goods goods){
	goodsMapper.release(goods);
}
public List<Goods> released(int member_id){
	return goodsMapper.selectByMemberID(member_id);
}
public void del(int id){
	goodsMapper.delete(id);
}
public List<Membercg> listCollection(int member_id){
	return membercgMapper.selectbymeid(member_id);
}
public List<Footmark> listFootmark(int member_id){
	List<Footmark> footmarks = footmarkMapper.selectByMemberId(member_id);
	for(Footmark f:footmarks){
		Goods g = f.getGoods();
		if(g.getPic()!=null){
			String picName = g.getPic().split(":")[0];
			g.setPic(picName);
		}
	}
	return footmarks;
}

public List<Goods> listBySortLimit(int sort_id,int begin,int size){
	return makeGoodsWidthFirstPic(goodsMapper.selectBySortId(sort_id, begin, size));
}

public List<Goods> listBySortLimitOrderByPrice(int sort_id,int begin,int size){
	return makeGoodsWidthFirstPic(goodsMapper.selectBySortIdOrderByPrice(sort_id, begin, size));
}

public List<Goods> listBySortLimitOrderByPriceDesc(int sort_id,int begin,int size){
	return makeGoodsWidthFirstPic(goodsMapper.selectBySortIdOrderByPriceDesc(sort_id, begin, size));
}

public List<Goods> listByNameLikeLimit(String key,int begin,int size){
	return makeGoodsWidthFirstPic(goodsMapper.selectByNameLike(key, begin, size));
}

public List<Goods> listByNameLikeLimitOrderByPrice(String keyName,int begin,int size){
	return makeGoodsWidthFirstPic(goodsMapper.selectByNameLikeOrderByPrice(keyName, begin, size));
}

public List<Goods> listByNameLikeLimitOrderByPriceDesc(String keyName,int begin,int size){
	return makeGoodsWidthFirstPic(goodsMapper.selectByNameLikeOrderByPriceDesc(keyName, begin, size));
}

public int getSumBySortId(int sort_id){
	return goodsMapper.getSumBySortId(sort_id);
}

public int getSumByNameLike(String key){
	return goodsMapper.getSumByNameLike(key);
}



public static List<Goods> makeGoodsWidthFirstPic(List<Goods> list){
	List<Goods> newList = new ArrayList<Goods>();
	for(Goods g:list){
//		System.out.println(g);
		if(g.getPic()!=null){
			String picName = g.getPic().split(":")[0];
			g.setPic(picName);
		}
		newList.add(g);
	}
	return newList;
}

//通过审查
public void changebyid(int id) {
	// TODO Auto-generated method stub
	 goodsMapper.changebyid(id);
}
//商品详情
public Goods goodsdetails(int id) {
	// TODO Auto-generated method stub
	return goodsMapper.goodsdetails(id);
}
//最新10条
public List<Goods> mainpage() {
	// TODO Auto-generated method stub
	return goodsMapper.mainpage();
}
//购买商品
public void shop(int id,int orderid){
goodsMapper.shop(id,orderid);
}
public void updatebyorderid(int orderid) {
	// TODO Auto-generated method stub
	goodsMapper.updatebyorderid(orderid);
}
public List<Goods> selectByID(int id) {
	// TODO Auto-generated method stub
	return goodsMapper.selectByID(id);
}

}