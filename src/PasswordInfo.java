
public class PasswordInfo {
	public boolean match(String password) {
		if (password.length() >= 8 && password.toLowerCase().matches(".*[a-z].*")
				&& password.matches(".*\\d.*")) {
			return true;
		} else {
			System.out.println("Password not valid. Please enter again!");
			return false;
		}
	}
}
