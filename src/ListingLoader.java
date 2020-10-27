
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ListingLoader extends ListingConstant {

    public static ArrayList<Listing> loadListings() {

        ArrayList<Listing> listingList= new ArrayList<Listing>();

        try {
            FileReader reader = new FileReader(new File(LISTING_FILE_NAME));
            JSONParser parser = new JSONParser();
            JSONArray listingJson = (JSONArray) parser.parse(reader);

            if (listingJson.size() >= 1) {

                for (int i = 0; i < listingJson.size(); i++) {
                    JSONObject listingObject = (JSONObject) listingJson.get(i);
                    String name = (String) listingObject.get(LISTING_NAME);
                    String address = (String) listingObject.get(LISTING_ADDRESS);
                    String ZIP = (String) listingObject.get(LISTING_ZIP);
                    int numBedroom = (int) listingObject.get(LISTING_NUMBEDROOM);
                    int numBathroom = (int) listingObject.get(LISTING_NUMBATHROOM);
                    int numAvail = (int) listingObject.get(LISTING_NUMAVAIL);
                    double price = (double) listingObject.get(LISTING_PRICE);
                    Listing temp = new Listing(name, address, ZIP, numBedroom, numBathroom,
                            numAvail, price);
                    temp.setWalkToCampus((boolean) listingObject.get(LISTING_WALK2CAMPUS));
                    temp.setHasWasherDryer((boolean) listingObject.get(LISTING_HASWASHERDRYER));
                    temp.setHasGym((boolean) listingObject.get(LISTING_HASGYM));
                    temp.setHasPool((boolean) listingObject.get(LISTING_HASPOOL));
                    temp.setHasWifi((boolean) listingObject.get(LISTING_HASWIFI));
                    temp.setFurnished((boolean) listingObject.get(LISTING_ISFURNISHED));
                    temp.setPetFriendly((boolean) listingObject.get(LISTING_ISPETFRIENDLY));
                    listingList.add(temp);
                }
            }

            return listingList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}