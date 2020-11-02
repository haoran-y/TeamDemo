import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * main UI class
 * @author LIMA group
 */
public class rentUI {

	private static final String WelcomeMessage = "Welcome to the rent system for off campus housing!";
	private String[] options = {"Login", "Register", "Search House", "Property Management", "Logout"};
	private String[] searchFilter = {"Bedroom number","BathRoom number", "Pet friendly", "Washer and dryer",
			"Furnished", "Walk to campus", "Free wifi", "Swimming pool", "Gym"};
	private Scanner scanner;
	private Accounts accounts;
	private Listings listings;
	private Account account;

	/**
	 * constructor for rentUI
	 */
	rentUI() {
		scanner = new Scanner(System.in);
		accounts = Accounts.getInstance();
		listings = Listings.getInstance();
		account = null;
	}

	/**
	 * run method looping the main interface
	 */
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
					propertyManage();
					break;
				case (5):
					Logout();
					break;
				default:
					System.out.println("Option not available, try again.");
					break;
			}

		}

	}

	/**
	 * displaying main menu
	 */
	private void displayMainMenu() {
		System.out.println(WelcomeMessage);
		System.out.println("\n************ Main Menu *************");
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
		System.out.println("\n");
	}

	/**
	 * getting user input
	 * @param numCommands
	 * @return
	 */
	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");

		//String input = scanner.nextLine();
		//int command = Integer.parseInt(input) - 1;
		int command = scanner.nextInt() - 1;

		if (command >= 0 && command <= numCommands - 1) return command + 1;

		return -1;
	}

	/**
	 * ask for user input of username and password, to match users in database
	 */
	private void Login() {
		scanner.nextLine();
		String userInfo[] = new String[2];
		System.out.println("Enter username: ");
		userInfo[0] = scanner.nextLine();
		//scanner.nextLine();
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

	/**
	 * register a new user
	 */
	private void Register() {
		scanner.nextLine();
		String userInfo[] = new String[3];
		System.out.println("Enter your name:");
		userInfo[0] = scanner.nextLine();
		while (true) {
			if (accounts.checkRepeat(userInfo[0])) {
				break;
			} else {
				System.out.println("Username taken, please enter a new one!");
				userInfo[0] = scanner.nextLine();
			}
		}
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
		boolean liveWithOtherUser = false;
		userInfo[2] = scanner.nextLine();
		if (userInfo[2].toLowerCase().equals("y")) {
			isPropertyManager = true;
		} else {
			isPropertyManager = false;
		}
		System.out.println("Registration complete");
		Account newAccount = new Account(userInfo[0], userInfo[1], isPropertyManager, liveWithOtherUser);
		accounts.addUser(newAccount);
		account = newAccount;
	}

	/**
	 * search for listings
	 */
	private void SearchHouse() {
		int filterSetting[] = new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1};
		upperloop:
		while (true) {
			System.out.println("\n************ Filters *************");
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
					System.out.println("How many washrooms would you like?"); //numbers
					filterSetting[1] = scanner.nextInt();
					break;
				case (3):
					System.out.println("Do you want a pet friendly apartment? (1 for yes and 0 for no)"); //boolean
					filterSetting[2] = scanner.nextInt();
					break;
				case (4):
					System.out.println("Do you need a washer and dryer? (1 for yes and 0 for no)"); //boolean
					filterSetting[3] = scanner.nextInt();
					break;
				case (5):
					System.out.println("Do you need a furnished apartment? (1 for yes and 0 for no)"); //boolean
					filterSetting[4] = scanner.nextInt();
					break;
				case (6):
					System.out.println("Do you prefer walk to campus apartment? (1 for yes and 0 for no)"); //boolean
					filterSetting[5] = scanner.nextInt();
					break;
				case (7):
					System.out.println("Do you need WiFi? (1 for yes and 0 for no)"); //boolean
					filterSetting[6] = scanner.nextInt();
					break;
				case (8):
					System.out.println("Do you need a swimming pool? (1 for yes and 0 for no)"); //boolean
					filterSetting[7] = scanner.nextInt();
					break;
				case (9):
					System.out.println("Do you need gym? (1 for yes and 0 for no)"); //boolean
					filterSetting[8] = scanner.nextInt();
					break;
				case (10):
					break upperloop;
			}

		}
		ShowSearchResult(filterSetting);
	}

	/**
	 * display search result
	 * @param filterSetting
	 */
	private void ShowSearchResult(int[] filterSetting)  {
		ArrayList<Listing> matchedLists = listings.search(filterSetting);
		//matchedLists.add(new Listing("test1", "test address", "29201", 2, 1, 1,1445.90)); //fot test purpose, just ignore it
		int number = 1;
		System.out.println("According to your filter, we have found those apartments");
		for (Listing apartment:matchedLists) {
			System.out.println(number+"  "+apartment.getName());
			number+=1;
		}
		whileloop:
		while (true) {
			System.out.println("Choose the property to show details, 0 to exit.");
			int selection = scanner.nextInt();
			if (selection == 0) {
				break whileloop;
			} else if (selection - 1 >= matchedLists.size()) {
				System.out.println("Please enter a valid number.");
			} else {
				System.out.println(matchedLists.get(selection - 1));
			}
		}
		//System.out.println(matchedLists.get(0)); // for test purpose, just ignore it
		System.out.println("Please pick up the one you would like to sign, 0 to back to main menu");
		int pickedNum = scanner.nextInt();
		if(account == null) {
			System.out.println("You haven't signed in yet, do you want to sign in or register an account?" +
					" (enter 1 to sign in and 0 to register)");
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
		System.out.println("Do you want to live with other website users?(1 for yes and 0 for no)");
		String answer = scanner.nextLine();
		if (answer.equals("1")) {
			account.setLiveWithOtherUser(true);
		}
		if (pickedNum == 0) {
			return;
		}
		try {
			Listings.sign(matchedLists.get(pickedNum - 1), account);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * propertyManage method for managers to add listing
	 */
	private void propertyManage() {
		if (account == null || !account.isPropertyManager()) {
			System.out.println("You are not logged in or you are not a property manager. Back to main menu!");
		} else {
			while (true) {
				System.out.println("\n***** Property Manager *****\n1. add property\n\nenter option:");
				if (scanner.nextInt() == 1) {
					scanner.nextLine();
					System.out.println("Enter the name of the property:");
					String name = scanner.nextLine();
					System.out.println("Enter the address of the property:");
					String address = scanner.nextLine();
					System.out.println("Enter the ZIP code of the property:");
					String ZIP = scanner.nextLine();
					System.out.println("Enter the number of bedrooms for the property:");
					int numBedroom = scanner.nextInt();
					System.out.println("Enter the number of bathrooms for the property:");
					int numBathroom = scanner.nextInt();
					System.out.println("Enter the number of availabilities for the property:");
					int numAvail = scanner.nextInt();
					System.out.println("Enter the price of the property:");
					double price = scanner.nextDouble();
					Listing newListing = new Listing(name, address, ZIP, numBedroom, numBathroom, numAvail, price);
					System.out.println("Is it a walk to campus property? (1 for yes and 0 for no)");
					if(scanner.nextInt() == 1) {
						newListing.setWalkToCampus(true);
					}
					System.out.println("Does it have a washer and dryer? (1 for yes and 0 for no)");
					if(scanner.nextInt() == 1) {
						newListing.setHasWasherDryer(true);
					}
					System.out.println("Does it have a gym? (1 for yes and 0 for no)");
					if(scanner.nextInt() == 1) {
						newListing.setHasGym(true);
					}
					System.out.println("Does it have a pool? (1 for yes and 0 for no)");
					if(scanner.nextInt() == 1) {
						newListing.setHasPool(true);
					}
					System.out.println("Does it have WiFi? (1 for yes and 0 for no)");
					if(scanner.nextInt() == 1) {
						newListing.setHasWifi(true);
					}
					System.out.println("Is it furnished? (1 for yes and 0 for no)");
					if(scanner.nextInt() == 1) {
						newListing.setFurnished(true);
					}
					System.out.println("Is it pet friendly? (1 for yes and 0 for no)");
					if(scanner.nextInt() == 1) {
						newListing.setPetFriendly(true);
					}
					listings.addListing(newListing);
					System.out.println("Listing create successfully!\n");
					System.out.println(newListing + "\n");
					break;
				} else {
					System.out.println("Option not available! try again.");
				}
			}
		}
	}

	/**
	 * logout
	 */
	private void Logout() {
		System.out.println("Bye");
		System.exit(0);
	}

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		rentUI rentUI = new rentUI();
		//rentUI.ShowSearchResult(null); // use for test, you can ignore it
		rentUI.run();

	}

}