package jxlg.xyh.daoimpl;

import java.sql.SQLException;
import java.util.List;

import jxlg.xyh.dao.BasicDAO;
import jxlg.xyh.domain.Ad;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BasicDAOimpl extends HibernateDaoSupport implements BasicDAO{

	public void save(Object obj) {
		// TODO Auto-generated method stub
	this.getHibernateTemplate().save(obj);	
	}

	public void delete(Object obj) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(obj);
	}

	public void Update(Object obj) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(obj);
	}

	@SuppressWarnings("unchecked")
	public List findByid(String sql, Object[] parameters) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(sql, parameters);
	}

	public void delete(String sql, Object[] parameters) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(sql, parameters);
	}

	public void Update(String sql, Object[] parameters) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(sql, parameters);
	}

	@SuppressWarnings("unchecked")
	public List find(String sql, Object[] parameters) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(sql, parameters);
	}
//·ÖÒ³
	public List all(final int pageNumber, final int pageSize, final String sql) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Object> list = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)  throws HibernateException, SQLException{
				Query query = session.createQuery(sql);
				query.setFirstResult((pageNumber-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Ad> pl = query.list();
				return pl;
			}
		});
		return list;
	}	
	}
	

