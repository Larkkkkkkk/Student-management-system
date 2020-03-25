package util;

public class TextUtil {

	//用于判断查询时候有没有选择查询条件
	public static boolean isEmpty(CharSequence s) {  //字符串的实现类 也可以写String
		return s==null ||s.length()==0;		
	}
}
