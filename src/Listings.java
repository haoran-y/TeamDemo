//package CSCE247Porject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Listings{

	//private static Listing listing;
	//private static Users users;
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

    public void addListing(Listing listing) {
        listingList.add(listing);
    }

    public ArrayList<Listing> getListings() {
    	return listingList;
	}

    

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
			if (i.getSearchFilter().equals(filterSetting)) {
				match.add(i);
			}
		}
		return match;
	}




		/*
    	ArrayList<String> SearchInfo = new ArrayList<String>();
    	SearchInfo.add(name);//0
    	SearchInfo.add(numBedroom);//1
    	SearchInfo.add(numBathroom);//2
    	SearchInfo.add(walkToCampus);//3
    	SearchInfo.add(hasWasherDryer);//4
    	SearchInfo.add(hasPool);//5
    	SearchInfo.add(hasGym);//6
    	SearchInfo.add(hasWifi);//7
    	SearchInfo.add(isPetFriendly);//8
    	SearchInfo.add(isFurnished);//9
    	SearchInfo.add(price);//10
    	
    	
    	for(String i : SearchInfo) {
    		System.out.println(i);
    	}
    	System.out.println("Search: ");
    	*/
    	//return null;
    	
    	
    	
    

        //write search here and call from UI class
        //search can be performed by going through 
    	//the list and mark the ones that fit
    	//is take parameters , go through the list use 
    	//like a for loop, and put every Listing object that 
    	//fit the parameters, into a arraylist, and return that arraylist at the end
   /* class Search {
    	 
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
    }*/
    
   /**
    public static String[] search(int[] filterSetting)
    {
    	List<Listing> List = new ArrayList<Listing>();
		String getSearchFilter[] = new String[2];
		System.out.println("Search Results:");
		return getSearchFilter; 
		//getSearchFilter[0] = scanner.nextLine();
		//getSearchFilter[1] = scanner.nextLine();
		//User temp = users.check(getSearchFilter[0], getSearchFilter[1]);
		//return null;
		
	
	}
	*/
    

    public void sign(Listing selected) throws IOException {
    	
		String DAMAGE_COST = "$150";
		if(selected.getNumAvail() >= 1)
		{
			String output = "This Lease Agreement is made and entered on <DATE> by and between <LANDLOARD> and <TENANT(s)>.\n" +
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
		
		//return(fileOperator);
	
		//minus -1 numAvail;
        //signing agreement
        //remember to check the numAvail in Listing 
    	//object to see if available and deny if it is not available(numberAvail == 0)
        //minus 1 on the numAvail when signed
    }
}