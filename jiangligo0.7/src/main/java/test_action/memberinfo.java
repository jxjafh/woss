package test_action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import test_pojo.Member;
import test_service.Memberservice;

@Controller
@Transactional
@RequestMapping("/admin")
public class memberinfo {
	final int size=13;
@Autowired
private Memberservice memberservice;
//分页查询
@RequestMapping("/allmember")
public String allmember(int intal,ModelMap map){
	
	List<Member> list=memberservice.selectall(intal, size);
	map.addAttribute("list", list);
	map.addAttribute("page",intal/size);
	int sum=memberservice.sum();
	if(sum%size==0){
		map.addAttribute("sum",sum/size-1);
		}else{
		map.addAttribute("sum",sum/size);
		}
	if(intal/size<sum/size){
		map.addAttribute("page",intal/size);
		}else {
		map.addAttribute("page",sum/size);
		}
		map.addAttribute("size",size);
	return "membermanage";
}
//通过审查
@RequestMapping("/changebyid")
public void changebyid(int id,HttpServletResponse arg1){
	 memberservice.changebyid(id);
	 arg1.setCharacterEncoding("utf-8");
     try {
		arg1.getWriter().print("操作成功");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//批量审查
@RequestMapping("/memberchangebyidpiliang")
public void memberchangebyidpiliang(int id,HttpServletResponse arg1){
	for(int i=1;i<(id+size);i++){
		memberservice.changebyid(i);
	}
		 arg1.setCharacterEncoding("utf-8");
	     try {
			arg1.getWriter().print("批量操作成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
