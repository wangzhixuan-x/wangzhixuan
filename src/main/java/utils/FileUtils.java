package utils;

import java.io.File;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class FileUtils {
	/***
	 * 获取文件扩展名 后缀名
	 * @return
	 * D:/test/test.txt
	 */
	public static String getSuffixName(String path) {
		File file = new File(path);
		boolean file2 = file.isFile();
		if(file2) {
			int indexOf = path.indexOf(".");
			String substring = path.substring(indexOf,path.length());
			return substring;
		}else {
			return "该路径不对或者不是普通文件";
		}
	}
	/***
	 * 删除文件，如果是目录，则下面的文件和所有子目录中的文件都要删除
	 */
	public static void deleteFiles(String path) {
		File file = new File(path);
		if(file.isFile()) {
			file.delete();
		}else if(file.isDirectory()){
			//获取目录下的所有文件 包括目录
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				String path2 = file2.getPath();
				//d递归删除文件
				deleteFiles(path2);
			}
		}
		//删除空文件夹
		file.delete();
	}

	/***
	 * 获取操作系统用户目录
	 */
	public static String getHomeDirectory() {
		String property = System.getProperty("user.home");
		return property;
	}
	public static String getWorkDirectory() {
		String property = System.getProperty("user.dir");
		return property;
	}

	public static String getFileSize(String path,String unit) {
		File file = new File(path);
		long leng = file.length();
		double length = leng;
		double size = 0;

		switch (unit) {
		case "K":
			size = length/1024;
			break;
		case "M":
			size = length/1024/1024;
			break;
		case "G":
			size = length/1024/1024/1024;
			break;
		default:
			size = length;
			break;
		}
		NumberFormat data=NumberFormat.getNumberInstance();
		//保留两位小数
		data.setMaximumFractionDigits(4);
		// 如果不需要四舍五入，可以使用RoundingMode.DOWN
		data.setRoundingMode(RoundingMode.UP);

		String format = data.format(size);
		return format + unit;
	}

}
