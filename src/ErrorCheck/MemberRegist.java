package ErrorCheck;

public class MemberRegist {
	private String name;
	private String mail;
	private String pass;
	private String address;
	private String telnumber;
	private String card;

	private String errorName;
	private String errorMail;
	private String errorPass;
	private String errorAddress;
	private String errorTelnumber;
	private String errorCard;

	public MemberRegist(){
		this.name = "";
		this.mail = "";
		this.pass = "";
		this.address = "";
		this.telnumber = "";
		this.card = "";
		this.errorName = "";
		this.errorMail = "";
		this.errorPass = "";
		this.errorAddress = "";
		this.errorTelnumber = "";
		this.errorCard = "";
	}
	public void setName(String val){
		if(val.equals("")){
			this.errorName = "氏名が未入力です。";
		}else if(!ErrorCheck.isLength(1, 15, val)){
			this.errorName = "1から15文字の間で入力してください。";
		}
		this.name = val;
	}
	public void setMail(String val){
		if(val.equals("")){
			this.errorMail = "メールが未入力です。";
		}else if(!ErrorCheck.isMail(val)){
			this.errorMail = "正しいメールアドレスを入力してください。";
		}
		this.mail = val;
	}
	public void setPass(String val){
		if(val.equals("")){
			this.errorPass = "パスワードが未入力です。";
		}else if(!ErrorCheck.isLength(4,10,val)){
			this.errorPass = "4から10文字の間で入力してください。";
		}
		this.pass = val;
	}
	public void setAddress(String val){
		if(val.equals("")){
			this.errorAddress = "住所が未入力です。";
		}else if(!ErrorCheck.isLength(1, 100, val)){
			this.errorAddress = "100文字以内で入力してください。";
		}
		this.address = val;
	}
	public void setTelnumber(String val){
		if(val.equals("")){
			this.errorTelnumber = "電話番号が未入力です。";
		}else if(!ErrorCheck.isNumeric(val)){
			this.errorTelnumber = "数字を入力してください。";
		}else if(!ErrorCheck.isLength(10, 15, val)){
			this.errorTelnumber = "10から15桁の間で入力してください。";
		}
		this.telnumber = val;
	}
	public void setCard(String val){
		if(val.equals("")){
			this.errorCard = "カード番号が未入力です。";
		}else if(!ErrorCheck.isNumeric(val)){
			this.errorCard = "数字を入力してください。";
		}else if(!ErrorCheck.isLength(10, 20, val)){
			this.errorCard = "10から20桁の間で入力してください。";
		}
		this.card = val;
	}

	public String getName(){
			return this.name;
	}
	public String getMail(){
		return this.mail;
	}
	public String getPass(){
		return this.pass;
	}
	public String getAdoress(){
		return this.address;
	}
	public String getTelnumber(){
		return this.telnumber;
	}
	public String getCard(){
		return this.card;
	}
	public String errorName(){
		return this.errorName;
	}
	public String errorMail(){
		return this.errorMail;
	}
	public String errorPass(){
		return this.errorPass;
	}
	public String errorAdoress(){
		return this.errorAddress;
	}

	public String errorTelnumber(){
		return this.errorTelnumber;
	}

	public String errorCard(){
		return this.errorCard;
	}
}
