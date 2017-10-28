package jxlg.xyh.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import jxlg.xyh.domain.Ad;

public class testDAO extends HibernateDaoSupport {

//	public void test1(Item item){
//		try {
//			this.getHibernateTemplate().save(item);
//		} catch (RuntimeException e) {
//			throw e;
//		}	
//	}
	
public void addUser(Ad ad){
	try {
		//用getCurrentSession() 要加 @Transactional 并且spring注入接口不能是实体类
		//this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(ad);
		this.getHibernateTemplate().save(ad);
	} catch (RuntimeException e) {
		throw e;
	}
}
//public void test(Registration r){
//	try {
//		this.getHibernateTemplate().save(r);
//	} catch (RuntimeException e) {
//		throw e;
//	}
//}
	@SuppressWarnings("unchecked")
	public Boolean findByname(String username){
		boolean flag=true;
		try {
		String	sql="from jxlg.xyh.domain.Ad  where name='"+username+"'";
			List<Ad> list=(List<Ad>)this.getHibernateTemplate().find(sql);
//			for (Ad ad : list) {
//				System.out.println(ad.getName()+" "+ad.getPassword());
//			}
			if(list.size()==0){
				flag=false;
			}else{
				
			}
			return flag;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	public List<Ad> find(){
		boolean flag=true;
		try {
		String	sql="from jxlg.xyh.domain.Ad";
			@SuppressWarnings("unchecked")
			List<Ad> list=(List<Ad>)this.getHibernateTemplate().find(sql);
//			for (Ad ad : list) {
//				System.out.println(ad.getName()+" "+ad.getPassword());
//			}
			if(list.size()==0){
				flag=false;
			}else{
			}
			return list;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	public long findNumber(){
		try {
		String	sql="select count(*) from Ad";
			@SuppressWarnings("unchecked")
			List<Long> list=this.getHibernateTemplate().find(sql);
            System.out.println(list);
            long Number= list.get(0);
			return Number;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public void Delete(Ad ad ){
		this.getHibernateTemplate().delete(ad);
	}
	public void Update(Ad ad ){
		this.getHibernateTemplate().update(ad);
	}
	public  List<Ad> allPersons(final int pageNumber,final int pageSize){
		@SuppressWarnings("unchecked")
		List<Ad> list = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)  throws HibernateException, SQLException{
				String hql = "from jxlg.xyh.domain.Ad";
				Query query = session.createQuery(hql);
				query.setFirstResult((pageNumber-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Ad> pl = query.list();
				return pl;
			}
		});
		return list;
	}
}
