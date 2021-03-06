import java.util.ArrayList;

public class Users{
    private static Users users;
    private ArrayList<User> userList;

private Users(){
    userList = DataLoader.getUsers();
}

public static Users getInstance(){
    if(users == null){
        users = new Users();
    }
    return users;
}
public boolean haveUser(String userName){
    for(User user: userList){
        if(user.getUsername().equals(userName)){
            return true;
        }
    }
    return false;
}
public User getUser(String userName){
    for(User user: userList){
        if(user.getUsername().equals(userName)){
            return user;
        }
    }
    return null;
}
public ArrayList<User> getUsers(){
    return userList;
}
public boolean addUser(int id, String name, String username, String email,String password, 
    int age, ArrayList<String> friendNames, ArrayList<Integer> friendAges, ArrayList<Booking> bookings){
        if(haveUser(username))return false;

        userList.add(new User(id, name, username, email , password , age, friendNames, friendAges, bookings));
        return true;
}
public void saveUsers(){
    DataWriter.saveUsers();
}
}