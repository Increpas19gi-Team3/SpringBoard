package secure;

public class XSSFilterUtil {
	
	// 글내용의 태그기호를 필터링하는 메소드
	 public static String doFilter(String content) {
	  String new_content=null;
	//모든 <> 를 태그 X 부등호호 변환
	  content = content.replaceAll("<", "&lt;");
	  content = content.replaceAll(">", "&gt;");
	
	  //<p> , <br> 허용(화이트리스트)
	  content = content.replaceAll("&lt;p&gt;", "<p>");
	  content = content.replaceAll("&lt;P&gt;", "<P>");
	  content = content.replaceAll("&lt;br&gt;", "<br>");
	  content = content.replaceAll("&lt;BR&gt;", "<BR>");
	  
	  new_content =content;	  
	  return new_content;	  
	  
	 }
}
