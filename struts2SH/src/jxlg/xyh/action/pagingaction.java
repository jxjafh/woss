package jxlg.xyh.action;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import freemarker.template.utility.Execute;

public class pagingaction extends HibernateDaoSupport {
public String execute(){
	System.out.println("1");
	return "paging";
}
}
