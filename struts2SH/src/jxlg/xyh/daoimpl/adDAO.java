package jxlg.xyh.daoimpl;

import java.sql.SQLException;
import java.util.List;

import javax.xml.registry.infomodel.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.org.apache.bcel.internal.generic.NEW;

import jxlg.xyh.domain.Ad;

public class adDAO extends BasicDAOimpl {
	//验证
@SuppressWarnings("unchecked")
public boolean check(Ad ad){
	String hql="from jxlg.xyh.domain.Ad where Name=? and Password=?";
	List<Ad> list=(List<Ad>) this.getHibernateTemplate().find(hql,new Object[]{ad.getName(),ad.getPassword()});
	if(list.size()>0){
	return true;}
	else{
		return false;
	}
}
@SuppressWarnings("unchecked")
public Ad findbyid(int id){
	String hql="from jxlg.xyh.domain.Ad where id=?";
	List<Ad> list=(List<Ad>) this.getHibernateTemplate().find(hql,new Object[]{id});
		return list.get(0);
}

@SuppressWarnings("unchecked")
public long findNumber(){
	String sql="select count(*) from Ad";
	 List list=this.getHibernateTemplate().find(sql);
	 	long a= (Long) list.get(0);
	 	//long sum=Long.parseLong(list.get(0).toString());
    System.out.println("adDAO:总页数"+a);
	return a;
}
}
