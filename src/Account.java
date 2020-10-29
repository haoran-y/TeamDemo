public class Account {
	private String name;
	private boolean isPropertyManager;
	private String password;

		public Account(String name, String password, boolean isPropertyManager) {
		this.name = name;
		this.password = password;
		this.isPropertyManager = isPropertyManager;
	}

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

	public String toString() {
		return "Name: " + name + " Password: " + password + " isPropertuManager" + isPropertyManager;
	}
}
