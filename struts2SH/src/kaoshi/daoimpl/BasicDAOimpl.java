package kaoshi.daoimpl;

import java.sql.SQLException;
import java.util.List;

import jxlg.xyh.domain.Ad;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import kaoshi.dao.BasicDAO;

public class BasicDAOimpl extends HibernateDaoSupport implements BasicDAO{

	public void create(Object o) {
		// TODO Auto-generated method stub
       this.getHibernateTemplate().save(o);
	}

	public void update(Object o) {
		// TODO Auto-generated method stub
this.getHibernateTemplate().update(o);
	}

	public void delete(Object o) {
		// TODO Auto-generated method stub
this.getHibernateTemplate().delete(o);
	}

	public List findByid(Integer id,String hql) {
		// TODO Auto-generated method stub
return this.getHibernateTemplate().find(hql, id);
	}

	//��ҳ
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

public List findAll(String sql) {
	// TODO Auto-generated method stub
	return this.getHibernateTemplate().find(sql);
}
//��������
public List load(Class clazz){
	return this.getHibernateTemplate().loadAll(clazz);
}
public Object load(Class class1,Integer id){
	return this.getHibernateTemplate().load(class1, id);
}
public List findByAtt(String sql, Object[] parameters) {
	// TODO Auto-generated method stub
	return this.getHibernateTemplate().find(sql, parameters);
}

public List findAll(Object o) {
	// TODO Auto-generated method stub
	return null;
}


}
