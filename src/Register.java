
public class Register extends Database{

	private String account;
	private boolean password;
	private Boolean isStudent;
	
	
	
	public String getAccount() {
		return account;
	}
	public boolean getPassword() {
		return password;
	}
	public Boolean getisStudent() {
		return isStudent;
	}
	

	
	
	public void setAccount(String newAccount) {
		this.account = newAccount;
	}
	public void setisStudent(Boolean newisStudent) {
		this.isStudent = newisStudent;
	}
	public void setpassword(boolean newpassword) {
		this.password = newpassword;
	}
	
}
