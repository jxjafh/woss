package jxlg.xyh.daoimpl;

import jxlg.xyh.domain.Item;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class itemDAO extends BasicDAOimpl{
	
public void insert(Item item){
	try {
		this.getHibernateTemplate().save(item);
	} catch (RuntimeException e) {
		throw e;
	}
}

}
