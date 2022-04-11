import java.util.ArrayList;
public class User{
    private int id;
    private String name;
    private String username; 
    private String email;
    private String password;
    private int age;
    private ArrayList<String> friendNames;
    private ArrayList<Integer> friendAges;
    private ArrayList<Booking> bookings;

public User(){
    this.id= 0;
    this.name="";
    this.username="";
    this.email="";
    this.password="";
    this.age = 0;
    this.friendNames = new ArrayList<String>();
    this.friendAges = new ArrayList<Integer>();
    this.bookings = new ArrayList<Booking>();
}
public User(int id, String name, String username, String email, String password , int age, ArrayList<String> friendNames,ArrayList<Integer> friendAges, ArrayList<Booking> bookings){
    this.id = id;
    this.name= name;
    this.username = name; 
    this.email = email;
    this.password = password;
    this.age = age;
    this.friendNames = friendNames;
    this.friendAges = friendAges;
    this.bookings = bookings;
}
public int getID(){
    return this.id;
}
public void setID(int id){
    this.id = id;
}
public String getName(){
    return this.name;
}
public void setName(String name){
    this.name = name;
}
public String getUsername(){
    return this.username;
}
public void setUsername(String username){
    this.username= username;
}
public String getEmail(){
    return this.email;
}
public void setEmail(String email){
    this.email = email;
}
public int getAge(){
    return this.age;
}
public void setAge(int age){
    this.age = age;
}
public String getPassword(){
    return this.password;
}
public void setPassword(String password){
    this.password = password;
}
public ArrayList<String> getFriendNames(){
    return this.friendNames;
}
public void setFriendNames(ArrayList<String> friendNames){
    this.friendNames = friendNames;
}
public ArrayList<Integer> getFriendAges(){
    return this.friendAges;
}
public void setFriendAges(ArrayList<Integer> friendAges){
    this.friendAges = friendAges;
}
public ArrayList<Booking> getBookings(){
    return this.bookings;
}
public void setBookings(ArrayList<Booking> bookings){
    this.bookings = bookings;
}
}