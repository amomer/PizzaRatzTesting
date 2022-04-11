package rip;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TravelAppTest {
    private Hotels hotels;
    private Flights flights;
    private User currentUser;
    private Booking inProgressBooking;
    private Random random;
    private static final int  UPPERBOUND = 100;
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();
    private User user = new User();
    ArrayList<String> friends = new ArrayList<String>();
    ArrayList<Integer> ages = new ArrayList<Integer>();
    ArrayList<Booking> bookings = new ArrayList<Booking>();

    @BeforeEach
    public void setup(){
        friends.add("Joe");
        ages.add(20);
        userList.clear();
        userList.add(new User(8,"Jerome","jeromethecool","jCOOLest34", 19, friends, ages, bookings));
        DataWriter.saveUsers();
        }

    @AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}

    @Test
    void testLoginCaseSensitivity(){
        boolean login = TravelApp.login("JEROMEthecool");
        assertTrue(login);
        }

    @Test
    void testLoginInvalid(){
        boolean login = TravelApp.login("password123");
        assertFalse(login);
    }
    
    @Test
    void testCreateUserInvalid(){
        User newUser = Users.getUser("jeromethecool");
        boolean create = createUser(newUser);
        assertFalse(create);
    }
}
