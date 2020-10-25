import java.util.Scanner;

public class rentUI {

	private static final String WelcomeMessage = "Welcome to the rent system for off campus housing!";
	private String[] options = {"Login", "Register", "Search House", "Logout"};
	private String[] searchFilter = {"bedroom number", "pet friendly", "washer and dryer",
			"furnished", "walk to campus", "free wifi", "swimming pool", "finished filting"};
	private Scanner scanner;
	private Users users;
	private Listings listings;
	private User user;

	rentUI() {
		scanner = new Scanner(System.in);
		users = Users.getInstance();
		listings = Listings.getInstance();
		user = null;
	}

	public void run() {

		while (true) {

			displayMainMenu();
			int userCommand = getUserCommand(options.length);
			if (userCommand == options.length) break;

			switch (userCommand) {
				case (1):
					Login();
					break;
				case (2):
					Register();
					break;
				case (3):
					SearchHouse();
					break;
				case (4):
					Logout();
					break;
			}

		}

	}

	private void displayMainMenu() {
		System.out.println(WelcomeMessage);
		System.out.println("\n************ Main Menu *************");
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
		System.out.println("\n");
	}

	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");

		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;

		if (command >= 0 && command <= numCommands - 1) return command + 1;

		return -1;
	}

	private void Login() {
		String userInfo[] = new String[1];
		System.out.println("Enter username: ");
		userInfo[0] = scanner.nextLine();
		System.out.println("Enter password: ");
		userInfo[1] = scanner.nextLine();
		User temp = users.check(userInfo[0], userInfo[1]);
		if (temp != null) {
			user = temp;
			System.out.println("Login success!");
		} else {
			System.out.println("Login failed, back to main menu!");
		}
	}


	private void Register() {
		String userInfo[] = new String[3];
		System.out.println("Enter your name");
		userInfo[0] = scanner.nextLine();
		System.out.println("Enter password: ");
		System.out.println("Your password must have a minimum of 8 characters\n"
				+ "Your password must contain at least one letter and one digit: ");
		String password;
		while (true) {
			PasswordInfo myPasswordInfo = new PasswordInfo();
			password = scanner.nextLine();
			if (myPasswordInfo.match(password)) {
				break;
			}
		}
		System.out.println("Success!");
		userInfo[1] = password;
		System.out.println("are you a property manager?(y for yes and n for no)");
		boolean isPropertyManager;
		if (userInfo[2].toLowerCase().equals("y"))
			isPropertyManager = true;
		else
			isPropertyManager = false;
		System.out.println("Registration complete");
		User newUser = new User(userInfo[0], userInfo[1], isPropertyManager);
		users.addUser(newUser);
		user = newUser;

	}

	private void SearchHouse() {
		int filterSetting[] = new int[searchFilter.length];
		while (true) {
			if (filterSetting[7] == 1)
				break;
			System.out.println("\n************Filters *************");
			for (int i = 0; i < searchFilter.length; i++) {
				System.out.println((i + 1) + ". " + searchFilter[i]);
			}
			int userCommand = scanner.nextInt();
			switch (userCommand) {
				case (1):
					System.out.println("How many bedrooms would you like?");
					filterSetting[0] = scanner.nextInt();
					break;
				case (2):
					System.out.println("Do you want your apartment pet friendly?(1 for yes and 0 for no)");
					filterSetting[1] = scanner.nextInt();
					break;
				case (3):
					System.out.println("Do you need washer and dryer?");
					filterSetting[2] = scanner.nextInt();
					break;
				case (4):
					System.out.println("Do you need your apartment furnished?");
					filterSetting[3] = scanner.nextInt();
					break;
				case (5):
					System.out.println("Do you prefer walk to campus apartment?");
					filterSetting[4] = scanner.nextInt();
					break;
				case (6):
					System.out.println("Do you need free wifi?");
					filterSetting[5] = scanner.nextInt();
					break;
				case (7):
					System.out.println("Do you need swimming pool?");
					filterSetting[6] = scanner.nextInt();
					break;
				case (8):
					filterSetting[7] = 1;
					break;
			}
		}
// use filterSetting for searching

	}

	private void Logout() {
		System.out.println("Bye");
		System.exit(0);
	}

	public static void main(String[] args) {
		rentUI rentUI = new rentUI();
		rentUI.run();

	}

}