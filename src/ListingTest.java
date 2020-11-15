
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ListingTest {

    @Test
    void testBooleanToIntTrue(){
        Listing listing = new Listing("LiveSC","114514 random","29201",2,
                2,4,1145.14);
    int converted = listing.booleanToInt(true);
    assertEquals(1,converted);
    }
    @Test
    void testBooleanToIntFalse(){
        Listing listing = new Listing("LiveSC","114514 random","29201",2,
                2,4,1145.14);
        int converted = listing.booleanToInt(false);
        assertEquals(0,converted);
    }
}
