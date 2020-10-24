
public class PasswordInfo implements Password{
	public void PasswordNeeds() {
		System.out.println("Your password must have a minimum of 8 characters\n"
                + "Your password must contain at least one letter and one digit: ");	
		
	}

	public int length() {
		
		
		return 0;
	}

	public boolean matches(String string) {
		
		
		return false;
	}
}
