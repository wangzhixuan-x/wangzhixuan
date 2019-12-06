package utils;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author wanghd
 */
public class StringUtil {
	
    /**
     * 判断源字符串是否有值
     * @param str
     * @return
     */
	public static boolean isEmpty(String str){
		return str == null || str.trim().length() <=0;
	}
	
	/**
	 * 判断是否为手机号码
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		String regex = "1[3|5|6|7|8]\\d{9}";
		return str.matches(regex);
	}
	
	/**
	 * 判断是否为电子邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		String regex = "\\w+@\\w+(.com|.cn|.cn.com)";
		return str.matches(regex);
	}
	
	/**
	 * 判断是否全部为字母
	 * @param str
	 * @return
	 */
	public static boolean isString(String str){
		String regex = "[a-zA-Z]+";
		return str.matches(regex);
	}
	
	/**
	 * 获取n位随机英文字符串
	 * @param length
	 * @return
	 */
	public static String getString(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(26);
			String word = words[index] + "";
			int bigorsmall = random.nextInt();
			if(bigorsmall % 2 == 0){
				word = word.toLowerCase();
			}
			result.append(word);
		}
		
		return result.toString();
	}
	/**
	 * 获取n位随机英文和数字字符串
	 * @param length
	 * @return
	 */
	public static String getStringAndNumber(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(36);
			String word = words[index] + "";
			if(!StringUtil.isNumber(word)){
				int bigorsmall = random.nextInt();
				if(bigorsmall % 2 == 0){
					word = word.toLowerCase();
				}
			}
			result.append(word);
		}
		
		return result.toString();
	}
	//获取n个随机中文字符串

	/**
	 * 是否是纯数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		boolean blank = StringUtil.isEmpty(str);
		if(blank){
			Pattern pattern = Pattern.compile("^\\d*$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	
	/**
	 * 获取n个随机中文字符串
	 * @return
	 */
	public static String getAChinese() {
        StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0; 
        Random random = new Random();
        for(int i = 0 ; i < 100 ; i++){
	        hs = (176 + Math.abs(random.nextInt(39))); 
	        ls = (161 + Math.abs(random.nextInt(93)));
	        byte[] b = new byte[2];
	        b[0] = (new Integer(hs).byteValue());
	        b[1] = (new Integer(ls).byteValue());
	        try {
	          str.append(new String(b, "GBk")); 
	        } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	        }
        }
        return str.toString();
  }
	
	public static void main(String[] args) {
		System.out.println(getAChinese());
		
	}
	
}
