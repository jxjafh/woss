package jxlg.xyh.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.jgroups.tests.adaptjms.Request;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import jxlg.xyh.daoimpl.adDAO;
import jxlg.xyh.domain.Ad;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

public class adaction extends ActionSupport {
	private Integer id;
	private String Name;
	private String Password;
	private adDAO adDAO;

	public adaction() {

	}

	public adaction(Integer id, String Name, String Password) {
		this.id = id;
		this.Name = Name;
		this.Password = Password;
	}

	public adDAO getAdDAO() {
		return adDAO;
	}

	public void setAdDAO(adDAO adDAO) {
		this.adDAO = adDAO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	// public void validate(){
	// if(Name==null||Name.length()<6)
	// {
	// addFieldError("name","�û�������Ϊ��");
	// }
	// if(Password==null){
	// addFieldError("password","���벻��Ϊ��");
	// }
	// }
	public String paging() {
		//System.out.println("paging");
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		long pageSum = adDAO.findNumber();
		request.setAttribute("pageSum", pageSum);
		request.setAttribute("list", adDAO.all(pageNumber, 2, "from Ad"));
		//System.out.println("paging����" + pageSum + "" + pageNumber);
		return "paging";
	}

	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int ID = Integer.parseInt(request.getParameter("id"));
		Object[] parameters ={ID};
		System.out.println(parameters);
		adDAO.delete(adDAO.findbyid(ID));
		return "desuccess";
	}

	public String login() {
		Ad ad = new Ad();
		ad.setName(Name);
		ad.setPassword(Password);
		Boolean bool = adDAO.check(ad);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("name", Name);
		if (bool) {
			return "login";
		} else {
			return "input";
		}
	}

	public String execute() {
		Ad ad = new Ad();
		ad.setId(2);
		ad.setName(Name);
		ad.setPassword(Password);
		//System.out.println("execute����" + Name + Password);
		// adDAO.Update(ad);
		// adDAO.Delete(ad);
		// List<Ad> list= adDAO.allPersons(2, 1);
		// for (Ad ad2 : list) {
		// String Name=ad2.getName();
		// String Password= ad2.getPassword();
		// System.out.println(Name+"\t"+Password+" ");
		// }
		// ServletActionContext.getRequest().setAttribute("list", list);
		// Ĭ�Ϸ�װ���
		// Hibernate: update Administrator set name=?, password=? where id=?
		// Hibernate: delete from Administrator where id=?
		// boolean flag=adDAO.findByname(Name);
		// Item item=new Item("11","11","11","11","11","11");
		// adDAO.test1(item);
		// Registration registration=new Registration(item,"11", 11,1, "11",
		// "11", "11", "11", "11", "11", 1.11);
		// adDAO.test(registration);
		return "SUCCESS";
	}
}
