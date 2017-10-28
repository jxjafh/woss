package test_util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author XHX
 *
 */
public class JLGOUtil {
	/**
	 * 图片保存路径
	 */
	public static String pic_save_path = "C:/Users/lips/Desktop/goods";
	/**
	 * 图片虚拟路径
	 */
	public static String virtual_path = "/jiangligo/pic";
	
	
	/**
	 * 自动分配文件名，避免重复
	 * @param fileName
	 * @return newFileName
	 */
	public static String generateFileName(String fileName){
		//时间形式格式化工具
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		//获取当前时间，并格式化
		String formatDate = format.format(new Date());
		//随机生成文件编号
		int random = new Random().nextInt(10000);
		
		//获取文件后缀名
		int position = fileName.lastIndexOf(".");
		//截取文件后缀名
		String extension = fileName.substring(position);
		
		String newFileName = formatDate+"-"+encryption(String.valueOf(random))+extension;
		
		return newFileName;
	}
	
	//双重MD5
	public static String encryption(String str){
		str = DigestUtils.md5DigestAsHex(str.getBytes());
		str = DigestUtils.md5DigestAsHex(str.getBytes());
		return str;
	}
	
	/**
	 * 改变图片大小
	 * @param file
	 * @param savePath
	 * @throws IOException 
	 */
	public static void createSmallPic(MultipartFile file,String savePath,double widthMultiple,double heightMultiple) throws IOException{
		if(file.isEmpty()) return;
//		if(!file.getName().endsWith(".jpg|.png")) return;
		 //读取图片
        BufferedInputStream in = new BufferedInputStream(file.getInputStream());
        //字节流转图片对象
        Image bi =ImageIO.read(in);
        //获取图像的高度，宽度
        int height=bi.getHeight(null);
        int width =bi.getWidth(null);
        //构建图片流
        BufferedImage tag = new BufferedImage((int)(width * widthMultiple), (int)(height * heightMultiple), BufferedImage.TYPE_INT_RGB);
        //绘制改变尺寸后的图
        tag.getGraphics().drawImage(bi, 0, 0,(int)(width * widthMultiple), (int)(height * heightMultiple), null);  
        //输出流
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(savePath));
        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        //encoder.encode(tag);
        ImageIO.write(tag, "PNG",out);
        System.out.println(file.getName());
        in.close();
        out.close();
	}
}










