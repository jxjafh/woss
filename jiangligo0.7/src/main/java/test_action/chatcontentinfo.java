package test_action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test_pojo.Chatcontent;
import test_service.ChatcontentService;

@Controller
@Transactional
@RequestMapping("/chat")
public class chatcontentinfo {
@Autowired
private ChatcontentService chatcontentService;
//存
@RequestMapping("/chatsend")
public void Insert(String receiver,String sender,String content){
	Chatcontent chatcontent=new Chatcontent(receiver,sender,content);
	chatcontentService.Insert(chatcontent);
}

@RequestMapping("/allcontent")
public String allcontent(String sender,String receiver,ModelMap map){
List<Chatcontent> list=chatcontentService.allcontent(sender,receiver);
if(list.size()>0){
map.addAttribute("lasttime", list.get(list.size()-1).getTime());
}
map.addAttribute("list", list);
return "chatcontent";
}
//查看最新消息
@RequestMapping("/lasttime")
@ResponseBody
public List<Chatcontent> lasttime(String lasttime,String receiver,String sender,ModelMap map){
	List<Chatcontent> list=chatcontentService.lasttime(lasttime,receiver,sender);
    if(list.size()>0)
    {
    	//map.addAttribute("lasttime", list.get(list.size()-1).getTime());
    	return list; 
    }else
    {
    	return null;
    }
}
}

