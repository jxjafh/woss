package jxlg.xyh.daoimpl;

import jxlg.xyh.domain.Registration;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class registrationDAO extends HibernateDaoSupport{

 public void insert(Registration reg){
	 this.getHibernateTemplate().save(reg);
	}

}
