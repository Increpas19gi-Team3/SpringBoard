package secure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternTest {
	
	
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("'|-|#|=|!");

		Matcher m = p.matcher("1' or '1'='1'--!!!!!");

		if (m.find()) {
			String s = m.replaceAll(""); //모든 일치문자 ""로 치환
			//1' or '1'='1'-- 
			//1 or 11
			System.out.println(s);
		}
		
	}

}
