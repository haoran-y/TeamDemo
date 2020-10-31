/**
 * Account object
 * @author LIMA group
 */
public class Account {

	private String name;
	private boolean isPropertyManager;
	private String password;
	private boolean liveWithOtherUser;

	/**
	 * constructor for setting up an account
	 * @param name
	 * @param password
	 * @param isPropertyManager - if the user is a property manager
	 * @param liveWithOtherUser - if the user want to live with another user
	 */
	public Account(String name, String password, boolean isPropertyManager, boolean liveWithOtherUser) {
		this.name = name;
		this.password = password;
		this.isPropertyManager = isPropertyManager;
		this.liveWithOtherUser = liveWithOtherUser;
	}

	/**
	 * setters and getters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isPropertyManager() {
		return isPropertyManager;
	}

	public void setPropertyManager(boolean propertyManager) {
		isPropertyManager = propertyManager;
	}

	public boolean isLiveWithOtherUser() {
		return liveWithOtherUser;
	}

	public void setLiveWithOtherUser(boolean liveWithOtherUser) {
		this.liveWithOtherUser = liveWithOtherUser;
	}

	public String toString() {
		return "Name: " + name + " Password: " + password + " isPropertuManager" + isPropertyManager;
	}
}
