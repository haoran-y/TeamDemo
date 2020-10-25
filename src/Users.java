import java.util.ArrayList;

public class Users {
	private static Users users;
	private static ArrayList<User> userList = new ArrayList<User>();
	
	private Users() {
		userList = UserLoader.loadUsers();
	}
	
	public static Users getInstance() {
		if(users == null) {
			users = new Users();
		}
		
		return users;
	}

	public static ArrayList<User> getUser() {
		return userList;
	}

	public void addUser(User user) {
		userList.add(user);
	}

	public User check(String username, String password) {
		for (User i : userList) {
			if (i.getName().equals(username)) {
				if (i.getPassword().equals(password)) {
					return i;
				}
			}
		}
		return null;
	}

	public User getUser(String username) {
		for (User i : userList) {
			if (i.getName().equals(username)) {
				return i;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		for (User i : userList) {
			output += i.getName() + "\n";
		}
		return output;
	}
}
