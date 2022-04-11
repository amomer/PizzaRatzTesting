import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants {
    public static void saveUsers(){
        Users users = Users.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        //create JSON objects
        for(int i=0; i< userList.size();i++){
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        //write JSON file
        try(FileWriter file = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static JSONObject getUserJSON(User user){
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getID());
        userDetails.put(USER_NAME, user.getName());
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_AGE, user.getAge());
        userDetails.put(USER_FRIEND_NAMES, user.getFriendNames());
        userDetails.put(USER_FRIEND_AGES, user.getFriendAges());
        userDetails.put(USER_BOOKINGS, user.getBookings());
        
        return userDetails;
    }
}