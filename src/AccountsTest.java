import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class AccountsTest {
    private Accounts accounts = Accounts.getInstance();
    private ArrayList<Account> accountList = accounts.getUser();
    @BeforeEach
    public void setup(){
        accountList.clear();
        accountList.add(new Account("van","van12345",false,true));
        accountList.add(new Account("billy","billy12345",true,false));
        AccountWriter.saveUser();
    }
    @AfterEach
    public void tearDown(){
        Accounts.getInstance().getUser().clear();
        AccountWriter.saveUser();
    }
    @Test
    void testHaveUserValidFirstItem(){

        Account van = accounts.check("van","van12345");
        assertNotNull(van);

    }
    @Test
    void testHaveUserValidLastItem(){

        Account van = accounts.check("billy","billy12345");
        assertNotNull(van);

    }
    @Test
    void testHaveUserInValid() {
        Account jsmith = accounts.check("jsmith","jsmith12345");
        assertNull(jsmith);
    }
    @Test
    void testFindRepeatFalse() {
        accountList.clear();
        accountList.add(new Account("van","van12345",false,true));
        accountList.add(new Account("van","van123456",false,true));
        AccountWriter.saveUser();
        boolean notRepeat = accounts.checkRepeat("van");
        assertFalse(notRepeat);
    }
    @Test
    void testFindRepeatTrue() {
        boolean notRepeat = accounts.checkRepeat("van");
        assertTrue(notRepeat);
    }
    @Test
    void testToString() {
        String output = "";
        for (Account i : accountList) {
            output += i.getName() + "\n";
        }
        assertEquals(output,accounts.toString());
    }
    @Test
    void testGetUser(){
        assertEquals(accountList,accounts.getUser());
    }
    @Test
    void testAddUser(){
        accounts.addUser(new Account("xie","xie12345",false,true));
        AccountWriter.saveUser();
        Account xie = accounts.check("xie","xie12345");
        assertNotNull(xie);
    }
    @Test
    void testCheckWrongPassword(){
        accounts.addUser(new Account("xie","xzq12345",false,true));
        AccountWriter.saveUser();
        Account xie = accounts.check("xie","12345");
        assertNull(xie);
    }


}
