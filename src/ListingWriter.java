import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ListingWriter extends ListingConstant {

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

    public static JSONObject getListingJSON(Listing listing) {

    }
}
