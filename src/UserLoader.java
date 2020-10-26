import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserLoader extends UserConstant{

    public static ArrayList<User> loadUsers() {
        ArrayList<User> userList = new ArrayList<User>();

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
                    userList.add(new User(name, password, isManager));
                }
            }

            return userList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}