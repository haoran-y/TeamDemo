import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        PasswordInfo p = new PasswordInfo();
        p.match("JOHN1997");
        p.match("fdsfasdfsda");
        p.match("abc123");
        p.match("31432433124");// check different passwords here
    }
}
