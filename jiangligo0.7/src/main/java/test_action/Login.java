package test_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test_pojo.Member;
import test_service.Memberservice;
import test_util.SendEmail;


@Controller
public class Login {
	
	@Autowired
	private Memberservice memberservice;

	@RequestMapping("/login")
	public String login(@RequestParam("loginName") String loginName,@RequestParam("password") String password,Model model,HttpServletRequest request){
		Member member=memberservice.loginfindname(loginName);
		
		if(member==null){
			return "redirect:/Login.jsp";
		}
		else if(password.equals(member.getPassword())){
			HttpSession session = request.getSession();
			session.removeAttribute("member");
			session.setMaxInactiveInterval(30*60);
			session.setAttribute("member", member);
			model.addAttribute("loginName", loginName);
			return "forward:/mainpage.do";
		}else{
				return "redirect:/Login.jsp";
		}
		}
	@RequestMapping("/nameCheck")
	public void nameCheck(String loginName,HttpServletResponse arg1) throws Exception {
	// TODO Auto-generated method stub
	
			Member member=memberservice.loginfindname(loginName);
			System.out.println("**"+loginName);
			if(member==null){
				arg1.setCharacterEncoding("utf-8");
				arg1.getWriter().print("√用户名可用");
							}else{
				arg1.setCharacterEncoding("utf-8");
				arg1.getWriter().print("×用户名已存在！");
					}
			}
	@RequestMapping("/emailCheck")
	public void emailCheck(String loginemail,HttpServletResponse arg2) throws Exception {
		// TODO Auto-generated method stub
		
				Member member2=memberservice.loginfindemail(loginemail);
				System.out.println("**"+loginemail);
				if(member2==null){
					arg2.setCharacterEncoding("utf-8");
					arg2.getWriter().print("√邮箱可用");
				}else{
					arg2.setCharacterEncoding("utf-8");
					arg2.getWriter().print("×邮箱已注册！");
						}
				}
	
	@RequestMapping("/getCode")
	public void  getCode(HttpServletRequest req,String mail){
		SendEmail sendEmail=new SendEmail();
		HttpSession session = req.getSession();
		String code = sendEmail.send(mail);
		session.setAttribute("code",code);
		System.out.println(code);
	}
	@RequestMapping("/registerCheck")
	@ResponseBody
	public String registerCheck(HttpServletRequest req, String code1){
		
		String code=(String) req.getSession().getAttribute("code");
		System.out.println(code1);
		System.out.println(code);
		if(code1.equals(code)){
			System.out.println("验证码符合");
			return "true";
		
		}else{
			System.out.println("不符合");
			return "false";
		}
	}
	@RequestMapping("/registerSuccess")
	public String registerSuccess(String username,String password,String email){
		Member member=new Member(username,password,email);
		System.out.println(member.getUsername());
		memberservice.insertmember(member);
		return "redirect:/Login.jsp";
	}}
