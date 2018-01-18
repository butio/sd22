package ErrorCheck;

public class MemberRegist {
	private String name;
	private String mail;
	private String pass;
	private String address;
	private String telnumber;
	private String card;
	private String contact;

	private String errorName;
	private String errorMail;
	private String errorPass;
	private String errorAddress;
	private String errorTelnumber;
	private String errorCard;
	private String errorContact;

	boolean errFlg;

	public MemberRegist(){
		this.name = "";
		this.mail = "";
		this.pass = "";
		this.address = "";
		this.telnumber = "";
		this.card = "";
		this.contact = "";
		this.errorName = "";
		this.errorMail = "";
		this.errorPass = "";
		this.errorAddress = "";
		this.errorTelnumber = "";
		this.errorCard = "";
		this.errorContact = "";
	}
	public void setName(String val){
		if(val.equals("")){
			this.errorName = "氏名が未入力です。";
			this.errFlg = true;
		}else if(!ErrorCheck.isLength(1, 15, val)){
			this.errorName = "1から15文字の間で入力してください。";
			this.errFlg = true;
		}
		this.name = val;
	}
	public void setMail(String val){
		if(val.equals("")){
			this.errorMail = "メールが未入力です。";
			this.errFlg = true;
		}else if(!ErrorCheck.isMail(val)){
			this.errorMail = "正しいメールアドレスを入力してください。";
			this.errFlg = true;
		}
		this.mail = val;
	}
	public void setPass(String val){
		if(val.equals("")){
			this.errorPass = "パスワードが未入力です。";
			this.errFlg = true;
		}else if(!ErrorCheck.isLength(4,10,val)){
			this.errorPass = "4から10文字の間で入力してください。";
			this.errFlg = true;
		}
		this.pass = val;
	}
	public void setAddress(String val){
		if(val.equals("")){
			this.errorAddress = "住所が未入力です。";
			this.errFlg = true;
		}else if(!ErrorCheck.isLength(1, 100, val)){
			this.errorAddress = "100文字以内で入力してください。";
			this.errFlg = true;
		}
		this.address = val;
	}
	public void setTelnumber(String val){
		if(val.equals("")){
			this.errorTelnumber = "電話番号が未入力です。";
			this.errFlg = true;
		}else if(!ErrorCheck.isNumeric(val)){
			this.errorTelnumber = "数字を入力してください。";
			this.errFlg = true;
		}else if(!ErrorCheck.isLength(10, 15, val)){
			this.errorTelnumber = "10から15桁の間で入力してください。";
			this.errFlg = true;
		}
		this.telnumber = val;
	}
	public void setCard(String val){
		if(val.equals("")){
			this.errorCard = "カード番号が未入力です。";
			this.errFlg = true;
		}else if(!ErrorCheck.isNumeric(val)){
			this.errorCard = "数字を入力してください。";
			this.errFlg = true;
		}else if(!ErrorCheck.isLength(10, 20, val)){
			this.errorCard = "10から20桁の間で入力してください。";
			this.errFlg = true;
		}
		this.card = val;
	}
	public void setContact(String val){
		if(val.equals("")){
			this.errorContact = "お問合せ内容が未入力です。";
			this.errFlg = true;
		}
		this.contact = val;
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
	public String getContact(){
		return this.contact;
	}
	
	//エラー
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
	public String errorContact(){
		return this.errorContact;
	}
	public boolean getJsp(){
		return this.errFlg;
	}
}
