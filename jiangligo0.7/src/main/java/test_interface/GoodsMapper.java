package test_interface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import test_pojo.Goods;


public interface GoodsMapper {
	void insert(Goods goods);
	void update(Goods goods);
	
	@Insert( "INSERT INTO goods (NAME, info, pic,price, sort_id,member_id) "
			+ "values(#{name}, #{info,jdbcType=VARCHAR},#{pic,jdbcType=VARCHAR},"
			+ "#{price,jdbcType=DOUBLE},#{sort_id,jdbcType=INTEGER},"
			+ " #{member_id,jdbcType=INTEGER})")
	void release(Goods goods);
	
	@Delete("delete from goods where id = #{id,jdbcType=VARCHAR}")
	void delete(int id);
	
	@Select("select id,name,info,price,pic from goods where order_id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="info",property="info"),
		@Result(column="pic",property="pic"),
		@Result(column="price",property="price")//property 表名
	})
	List<Goods> selectByID(int id);
	
	List selectpage(final int begin,final int size);
	void insertbyid(Goods goods);
    
	//审核
	@Select("select id,name,info,releasetime,price,originalprice,state,member_id from goods limit #{intal},#{size}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="originalprice",property="originalprice"),
		@Result(column="member_id",property="member_id"),
		@Result(column="state",property="state"),
		@Result(column="info",property="info"),
		@Result(column="releasetime",property="releasetime"),
		@Result(column="price",property="price"),
		@Result(column="member_id",property="member",
		many=@Many(
				select="test_interface.MemberMapper.selectByID",
				fetchType=org.apache.ibatis.mapping.FetchType.EAGER))
})	
	List<Goods> Auditgoods(@Param("intal")int intal,@Param("size")int size);
	
	//根据member_id查发布的商品
	@Select("SELECT	* FROM goods WHERE member_id = #{member_id} ")
	List<Goods> selectByMemberID(int member_id);
	
	//总数
	@Select("select count(*) from goods")
	int sum();
	
	@Update("update goods set state='已通过' where id=#{id}")
	void changebyid(@Param("id") int id);
	
	//商品详情
	@Select("select * from goods where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="originalprice",property="originalprice"),
		@Result(column="info",property="info"),
		@Result(column="pic",property="pic"),
		@Result(column="member_id",property="member_id"),
		@Result(column="price",property="price")

})	
	Goods goodsdetails(@Param("id")int id);
	//最新10条
	@Select("SELECT id,name,pic,price,member_id FROM goods where state='已通过' ORDER BY releasetime DESC  LIMIT 0,10 ")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="member_id",property="member_id"),
		@Result(column="price",property="price"),
		@Result(column="pic",property="pic"),
})	
	List<Goods> mainpage();
	//购买商品
	@Update("update goods set order_id=#{order_id} where id=#{id}")
	void shop(@Param("id")int id,@Param("order_id")int orderid);
	/**
	 *按类别查询，并分页 
	 * @param sort_id
	 * @return
	 */
	@Select("SELECT * FROM goods WHERE sort_id = #{0} LIMIT #{1},#{2}")
	List<Goods> selectBySortId(int sort_id,int begin,int size);
	
	@Select("SELECT * FROM goods WHERE sort_id = #{0} ORDER BY price LIMIT #{1},#{2}")
	List<Goods> selectBySortIdOrderByPrice(int sort_id,int begin,int size);
	
	@Select("SELECT * FROM goods WHERE sort_id = #{0} ORDER BY price DESC LIMIT #{1},#{2}")
	List<Goods> selectBySortIdOrderByPriceDesc(int sort_id,int begin,int size);
	
	/**按商品名字模糊查询并分页
	 * @param keyName
	 * @return
	 */
	@Select("SELECT * FROM goods WHERE NAME LIKE CONCAT(CONCAT('%', #{0}), '%') LIMIT #{1},#{2}")
	List<Goods> selectByNameLike(String keyName,int begin,int size);
	
	/**
	 * 按商品名字模糊查询并分页,升序
	 * @param keyName
	 * @param orderName
	 * @param begin
	 * @param end
	 * @return
	 */
	@Select("SELECT * FROM goods WHERE NAME LIKE CONCAT(CONCAT('%', #{0}), '%') ORDER BY price LIMIT #{1},#{2} ")
	List<Goods> selectByNameLikeOrderByPrice(String keyName,int begin,int size);
	
	/**
	 * 按商品名字模糊查询并分页,按价格降序
	 * @param keyName
	 * @param orderName
	 * @param begin
	 * @param end
	 * @return
	 */
	@Select("SELECT * FROM goods WHERE NAME LIKE CONCAT(CONCAT('%', #{0}), '%') ORDER BY price DESC LIMIT #{1},#{2}")
	List<Goods> selectByNameLikeOrderByPriceDesc(String keyName,int begin,int size);
	
	@Select(" SELECT	COUNT(*) FROM goods WHERE sort_id = #{0} ")
	int getSumBySortId(int sort_id);
	
	@Select("SELECT COUNT(*) FROM goods WHERE NAME LIKE CONCAT(CONCAT('%', #{0}), '%') ")
	int getSumByNameLike(String key);
	
	@Select("select * from goods where id=#{id}")
	Goods selectByParamiryKey(int id);
	
	@Update("update goods set order_id=0 where id=#{orderid}")
	void updatebyorderid(int orderid);
}
