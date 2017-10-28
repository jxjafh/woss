package test;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test_pojo.Admin;




public class mybatistest {

	/**
	 * @param args
	 * @time 2017-3-26 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
		admin.setId(15);
		admin.setName("1");
		admin.setPassword("1");
		/**
		 * @param args
		 * @time 2017-3-26
		 * mybatis单测 
		 */
//try {
//	 String source="Mybatis.xml";
//	 InputStream 	inputStream = Resources.getResourceAsStream(source);
//	 SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//	 SqlSession session=sqlSessionFactory.openSession();
//	 UserMapper u=session.getMapper(UserMapper.class);
//     System.out.println(u.insert(user));
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//	}
/**
 * mybatis + spring
	*/	
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlsessionFactory=(SqlSessionFactory) ac.getBean("sqlSessionFactory");
	SqlSession session=sqlsessionFactory.openSession();
//	UserMapper u=session.getMapper(UserMapper.class);
	System.out.println("1");
//u.insert(user);
	}
}