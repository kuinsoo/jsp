package kr.or.ddit.util;

public class StringUtil {

	public static String getFileNameFormHeader(String contentDisposition){

		String fileName =" ";

		String[] split = contentDisposition.split(";");

		for(String str : split){
			if(str.indexOf("filename=") >= 0){
				//str.lastIndexOf("\"") -> 20글자 나옴 
				fileName = str.substring(11,str.lastIndexOf("\""));
			}
		}
		return fileName;
	}


	public static String getCookie(String cookieString, String cookieName) {
		//remember=Y; userId=brown; etc=test
		String[] cookies = cookieString.split("; ");
		//cookies[0] : remember=Y
		//cookies[1] : userId = brown
		//cookies[2] : etc= test
		
		String cookieValue = "";
		for(String str : cookies){
			// remember =
			if(str.startsWith(cookieName + "=")){
				cookieValue = str.substring((cookieName + "=").length());
			}
		}
		return cookieValue;


	}

}
