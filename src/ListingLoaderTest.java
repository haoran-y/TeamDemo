
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ListingLoaderTest {
    private Listings listings = Listings.getInstance();
    private ArrayList<Listing> listingList = listings.getListingList();
    @BeforeEach
    public void setup(){
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
    void testGetListingsSize(){
        listingList = ListingLoader.loadListings();
        assertEquals(2,listingList.size());
    }
    @Test
    void testGetListingsSizeZero(){
        listings.getInstance().getListingList().clear();
        ListingWriter.saveListing();
        assertEquals(0,listingList.size());
    }
    @Test
    void testGetFirstListingName(){
        listingList = ListingLoader.loadListings();
        assertEquals("LiveSC",listingList.get(0).getName());
    }
    @Test
    void testGetFirstListingPrice(){
        listingList = ListingLoader.loadListings();
        assertEquals(1145.14,listingList.get(0).getPrice());
    }
}
