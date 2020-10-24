import java.util.ArrayList;

public class Database {
//database should read json file and load users and apartmenrs information

	
	
	//I just added this to match our UML
	
	
	
	private String checkAccount;
	private boolean Password;
	private String registerAccount;
	private String addHouse;
	private String removeHouse;

	
	
	public String getCheckAccount() {
		return checkAccount;
	}
	public boolean getPassword() {
		return Password;
	}
	public String getRegisterAccount() {
		return registerAccount;
	}
	public String getAddHouse() {
		return addHouse;
	}
	public String getRemoveHouse() {
		return removeHouse;
	}

	
	
	public void setCheckAccount(String newCheckAccount) {
		this.checkAccount = newCheckAccount;
	}
	public void setPassword(boolean newPassword) {
		this.Password = newPassword;
	}
	public void setRegisterAccount(String newRegisterAccount) {
		this.checkAccount = newRegisterAccount;
	}
	public void setAddHouse(String neAaddHouse) {
		this.addHouse = getAddHouse();
	}
	public void setRemoveHouse(String newRemoveHouse) {
		this.removeHouse = newRemoveHouse;
	}


}