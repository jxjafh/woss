package test_interface;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import test_pojo.Sort;


public interface SortMapper {
	void insert(Sort sort);
	void delete(int id);
	void update(Sort sort);
	Sort selectByID(Sort sort);
	List selectpage(final int begin,final int size);
//	@Select("")
//	@Results({
//		@Result(id=true,column="id",property="id"),
//		@Result(column="",property=""),
//		@Result(column="id",property="id",
//				many=@Many(
//						select="",
//						fetchType=org.apache.ibatis.mapping.FetchType.LAZY))
//	})
	void insertbyid(Sort sort);
	
	@Select("select id,sortname from sort")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="sortname",property="sortname"),
			})
	List<Sort> mainpage();
	
	@Select("select * from sort")
	List<Sort> selectAll();
	
	@Select("SELECT * FROM sort WHERE id = #{id}")
	Sort selectByParamaryKey(int id);
}
