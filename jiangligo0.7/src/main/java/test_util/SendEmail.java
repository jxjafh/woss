package test_util;
import java.util.Properties;
import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
public class SendEmail {  
  
    private JavaMailSenderImpl email;  
      
    private SimpleMailMessage message;  
      
    public SendEmail() {  
        // TODO Auto-generated constructor stub  
        email = new JavaMailSenderImpl();  
        email.setHost("smtp.163.com");  
        email.setUsername("jlgo2017@163.com");  
        email.setPassword("abc2017");  
        email.setPort(465);  
        Properties properties = new Properties();  
        properties.put("mail.smtp.auth", true);  
        properties.put("mail.smtp.ssl.enable", true);  
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
        properties.put("mail.smtp.timeout", 25000);  
        email.setJavaMailProperties(properties);  
    }  
      
    //
    public String send(String mail){  
    	Random random=new Random();
    	String sum="";
    	for(int i=0;i<6;i++)
    	{
    		int j=random.nextInt(10);
    		sum+=""+j;
    	}
    	String fin=MD5Encoder.md5(sum);
    	System.out.println("***  "+sum+" "+fin);
        message = new SimpleMailMessage();  
        message.setFrom("jlgo2017@163.com");  
        message.setTo(""+mail+"");
        System.out.println(""+mail+"");
        message.setSubject("欢迎注册江鲤购！");  
        message.setText("您的验证码为:   "+sum+"");
        email.send(message);  
        return sum;
    }  

	public static void main(String[] args) {
    	SendEmail sendEmail=new SendEmail();
    	sendEmail.send("861785837@qq.com");
	}
} 
