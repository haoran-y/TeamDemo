import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Account writer class writes accounts to json
 * @author LIMA group
 */
public class AccountWriter extends AccountConstant {

    /**
     * save users into json
     */
    public static void saveUser() {
        Accounts accounts = Accounts.getInstance();
        ArrayList<Account> accountList = accounts.getUser();
        JSONArray jsonUsers = new JSONArray();

        //creating all the json objects
        for(int i = 0; i < accountList.size(); i++) {
            jsonUsers.add(getUserJSON(accountList.get(i)));
        }

        //Write JSON file
        try (FileWriter file = new FileWriter(new File(USER_FILE_NAME))) {

            file.write(jsonUsers.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * create a jsonObject to save
     * @param account - account to be saved
     * @return - jsonObject that can be stored in json
     */
    public static JSONObject getUserJSON(Account account) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_USERNAME, account.getName());
        userDetails.put(USER_PASSWORD, account.getPassword());
        userDetails.put(USER_IS_MANAGER, account.isPropertyManager());
        userDetails.put(USER_IS_LIVEWITHUSER, account.isLiveWithOtherUser());
        return userDetails;
    }
}