import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class AccountLoaderTest {
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
    void testGetAccountsSize(){
        accountList = AccountLoader.loadUsers();
        assertEquals(2,accountList.size());
    }
    @Test
    void testGetAccountsSizeZero(){
        Accounts.getInstance().getUser().clear();
        AccountWriter.saveUser();
        assertEquals(0,accountList.size());
    }
    @Test
    void testGetAccountFirstUserName(){
        accountList = AccountLoader.loadUsers();
        assertEquals("van",accountList.get(0).getName());
    }

}
