import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Account loader class loading accounts from json
 * @author LIMA group
 */
public class AccountLoader extends AccountConstant {

    /**
     * load data from json
     * @return - arraylist of users current in database
     */
    public static ArrayList<Account> loadUsers() {
        ArrayList<Account> accountList = new ArrayList<Account>();

        try {
            FileReader reader = new FileReader(new File(USER_FILE_NAME));
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) parser.parse(reader);

            if (userJSON.size() >= 1) {

                for (int i = 0; i < userJSON.size(); i++) {
                    JSONObject personJSON = (JSONObject) userJSON.get(i);
                    String name = (String) personJSON.get(USER_USERNAME);
                    String password = (String) personJSON.get(USER_PASSWORD);
                    boolean isManager = (boolean) personJSON.get(USER_IS_MANAGER);
                    boolean liveWithUser = (boolean) personJSON.get(USER_IS_LIVEWITHUSER);
                    accountList.add(new Account(name, password, isManager, liveWithUser));
                }
            }

            return accountList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}