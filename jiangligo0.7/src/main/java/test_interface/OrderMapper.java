package test_interface;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import test_pojo.Order;


public interface OrderMapper {
	//jiangligo.order  sql语句一律加前缀!
	@Insert("insert into jiangligo.order(member_id) values(#{member_id})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void insert(Order order);
	@Select("SELECT MAX(id) FROM jiangligo.order")
	int selectmaxid();
	//插入商品
	@Insert("insert into jiangligo.order(id,member_id) values(#{id},#{member_id})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void insertbyid(@Param("id")int id,@Param("member_id")int goodsid2);
	
	@Delete("delete from jiangligo.order where id=#{id}")
	void delete(int id);
	@Update("")
	void update(Order order);
	
	@Select("select * from jiangligo.order where id=#{id}")
	@Options(useCache = true, flushCache = false, timeout = 10000)  
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="orderDate",property="orderDate"),
		@Result(column="state",property="state"),
		@Result(column="member id",property="member_id")
		})
	Order selectByID(int id);
	
	//全部查询
	@Select("select * from jiangligo.order where member_id=#{id}")
	@Options(useCache = true, flushCache = false, timeout = 10000)  
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="orderDate",property="orderDate"),
		@Result(column="state",property="state"),
		@Result(column="member id",property="member_id")
		})
	List<Order> selectByMebID(int id);
	
	//待处理查询
	@Select("select * from jiangligo.order where member_id=#{id} and state=1")
	@Options(useCache = true, flushCache = false, timeout = 10000)  
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="orderDate",property="orderDate"),
		@Result(column="state",property="state"),
		@Result(column="member id",property="member_id")
		})
	List<Order> selectByHandID(int id);
	
	//待评价  查询 
	@Select("select * from jiangligo.order where member_id=#{id} and state=2")
	@Options(useCache = true, flushCache = false, timeout = 10000)  
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="orderDate",property="orderDate"),
		@Result(column="state",property="state"),
		@Result(column="member id",property="member_id")
		})
	List<Order> selectByEvalID(int id);
	//分页
	List<Order> selectpage(final int begin,final int size);
	//one to many 查询用户总订单  先查用户订单Id，在分别查对应商品
	void insertbyid(Order order);
	
	@Select("select * from jiangligo.order where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="orderDate",property="orderDate"),
		@Result(column="member id",property="member_id"),
		@Result(column="state",property="state"),
		@Result(column="id",property="goods",
				many=@Many(
						select="test_interface.GoodsMapper.selectByID",
						fetchType=org.apache.ibatis.mapping.FetchType.EAGER))
	})
	Order selectGoods(int id);
	@Update("update order set state='2' where id=#{orderid}")
	void changeorder(int orderid);


	
 
}
