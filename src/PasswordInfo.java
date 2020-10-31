/**
 * password strength check class
 * @author LIMA group
 */
public class PasswordInfo {

	/**
	 * check for password strength
	 * @param password - password to be checked
	 * @return - if the password is valid
	 */
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
