package ErrorCheck;

public class ErrorCheck {
	static String mailFormat= "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";

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
		if(str3.matches(mailFormat)){
			return true;
		}else{
			return false;
		}
	}
}
