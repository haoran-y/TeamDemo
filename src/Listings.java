import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Listings{



	private static Listings listings;
	 
    private static ArrayList<Listing> listingList = new ArrayList<Listing>();
	
    private Listings() {
    	listingList = ListingLoader.loadListings();
    }

    public static Listings getInstance() {
        if (listings == null) {
            listings = new Listings();
        }
        return listings;
    }

    public static ArrayList<Listing> getListingList() {
        return listingList;
    }

    public void addListing() {
        //look at listing class on how to add a listing
    }

    public ArrayList<Listing> getListings() {
    	return listingList;
	}

    
    /*
    public static ArrayList<String> search() {
    	ArrayList<String> SearchInfo = new ArrayList<String>();
    	SearchInfo.add(name);
    	SearchInfo.add(numBedroom);
    	SearchInfo.add(numBathroom);
		SearchInfo.add(numAvail);
    	SearchInfo.add(walkToCampus);
    	SearchInfo.add(hasWasherDryer);
    	SearchInfo.add(hasPool);
    	SearchInfo.add(hasGym);
    	SearchInfo.add(hasWifi);
    	SearchInfo.add(isPetFriendly);
    	SearchInfo.add(isFurnished);
    	SearchInfo.add(price);
    	
    	
    	for(String i : SearchInfo) {
    		System.out.println(i);
    	}
    	System.out.println("Search: ");
    	
    	return SearchInfo;
    	
    	
    	}
    
    */
        //write search here and call from UI class
        //search can be performed by going through 
    	//the list and mark the ones that fit
    	//is take parameters , go through the list use 
    	//like a for loop, and put every Listing object that 
    	//fit the parameters, into a arraylist, and return that arraylist at the end
    class Search {
    	 
        public void main(String a[]){
             
            List<users> List = new ArrayList<users>();
            List.add(new users(12,"Dinesh",50000));
            List.add(new users(146,"Tom",20000));
            List.add(new users(201,"John",40000));
            List.add(new users(302,"Krish",44500));
            List.add(new users(543,"Abdul",10000));
             
            users searchKey = new users(201,"John",40000);
            int index = Collections.binarySearch(List, searchKey, new Comp());
            System.out.println("Index of the searched key: "+index);
        }
    }
    

    public void sign(Listing selected) {
    	
		String DAMAGE_COST = "$150";
		System.out.println("This Lease Agreement is made and entered on <DATE> by and between <LANDLOARD> and <TENANT(s)>.\n" + 
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
    			"--------------\n" + 
    			"(TENANT X, this will only appear if applicable)\n" + 
    			"\n" + 
    			"\n" + 
    			"\n" + 
    			"\n" + 
    			"--------------\n" +
    			"<LANDLOARD>\n");
        //signing agreement
        //remember to check the numAvail in Listing 
    	//object to see if available and deny if it is not available(numberAvail == 0)
        //minus 1 on the numAvail when signed
    }
}
