
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PasswordInfoTest {
    private String testPassword = "xzq12345";


    @Test
    void testPasswordTrue(){
        PasswordInfo passwordInfo = new PasswordInfo();
        boolean match = passwordInfo.match("xzq12345");
        assertTrue(match);
    }
    @Test
    void testPasswordFalse(){
        PasswordInfo passwordInfo = new PasswordInfo();
        boolean match = passwordInfo.match("12345");
        assertFalse(match);
    }
}
