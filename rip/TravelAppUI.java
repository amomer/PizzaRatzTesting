import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

import javax.lang.model.util.ElementScanner14;
public class TravelAppUI{
    private Scanner scanner;
    private static final String WELCOME_PROMPT = "Welcome to our Booking Service";
    private static final String[] LOGIN_PROMPT = {"Enter 1 to Login", "Enter 2 to Register","Enter 3 to exit Program"};
    private static final String[] BOOKING_PROMPTS ={"Enter 1 for new Booking, Enter 2 to show Booking History ,Enter 3 to logout"};
    private TravelApp travelApp;
    private Random rand;

public TravelAppUI(){
    scanner = new Scanner(System.in);
    travelApp = new TravelApp();
    rand = new Random();
}

public void run(){
    int compCount = 0;
    System.out.println(WELCOME_PROMPT);
        displayLogin();
        int input = scanner.nextInt();
        scanner.nextLine();
    if(input == 1)
        login();
    else if (input == 2)
        createUser();
    else
        return;
    String name = travelApp.getCurrentUser().getUsername();
    System.out.println("Welcome , "+name+"\n\nWhat would you like to do?");
    for(int i=0;i<BOOKING_PROMPTS.length;i++){
        System.out.println(BOOKING_PROMPTS[i]);
    input = scanner.nextInt();
    scanner.nextLine();
    if(input == 1){
        travelApp.createBooking();
        //get friends
        System.out.print("\nTravel companions? Enter true or false");
        boolean companions = scanner.nextBoolean();
        if(companions == true){
        System.out.println("How many companions?");
        compCount = scanner.nextInt();
        scanner.nextLine();
        getCompanions(compCount);
        }
        //choose flight
        ArrayList<Flight> Flightresults = getFlightInfo();
        printFlightResults(Flightresults);
        System.out.println("Enter the result # to start booking flight seats");
        input = scanner.nextInt();
        scanner.nextLine();
        input= input-2;
        Flight bookedFlight = Flightresults.get(input);
        ArrayList<String> bookedSeats = bookSeats(bookedFlight, compCount);
        travelApp.addFlightInfo(bookedFlight, bookedSeats);
        //chose hotels
        System.out.println("-----Hotel Booking-----");
        System.out.println("Searching for hotels in your flight destination");
        String location = bookedFlight.getDestinationLocation();
        ArrayList<Hotel> hotelResults = travelApp.hotelSearch(location);
        printHotelResults(hotelResults);
        System.out.println(" Enter the result number of the hotel where  you'd like to book your room(s)");
        input = scanner.nextInt();
        scanner.nextLine();
        input--;
        Hotel bookedHotel = hotelResults.get(input);
        bookRooms(bookedHotel);
        //ArrayList<Integer> bookedRooms = bookRooms(bookedHotel);
        //travelApp.addHotelInfo(bookedHotel, bookedRooms);
        //print?
        System.out.println("Would you like to print your Booking information? Enter true or false");
        boolean print = scanner.nextBoolean();
        //if print == true ,print booking  to text
        if(print == true){
        String filename = printBookingToFile();
        System.out.println("Booking printed to file "+filename);
        }
        //exit
        return;
    }
    else if(input == 2){
        printBookingHistory();
        return;
    }
    else
        return;
    }  
    }
public void displayLogin(){
    for(int i = 0; i < LOGIN_PROMPT.length;i++){
        System.out.println(LOGIN_PROMPT[i]);
    }
}
public void login(){
        System.out.print("What is your username?");
        String username = scanner.nextLine();
        travelApp.login(username);
}
public void createUser(){
        System.out.println("-----Account Creator-----\n Enter the following:");
        int id = rand.nextInt();
        System.out.print("\nFull Name: ");
        String name = scanner.nextLine();
        System.out.print("\nusername: ");
        String username = scanner.nextLine();
        System.out.print("\nemail: ");
        String email = scanner.nextLine();
        System.out.print("\npassword: ");
        String password = scanner.nextLine();
        System.out.print("\nage: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> friendNames = new ArrayList<String>();
        ArrayList<Integer> friendAges = new ArrayList<Integer>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        travelApp.createUser(id, name , username, email ,password, age, friendNames, friendAges, bookings);
        travelApp.login(username);         
}
public void printBookingHistory(){
    String toPrint = travelApp.bookingHistory();
}
public void getCompanions(int compCount){
           ArrayList<String> friendNames= new ArrayList<String>();
           ArrayList<Integer> friendAges = new ArrayList<Integer>();
           for(int i=1; i<compCount+1;i++){
               System.out.print("Companion "+i+ " Full Name: ");
               String name = scanner.nextLine();
               System.out.println("\nCompanion "+i+"age");
               int age = scanner.nextInt();
               scanner.nextLine();
            friendNames.add(name);
            friendAges.add(age);
            System.out.println(name+" Added.");
           }
           travelApp.getCurrentUser().setFriendNames(friendNames);
           travelApp.getCurrentUser().setFriendAges(friendAges);
}
public ArrayList<Flight> getFlightInfo(){
    scanner.nextLine();
    System.out.println("-----Flight Booking-----");
    System.out.println("Departure Location:");
    String start = scanner.nextLine();
    System.out.println("Destination:");
    String destination = scanner.nextLine();
    System.out.println("ok with layover(enter true or false): ");
    boolean layover = scanner.nextBoolean();
    ArrayList<Flight> results = travelApp.flightSearch(start, destination , layover);
    return results;
}
public void printFlightResults(ArrayList<Flight> results){
    for(int i=0; i < results.size();i++){
        System.out.println("Result "+(i+1)+":");
        System.out.println(results.get(i).toString());
    }
    return;
}
public ArrayList<String> bookSeats(Flight bookedFlight, int travelCompanions){
    ArrayList<String> bookedSeats = new ArrayList<String>();
    System.out.println("Preferred class?(economy or first class ");
    String flightClass = scanner.next();
    scanner.nextLine();
    ArrayList<String> seats = new ArrayList<String>();
    System.out.println("roundtrip? true or false");
    boolean roundtrip = scanner.nextBoolean();
    double seatCost = 0.0;
    double totalCost=0.0;
    if(flightClass.equalsIgnoreCase("economy")){
        if(roundtrip == false)
            seatCost = bookedFlight.getEconoCost("OW");
        else{
            seatCost = bookedFlight.getEconoCost("RT");
        }
        seats = bookedFlight.getEconoSeating();
    }
    else{
        if(roundtrip == false)
            seatCost = bookedFlight.getEconoCost("OW");
        else
            seatCost = bookedFlight.getEconoCost("RT");
        
        seats = bookedFlight.getFirstClassSeating(); 
    }
        int count = 0;
        while(count < travelCompanions+1){
        System.out.println("Available seats: ");
        for(int i=0;i<seats.size();i++)
            System.out.println(seats.get(i));
        
        System.out.println("Cost per Seat: "+seatCost);
        System.out.println("Choose a seat: ");
        String chosenSeat = scanner.next();
        seats.remove(chosenSeat);
        bookedSeats.add(chosenSeat);
        count++;
    }
    totalCost = seatCost * travelApp.getCurrentUser().getFriendNames().size();
    travelApp.updatePrice(totalCost);
    System.out.println("Flight seats successfully booked!\nFlight total: "+totalCost);
    return bookedSeats;
    }
public void printHotelResults(ArrayList<Hotel> results){
    for(int i=0; i < results.size();i++){
        System.out.println("Result "+(i+1)+":");
        System.out.println(results.get(i).toString());
    }
    return;
}
public void   bookRooms(Hotel hotel){
    ArrayList<Integer> ret = new ArrayList<Integer>();
    ArrayList<Integer> Singlerooms = hotel.getSingleAvailability();
    ArrayList<Integer> Smokingrooms = hotel.getSmokingAvailability();
    ArrayList<Integer> Queenrooms = hotel.getQueenAvailability();
    ArrayList<Integer> Doublerooms = hotel.getDoubleAvailability();
    
    double roomPrice = 0.0;
    double totalPrice = 0.0;
    System.out.println("Enter the number of rooms you would like to book");
    int count = scanner.nextInt();
    scanner.nextLine();
    while(count >= 0){
    System.out.println("Press 1 to book a single room, Price per: "+hotel.getSingleCost()+
    "\nPress 2 to book a smoking room, Price per: "+hotel.getSmokingCost()+
        "\nPress 3 to book a queen room, Price per: "+hotel.getQueenCost()+
            "\nPress 4 to book a double queen room, Price per: "+hotel.getDoubleCost());
        int input =scanner.nextInt();
        scanner.nextLine();
    if(input == 1){
        System.out.println(count+"Single room(s) booked");
        //roomPrice = hotel.getSingleCost();
        //System.out.println("Single Rooms Available: ");
        //for(int i=0; i< hotel.getSingleAvailability().size();i++){
           // System.out.println(hotel.getSingleAvailability().get(i));
        //}
       // int room = chooseRoom(Singlerooms);
       // for(int i =0; i<Singlerooms.size();i++){
           // if(Singlerooms.get(i) == room){
               // Singlerooms.remove(i);
            //}
        
        //ret.add(room);
       // travelApp.updatePrice(roomPrice);
    }else if(input == 2){
        System.out.println(count+"Smoking room(s) booked");
       // roomPrice = hotel.getSmokingCost();
       // System.out.println("Smoking Rooms Available: ");
       // for(int i=0; i< hotel.getSmokingAvailability().size();i++){
         //   System.out.println(hotel.getSmokingAvailability().get(i));
       // }
      //  int room = chooseRoom(Smokingrooms);
        //for(int i =0; i<Smokingrooms.size();i++){
        //    if(Smokingrooms.get(i) == room){
           //     Smokingrooms.remove(i);
           // }
       // }
       // ret.add(room);
        //travelApp.updatePrice(roomPrice);

     }else if(input == 3){
        System.out.println(count+"Queen room(s) booked");
      //  roomPrice = hotel.getQueenCost();
      //  System.out.println("Queen Rooms Available: ");
       // for(int i=0; i< hotel.getQueenAvailability().size();i++){
       //     System.out.println(hotel.getQueenAvailability().get(i));
       // }
       // int room = chooseRoom(Queenrooms);
       // for(int i =0; i<Queenrooms.size();i++){
        //    if(Queenrooms.get(i) == room){
               // Queenrooms.remove(i);
            //}
        //}
// ret.add(room);
       // travelApp.updatePrice(roomPrice);
    }else{
        System.out.println(count+" Double Queen room(s) booked");
       // roomPrice = hotel.getDoubleCost();
       // System.out.println("Double Rooms Available: ");
       // for(int i=0; i< hotel.getDoubleAvailability().size();i++){
      //      System.out.println(hotel.getDoubleAvailability().get(i));
      //  }
       // int room = chooseRoom(Doublerooms);
       // for(int i =0; i<Doublerooms.size();i++){
     //       if(Doublerooms.get(i) == room){
       //         Doublerooms.remove(i);
      //      }
      //  }
      //  ret.add(room);
      //  travelApp.updatePrice(roomPrice);
   // }/
   // }
 System.exit(0);
     }
}
}
public int chooseRoom(ArrayList<Integer> rooms){
    System.out.println("Enter the room number you would like to book");
    int ret = scanner.nextInt();
    scanner.nextInt();
    return ret;
}
public String printBookingToFile(){
    return "todo";
}
public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    TravelAppUI travelAppUI = new TravelAppUI();
    travelAppUI.run();
    System.out.println("Do you wish to exit the program?");
    boolean response = scanner.nextBoolean();
    if(response == false)
        travelAppUI.run();
    System.out.println("Goodbye");
    System.exit(0);

}
}