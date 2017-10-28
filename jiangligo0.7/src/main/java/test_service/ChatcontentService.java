package test_service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test_interface.ChatContentMapper;
import test_pojo.Chatcontent;
@Service
public class ChatcontentService {
@Autowired
	private ChatContentMapper chatContentMapper;
public void Insert(Chatcontent chatcontent){
	 chatContentMapper.insert(chatcontent);
}
//历史消息记录
public List<Chatcontent> allcontent(String sender,String receiver) {
	// TODO Auto-generated method stub
	return chatContentMapper.findchatcontent(sender, receiver);
}
//最后一次发送消息时间
public List<Chatcontent> lasttime(String lasttime,String receiver,String sender) {
	// TODO Auto-generated method stub
	return chatContentMapper.lasttime(lasttime,receiver,sender );
}
//联系人
public List<Chatcontent> lianxiren(String recevicer) {
	// TODO Auto-generated method stub
	return chatContentMapper.lianxiren(recevicer);
}
}
