import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UserWriter extends UserConstant {

    public static void saveUser() {
        Users users = Users.getInstance();
        ArrayList<User> userList = users.getUser();
        JSONArray jsonUsers = new JSONArray();

        //creating all the json objects
        for(int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        //Write JSON file
        try (FileWriter file = new FileWriter(new File(USER_FILE_NAME))) {

            file.write(jsonUsers.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_USERNAME, user.getName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_IS_MANAGER, user.isPropertyManager());

        return userDetails;
    }
}