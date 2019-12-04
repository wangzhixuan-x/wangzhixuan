package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

public class StringUtil {
    //判断字符串是否为空
	public static boolean isEmpty(String str){
		return str == null || str.trim().length()<=0;		
	}
	//判断是否为手机号
	public static boolean isphone(String phone) {
		boolean b = phone.matches("1[3|5|6|7|8]\\d{9}");
		return b;		
	}
	//判断是否邮箱
	public static boolean isEmail(String str) {
		boolean b = str.matches("\\w+@\\w+(.com|.cn|.cn.com)");
		return b;		
	}
	//判断是否全是字母
	public static boolean isString(String str) {
		boolean b = str.matches("[a-zA-Z]+");
		return b;		
	}
	//日期字符串转换成date类型
	public static Date Stringtodate(String str) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-Mm-dd");		
		return sdf.parse(str);
				
	}
	//date转换成calender类型
	public static Calendar datetocalendae(Date date) throws ParseException {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance;
	}
	public static void main(String[] args) {		
		/*System.out.println(isEmpty(" "));*/
		/*System.out.println(isphone("13315945844"));*/
		
	}
	
}
