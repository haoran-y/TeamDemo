import java.util.ArrayList;

public class Listings {

    private static Listings listings;
    private static ArrayList<Listing> listingList = new ArrayList<Listing>();

    private Listings() {

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

    public void search() {
        //write search here and call from UI class
        //search can be performed by going through the list and mark the ones that fit
    }

    public void sign() {
        //signing agreement
        //remember to check the numAvail in Listing object to see if available and deny if it is not available(numberAvail == 0)
        //minus 1 on the numAvail when signed
    }
}
