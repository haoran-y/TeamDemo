import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListingsTest {
    Listings listings = Listings.getInstance();
    private ArrayList<Listing> listingList  = listings.getListingList();
    @BeforeEach
    public void setUp(){
        listingList.clear();
        listingList.add(new Listing("LiveSC","114514 random","29201",2,
                2,4,1145.14));
        listingList.add(new Listing("LiveSC","114514 random","29201",2,
                1,2,1919.81));
        ListingWriter.saveListing();
    }
    @AfterEach
    public void tearDown(){
        listings.getInstance().getListingList() .clear();
        ListingWriter.saveListing();
    }
    @Test
    void TestSearch(){
        int[] filterSetting = {2,2,-1,-1,-1,-1,-1,-1,-1};
        ArrayList<Listing> match = listings.search(filterSetting);
        assertEquals(listingList.get(0),match.get(0));
    }
    @Test
    void testAddListing(){
        listings.addListing(new Listing("testUnit","testAddress","29201",2,
                2,1,810.45));
        ListingWriter.saveListing();
        assertEquals(3, listingList.size());
    }
}
