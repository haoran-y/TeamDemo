import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class rentUI {

	private static final String WelcomeMessage = "Welcome to the rent system for off campus housing!";
	private String[] options = {"Login", "Register", "Search House", "Logout"};
	private String[] searchFilter = {"bedroom number","WashRoom number", "pet friendly", "washer and dryer",
			"furnished", "walk to campus", "free wifi", "swimming pool", "gym"};
	private Scanner scanner;
	private Accounts accounts;
	private Listings listings;
	private Account account;

	rentUI() {
		scanner = new Scanner(System.in);
		accounts = accounts.getInstance();
		listings = Listings.getInstance();
		account = null;
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
		scanner.nextLine();
		String userInfo[] = new String[2];
		System.out.println("Enter username: ");
		userInfo[0] = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter password: ");
		userInfo[1] = scanner.nextLine();
		Account temp = accounts.check(userInfo[0], userInfo[1]);
		if (temp != null) {
			account = temp;
			System.out.println("Login success!");
		} else {
			System.out.println("Login failed, back to main menu!");
		}
	}


	private void Register() {
		scanner.nextLine();
		String userInfo[] = new String[3];
		System.out.println("Enter your name:");
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
		userInfo[1] = password;
		System.out.println("are you a property manager?(y for yes and n for no)");
		boolean isPropertyManager;
		userInfo[2] = scanner.nextLine();
		if (userInfo[2].toLowerCase().equals("y"))
			isPropertyManager = true;
		else
			isPropertyManager = false;
		System.out.println("Registration complete");
		Account newAccount = new Account(userInfo[0], userInfo[1], isPropertyManager);
		accounts.addUser(newAccount);
		account = newAccount;
	}

	private void SearchHouse() {
		int filterSetting[] = new int[searchFilter.length];
		upperloop:
		while (true) {
			System.out.println("\n************Filters *************");
			for (int i = 0; i < searchFilter.length; i++) {
				System.out.println((i + 1) + ". " + searchFilter[i]);
			}
			System.out.println("10. Finish filter");
			int userCommand = scanner.nextInt();
			switch (userCommand) {
				case (1):
					System.out.println("How many bedrooms would you like?"); //numbers
					filterSetting[0] = scanner.nextInt();
					break;
				case (2):
					System.out.println("How many washrooms would you like"); //numbers
					filterSetting[1] = scanner.nextInt();
					break;
				case (3):
					System.out.println("Do you want your apartment pet friendly?(1 for yes and 0 for no)"); //boolean
					filterSetting[2] = scanner.nextInt();
					break;
				case (4):
					System.out.println("Do you need washer and dryer?"); //boolean
					filterSetting[3] = scanner.nextInt();
					break;
				case (5):
					System.out.println("Do you need your apartment furnished?"); //boolean
					filterSetting[4] = scanner.nextInt();
					break;
				case (6):
					System.out.println("Do you prefer walk to campus apartment?"); //boolean
					filterSetting[5] = scanner.nextInt();
					break;
				case (7):
					System.out.println("Do you need free wifi?"); //boolean
					filterSetting[6] = scanner.nextInt();
					break;
				case (8):
					System.out.println("Do you need swimming pool?"); //boolean
					filterSetting[7] = scanner.nextInt();
					break;
				case (9):
					System.out.println("Do you need gym?"); //boolean
					filterSetting[8] = scanner.nextInt();
					break;
				case (10):
					break upperloop;
			}

		}
		ShowSearchResult(filterSetting);
	}
	private void ShowSearchResult(int[] filterSetting)  {
		ArrayList<Listing> matchedLists = new ArrayList<Listing>();
		//matchedLists.add(new Listing("test1", "test address", "29201", 2, 1, 1,1445.90)); //fot test purpose, just ignore it
		int i = 1;
		System.out.println("According to your filter, we have found those apartments");
		for (Listing apartment:listings.search(filterSetting)) {
			System.out.println(i+"  "+apartment);
			matchedLists.add(apartment);
			i+=1;
		}
		//System.out.println(matchedLists.get(0)); // for test purpose, just ignore it
		System.out.println("Please pick up the one you would like to sign");
		int pickedNum = scanner.nextInt();
		if(account == null) {
			System.out.println("You haven't sign in yet, do you want to sign in or register an account?" +
					"(press 1 to sign in and 0 to register)");
			int opCode = scanner.nextInt();
			switch (opCode){
				case 0:
					Register();
					break;
				case 1:
					Login();
					break;
			}
		}
			try {
				Listings.sign(matchedLists.get(pickedNum - 1), account);
			} catch (IOException e) {
				System.out.println(e);
			}
	}
	private void Logout() {
		System.out.println("Bye");
		System.exit(0);
	}

	public static void main(String[] args) {
		rentUI rentUI = new rentUI();
		//rentUI.ShowSearchResult(null); // use for test, you can ignore it
		rentUI.run();

	}

}