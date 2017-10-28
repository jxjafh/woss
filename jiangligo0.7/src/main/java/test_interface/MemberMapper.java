package test_interface;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import test_pojo.Member;


public interface MemberMapper {
	void insert(Member member);
	void delete(int id);
	void update(Member member);
	/**
	 * fh
	 * @param id
	 * @return
	 * @time 2017-4-5
	 */
	@Select("select username,gender,evaluate,telephone,email,state from member where id=#{id}")
			@Results({
				@Result(id=true,column="id",property="id"),
				@Result(column="username",property="username"),
				@Result(column="gender",property="gender"),
				@Result(column="evaluate",property="evaluate"),
				@Result(column="telephone",property="telephone"),
				@Result(column="email",property="email"),
				@Result(column="state",property="state")})	
	Member selectByID(@Param("id")int id);
	
	@Select("select id,username,gender,evaluate,telephone,email,state from member limit #{intal},#{size}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="username",property="username"),
		@Result(column="gender",property="gender"),
		@Result(column="evaluate",property="evaluate"),
		@Result(column="telephone",property="telephone"),
		@Result(column="email",property="email"),
		@Result(column="state",property="state")})
	List<Member> selectpage(@Param("intal")final int intal,@Param("size")final int size);
	void insertbyid(Member member);
	@Select("select count(*) from member")
	int sum();
	
	@Update("update member set state='已通过' where id=#{id}")
	void changebyid(@Param("id") int id);
	
	/**
	 * @author lips
	 * 验证名字唯一
	 */
	@Select("select id,username,password,email from member where username=#{name} or email=#{name}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="username",property="username"),
		@Result(column="password",property="password"),
		@Result(column="email",property="email")
	})
	Member loginfindname(@Param("name")String name);
	
	@Insert("insert into member(username,password,email) values(#{username},#{password},#{email})")
	void insertmember(Member member);
	
	@Select("select id,username,password,email from member where email=#{email}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="username",property="username"),
		@Result(column="password",property="password"),
		@Result(column="email",property="email")
	})
	Member loginfindemail(@Param("email")String email);
	@Select("select username from member where id=#{id}")
	String findmembername(int id);
}
