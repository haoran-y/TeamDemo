import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {
        Listings ls = Listings.getInstance();
        ls.addListing(new Listing("test1", "test address", "29201", 2, 1, 1,
                1445.90));
        ls.sign(new Listing("test1", "test address", "29201", 2, 1, 1,
                1445.90),null);
    }
}
