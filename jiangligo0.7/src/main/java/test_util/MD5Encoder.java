package test_util;
/**
 * 描绘：MD5+BASE64算法
 * 作用：对后台数据库的密码进行加密
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class MD5Encoder {
      public static String md5(String message){
    	 try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("加密出错");
		}
      }


}
