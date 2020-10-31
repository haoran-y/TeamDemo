import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * listings management class
 * @author LIMA group
 */
public class Listings{

	private static Listings listings;
    private static ArrayList<Listing> listingList = new ArrayList<Listing>();

	/**
	 * constructor, read listings from json
	 */
	private Listings() {
    	listingList = ListingLoader.loadListings();
    }

	/**
	 * get the current listings
	 * @return - instance of listings class
	 */
	public static Listings getInstance() {
        if (listings == null) {
            listings = new Listings();
        }
        return listings;
    }

	/**
	 * return the current listing list
	 * @return - arraylist of listings
	 */
	public static ArrayList<Listing> getListingList() {
        return listingList;
    }

	/**
	 * add a listing into listings list
	 * @param listing - listing to be added
	 */
	public void addListing(Listing listing) {
        listingList.add(listing);
        ListingWriter.saveListing();
    }


	/**
	 * search for matched listing in the list
	 * @param filterSetting - filters to be searched
	 * @return matched list
	 */
	public static ArrayList<Listing> search(int[] filterSetting) {
		//about filterSetting
		//0		bedroom number
		//1		washroom number
		//2		pet friendly?(1 or 0)
		//3		has washer and dryer?(1 or 0)
		//4		furnished?(1 or 0)
		//5		can walk to campus?(1 or 0)
		//6		has free wifi?(1 or 0)
		//7		has swimming pool?(1 or 0)
		//8		has gym?

		ArrayList<Listing> match = new ArrayList<Listing>();
		for (Listing i : listingList) {
			if (Arrays.equals(i.getSearchFilter(), filterSetting)) {
				match.add(i);
			}
		}
		return match;
	}

	/**
	 * sign a contract
	 * @param selected - listing to be signed
	 * @param account - user who is signing it
	 * @throws IOException - for filr output
	 */
    public static void sign(Listing selected, Account account) throws IOException {

		String DAMAGE_COST = "$150";
		if(selected.getNumAvail() >= 1)
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
			LocalDateTime now = LocalDateTime.now();
			String output = "This Lease Agreement is made and entered on " + dtf.format(now) + " by and between " + selected.getName() + " and " + account.getName() + ".\n" +
    			"\n" +
    			"Subject to the terms and conditions stated below the parties agree as follows:\n" +
    			"\n" +
    			"1. Landloard Tenant Act. This Rental Agreement is governed by the South Carolina Residential Landlord and Tenant Act.\n" +
    			"\n" + 
    			"2. Property. Landloard, in consideration of the lease payments provided in this agreement, leases to Tenant a house with "+
                selected.getNumBedroom() +" bedrooms and "+ selected.getNumBathroom() +" bathrooms, located at "
                + selected.getAddress() +", South Carolina "+ selected.getZIP() +". No other portion of the building wherein the Property is located is included unless expressly provided for in this agreement.\n" +
    			"\n" + 
    			"3. Term. The Tenant will coninue to pay rent from 8/1/21 to 8/1/22.\n" + 
    			"\n" + 
    			"4. Rent. The Tenant will pay "+ selected.getPrice() +" each month on the first of the month.\n" +
    			"\n" + 
    			"5. Payment should be sent to:100 Bloosom Street, Columbia SC\n" + 
    			"\n" + 
    			"6. Damages. Charges will be billed to the client for damaged property, up to "+DAMAGE_COST+".\n" + 
    			"\n" + 
    			"7. Signatures\n" + 
    			"\n" + 
    			"\n" + 
    			"--------------\n" +
    			"<TENANT 1>\n" + 
    			"\n" + 
    			"\n" + 
    			"\n" + 
    			//"--------------\n" +
    			//"(TENANT X, this will only appear if applicable)\n" +
    			//"\n" +
    			//"\n" +
    			//"\n" +
    			//"\n" +
    			"--------------\n" +
    			"<LANDLOARD>\n";
			String fileName = selected.getName() + "_lease.txt";
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(output);
			writer.close();
			System.out.println(output);
			selected.setNumAvail(selected.getNumAvail() - 1);
		}
		else {
			System.out.println("No Lease is avaliable.");
		}
    }
}