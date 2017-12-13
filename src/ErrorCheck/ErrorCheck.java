package ErrorCheck;

public class ErrorCheck {

	public static boolean isNumeric(String str){
		for(int i = 0;i<str.length();i++){
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}return true;
	}
	public static boolean isLength(int min,int max,String str2){
		if(min <= str2.length() && str2.length() < max){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isMail(String str3){
		if(str3.contains("%@%.%")){
			return true;
		}else{
			return false;
		}
	}
}
