import java.util.ArrayList;

public class Accounts {
	private static Accounts accounts;
	private static ArrayList<Account> accountList = new ArrayList<Account>();
	
	private Accounts() {
		accountList = AccountLoader.loadUsers();
	}
	
	public static Accounts getInstance() {
		if(accounts == null) {
			accounts = new Accounts();
		}
		
		return accounts;
	}

	public static ArrayList<Account> getUser() {
		return accountList;
	}

	public void addUser(Account account) {
		accountList.add(account);
		AccountWriter.saveUser();
	}

	public Account check(String username, String password) {
		for (Account i : accountList) {
			if (i.getName().equals(username)) {
				if (i.getPassword().equals(password)) {
					return i;
				}
			}
		}
		return null;
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
