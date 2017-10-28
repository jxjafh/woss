package test_interface;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import test_pojo.Chatcontent;

public interface ChatContentMapper {
@Insert("insert into chatcontent(sender,receiver,content) value(#{sender},#{receiver},#{content})")
void insert(Chatcontent chatcontent);

//查全部
@Select("SELECT * FROM chatcontent WHERE (sender=#{sender} AND receiver=#{receiver}) OR (receiver=#{sender} AND sender=#{receiver}) ORDER BY time")
@Results({
	@Result(id=true,column="id",property="id"),
	@Result(column="sender",property="sender"),
	@Result(column="receiver",property="receiver"),
	@Result(column="content",property="content"),
	@Result(column="time",property="time")
})
List<Chatcontent> findchatcontent(@Param("sender")String sender,@Param("receiver")String receiver);

//查看最新消息
@Select("SELECT * FROM chatContent WHERE time>#{lasttime} and receiver=#{receiver}  and sender=#{sender}")
@Results({
	@Result(id=true,column="id",property="id"),
	@Result(column="sender",property="sender"),
	@Result(column="receiver",property="receiver"),
	@Result(column="content",property="content"),
	@Result(column="time",property="time")
})
List<Chatcontent> lasttime(@Param("lasttime")String lasttime,@Param("receiver")String receiver,@Param("sender")String sender);
//联系人
@Select("SELECT DISTINCT sender FROM chatContent where receiver=#{receiver}")
@Results({
	@Result(id=true,column="id",property="id"),
	@Result(column="receiver",property="receiver"),
})
List<Chatcontent> lianxiren(@Param("receiver")String receiver);
}
