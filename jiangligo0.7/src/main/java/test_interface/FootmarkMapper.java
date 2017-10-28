package test_interface;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import test_pojo.Footmark;


public interface FootmarkMapper {
	void insert(Footmark footmark);
	void delete(int id);
	void update(Footmark footmark);
	Footmark selectByID(Footmark footmark);
	List selectpage(final int begin,final int size);
	void insertbyid(Footmark footmark);
	
	@Select("select * from footmark where member_id=#{member_id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="member_id",property="member_id"),
		@Result(column="goods_id",property="goods_id"),
		@Result(
				column="goods_id",property="goods",
				many=@Many(
					select="test_interface.GoodsMapper.selectByParamiryKey",
					fetchType=org.apache.ibatis.mapping.FetchType.EAGER
				)
		)
	})
    List<Footmark> selectByMemberId(int member_id);
}