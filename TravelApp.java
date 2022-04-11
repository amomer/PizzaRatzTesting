import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class TravelApp{
   private Hotels hotels;
   private Users users;
   private Flights flights;
   private User currentUser;
   private Booking inProgressBooking;
   private Random random;
   private static final int  UPPERBOUND = 100;

   public TravelApp() {
    users = Users.getInstance();
    flights = Flights.getInstance();
    hotels = Hotels.getInstance();
    currentUser =new User();
    random = new Random();
    }
    //load user
    public boolean login(String username) {
		if(!users.haveUser(username))return false;
		
		currentUser = users.getUser(username);
		return true;
	}
    //create user
    public boolean createUser(int id, String name, String username, String email, String password , int age, ArrayList<String> friendNames,ArrayList<Integer> friendAges, ArrayList<Booking> bookings)
	{
		return users.addUser(id, name , username, email , password, age, friendNames, friendAges,bookings );
	}
    //get user 
    public User getCurrentUser() {
		return currentUser;
	}
    public void createBooking(){
        inProgressBooking = new Booking();
        inProgressBooking.setBookingId(random.nextInt(UPPERBOUND));
        inProgressBooking.setUserId(currentUser.getID());
        

    }
    public String bookingHistory(){
        return "todo";
    }
    public ArrayList<Flight> flightSearch(String from , String to, boolean layover){
        ArrayList<Flight> results = flights.getFlight(from, to , layover);
        return results;
    }
    public void addFlightInfo(Flight flight, ArrayList<String> seats){
        inProgressBooking.setFlightId(flight.getFlightID());
        inProgressBooking.setSeatCount(currentUser.getFriendNames().size());
        inProgressBooking.setSeatsBooked(seats);
    }
    public void addHotelInfo(Hotel hotel, ArrayList<Integer> rooms){
        System.out.println("Hotel Booking successfull");
        //inProgressBooking.setHotelID(hotel.getID());
        //inProgressBooking.setRoomsBooked(rooms);
    }
    public ArrayList<Hotel> hotelSearch(String location){
        ArrayList<Hotel> results = hotels.getHotel(location);
        return results;
    }
    public void updatePrice(double price){
        price += inProgressBooking.getTotalCost();
        inProgressBooking.setTotalCost(price);
    }
    //public ArrayList<Hotel> hotelSearch(String location, HashMap<String, Boolean> criteria){
        //ArrayList<Hotel> results = hotels.getHotel(location ,criteria);
        //return results;
   // }
    public void logout() {
		users.saveUsers();
	}
}