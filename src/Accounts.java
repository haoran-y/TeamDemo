import java.util.ArrayList;

/**
 * Account management class
 * @author LIMA group
 */
public class Accounts {

	private static Accounts accounts;
	private static ArrayList<Account> accountList = new ArrayList<Account>();

	/**
	 * constructor loading accounts from database
	 */
	private Accounts() {
		accountList = AccountLoader.loadUsers();
	}

	/**
	 * returning the instance of account class
	 * @return - the instance of current class
	 */
	public static Accounts getInstance() {
		if(accounts == null) {
			accounts = new Accounts();
		}
		
		return accounts;
	}

	/**
	 * getter for user list
	 * @return - arraylist of users
	 */
	public static ArrayList<Account> getUser() {
		return accountList;
	}

	/**
	 * add new user to the list
	 * @param account - account object to be added
	 */
	public void addUser(Account account) {
		accountList.add(account);
		AccountWriter.saveUser();
	}

	/**
	 * check if the user is in the registered list and if the password match
	 * @param username - user to be checked
	 * @param password - password to be checked
	 * @return - the user found in the list
	 */
	public Account check(String username, String password) {
		for (Account i : accountList) {
			if (i.getName().equals(username)) {
				if (i.getPassword().equals(password)) {
					return i;
				} else {
					System.out.println("Password wrong!");
					return null;
				}
			}
		}
		System.out.println("Account not found!");
		return null;
	}

	/**
	 * check for repeated username
	 * @param newUserName
	 * @return
	 */
	public boolean checkRepeat(String newUserName) {
		for (Account i : accountList) {
			if (i.getName().equals(newUserName)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String output = "";
		for (Account i : accountList) {
			output += i.getName() + "\n";
		}
		return output;
	}
}
