package test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.domain.*;
import jxlg.xyh.daoimpl.adDAO;
import jxlg.xyh.domain.Ad;
import kaoshi.dao.ExamDAO;
import kaoshi.dao.QuestionDAO;
import kaoshi.dao.QuestionItemDAO;
import kaoshi.daoimpl.ExamDAOimpl;
import kaoshi.daoimpl.QuestionDAOimpl;
import kaoshi.daoimpl.QuestionItemDAOimpl;

public class test {

	/**
	 * @param args
	 */
	 @SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //二级缓存检测
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		 ExamDAOimpl examDAOimpl=(ExamDAOimpl) ac.getBean("examDAOimpl");
//		 QuestionDAOimpl questionDAOimpl=(QuestionDAOimpl) ac.getBean("questionDAOimpl");
//		 QuestionItemDAOimpl questionItemDAOimpl=(QuestionItemDAOimpl) ac.getBean("questionItemDAOimpl");
SessionFactory sessionFactory=(SessionFactory) ac.getBean("sessionFactory");
		 Exam exam=new Exam();
 Question question=new Question();
 @SuppressWarnings("unused")
//QuestionItem questionItem=new  QuestionItem();
 Session session=sessionFactory.openSession();
 Transaction transaction=session.beginTransaction();
Question question2= (Question) session.load(question.getClass(), 1);
System.out.println(question2.getName());
transaction.commit();
session.close();
System.out.println("-----------");
Session session1=sessionFactory.openSession();
Transaction transaction1=session1.beginTransaction();
Question question3= (Question) session1.load(question.getClass(), 1);
System.out.println(question2.getName());
transaction1.commit();
session1.close();
//List<Question> list=questionDAOimpl.findAll("from Question");
//=System.out.println(list);
//
//System.out.println("---------------");
//System.out.println(list.get(1).getExam().getId());
//System.out.println(list.get(2).getExam().getId());
	 }

}
