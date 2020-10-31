import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * listings writer
 * @author LIMA group
 */
public class ListingWriter extends ListingConstant {

    /**
     * write listings to json
     */
    public static void saveListing() {
        Listings lists = Listings.getInstance();
        ArrayList<Listing> listingList = lists.getListingList();
        JSONArray listingJSON = new JSONArray();

        for (int i = 0; i < listingList.size(); i++) {
            listingJSON.add(getListingJSON(listingList.get(i)));
        }

        try (FileWriter file= new FileWriter(new File(LISTING_FILE_NAME))) {

            file.write(listingJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get jsonObject from listing object
     * @param listing - listing object to be converted
     * @return - the jsonObject created
     */
    public static JSONObject getListingJSON(Listing listing) {
        JSONObject listingDetails = new JSONObject();
        listingDetails.put(LISTING_NAME, listing.getName());
        listingDetails.put(LISTING_ADDRESS, listing.getAddress());
        listingDetails.put(LISTING_ZIP, listing.getZIP());
        listingDetails.put(LISTING_PRICE, listing.getPrice());
        listingDetails.put(LISTING_NUMAVAIL, listing.getNumAvail());
        listingDetails.put(LISTING_NUMBATHROOM, listing.getNumBathroom());
        listingDetails.put(LISTING_NUMBEDROOM, listing.getNumBedroom());
        listingDetails.put(LISTING_WALK2CAMPUS, listing.isWalkToCampus());
        listingDetails.put(LISTING_HASGYM, listing.isHasGym());
        listingDetails.put(LISTING_HASPOOL, listing.isHasPool());
        listingDetails.put(LISTING_HASWASHERDRYER, listing.isHasWasherDryer());
        listingDetails.put(LISTING_HASWIFI, listing.isHasWifi());
        listingDetails.put(LISTING_ISFURNISHED, listing.isFurnished());
        listingDetails.put(LISTING_ISPETFRIENDLY, listing.isPetFriendly());

        return listingDetails;
    }
}