import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersTest {
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();
    private User user = new User();

    ArrayList<String> friends = new ArrayList<String>();
    ArrayList<Integer> ages = new ArrayList<Integer>();
    ArrayList<Booking> bookings = new ArrayList<Booking>();

    @BeforeEach
    public void setup() {
        friends.add("Mike");
        ages.add(28);
        userList.clear();
        userList.add(new User(5, "John", "johnny", "jwhite@email.com", "JETihW", 27, friends, ages, bookings));
        DataWriter.saveUsers();
    }

    @AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}

    @Test
	void testHaveUserValid() {
		boolean hasJohn = users.haveUser("johnny");
		assertTrue(hasJohn);
	}

    @Test
	void testHaveUserInvalid() {
		boolean hasMichael = users.haveUser("michael");
		assertFalse(hasMichael);
	}

    @Test
	void testHaveUserInvalidCaseSensitive() {
		boolean hasJohn = users.haveUser("Johnny");
		assertFalse(hasJohn);
	}

    @Test
	void testHaveUserValidByEmail() {
		boolean hasJohn = users.haveUser("jwhite@email.com");
		assertTrue(hasJohn);
	}

    @Test
	void testHaveUserEmpty() {
		boolean hasEmpty = users.haveUser("");
		assertFalse(hasEmpty);
	}

    @Test
	void testHaveUserNull() {
		boolean hasNull = users.haveUser(null);
		assertFalse(hasNull);
	}

    @Test
	void testGetUserValid() {
		users.getUser("johnny");
		assertEquals("johnny", users.getUser("johnny"));
	}

    @Test
	void testGetUserInvalid() {
		users.getUser("Yeti");
		assertNotEquals("Yeti", users.getUser("Yeti"));
	}

    @Test
	void testGetUserInvalidCaseSensitive() {
		users.getUser("Johnny");
		assertNotEquals("Johnny", user.getUsername());
	}

    @Test
	void testAddUserInvalidSamUsername() {
		userList.add(new User(7, "Johnnie", "johnny", "jwalker@email.com", "walkie24", 23, friends, ages, bookings));
		assertEquals("johnny", users.getUsers());
	}
 }
