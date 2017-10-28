package test_interface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import test_pojo.Membercg;


public interface MembercgMapper {
	@Insert("insert into membercg(member_id,goods_id) value(#{member_id},#{goods_id})")
	void insert(@Param("member_id")int member_id,@Param("goods_id")int goods_id);
	
	@Delete("DELETE FROM Membercg where id = #{0}")
	void delete(int id);
	void update(Membercg membercg);
	Membercg selectByID(Membercg membercg);
	List selectpage(final int begin,final int size);
	void insertbyid(Membercg membercg);
	
	@Select("select * from membercg where member_id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="collectionDate",property="collectionDate"),
		@Result(column="member_id",property="member_id"),
		@Result(column="goods_id",property="goods_id"),
		@Result(column="goods_id",property="goods",
		many=@Many(
				select="test_interface.GoodsMapper.selectByParamiryKey",
				fetchType=org.apache.ibatis.mapping.FetchType.EAGER))
})
    List<Membercg> selectbymeid(int memberid);
}
