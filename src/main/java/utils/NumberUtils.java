package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
	
	/*
	* 百分比计算方法，返回值只要整数不需要小数。
	* 给一个当前数，和一个总数，计算当前数百分占比，例如参数为5和10，方法内部
	* 5除以10得0.5，再乘以100，返回50，注意四舍五入。页面就可以显示50%
	*/
	
	public static int getPercent(int sum, int num){
		BigDecimal b1 = BigDecimal.valueOf(sum);
		BigDecimal b2 = BigDecimal.valueOf(num);
		BigDecimal result = b2.divide(b1,5,RoundingMode.HALF_UP);
		return result.multiply(BigDecimal.valueOf(100)).intValue();
	}
}
