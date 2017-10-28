package test;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test_interface.OrderMapper;
import test_pojo.Order;

public class onetomanytest {

	/**
	 * @param args
	 * @time 2017-3-27 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order order=new Order();
		order.setMember_id(1);
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlsessionFactory=(SqlSessionFactory) ac.getBean("sqlSessionFactory");
	SqlSession session=sqlsessionFactory.openSession();
	OrderMapper o=session.getMapper(OrderMapper.class);
	//o.insert(order);
	//o.delete(1);
	Order order2=o.selectGoods(2);
	System.out.println(order2.getOrderDate());
	System.out.println(order2.getGoods());
	session.commit();
	session.close();
	}

}
