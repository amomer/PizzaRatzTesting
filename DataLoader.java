import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
    
    //USER LOADER
    public static ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try{ 
            FileReader reader = new FileReader("/C:/Users/kevin/Documents/CSCE247/PizzaRatzTesting/users.json");
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i =0;i<usersJSON.size();i++){
                 JSONObject userJSON= (JSONObject)usersJSON.get(i);
                 
                 int id = ((Long)userJSON.get(USER_ID)).intValue();
                 String name = (String)userJSON.get(USER_NAME);
                 String username = (String)userJSON.get(USER_USERNAME); 
                 String email = (String)userJSON.get(USER_EMAIL);
                 String password= (String)userJSON.get(USER_PASSWORD);
                 int age = ((Long)userJSON.get(USER_AGE)).intValue();
                 ArrayList<String> friendNames = (ArrayList<String>)userJSON.get(USER_FRIEND_NAMES);
                 ArrayList<Integer> friendAges = (ArrayList<Integer>)userJSON.get(USER_FRIEND_AGES);
                 ArrayList<Booking> bookings = (ArrayList<Booking>)userJSON.get(USER_BOOKINGS);
                 
                 users.add(new User(id, name, username, email ,password, age, friendNames, friendAges, bookings));
            }
            return users;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
        }

    //FLIGHT LOADER
    public static ArrayList<Flight> getFlights(){
        ArrayList<Flight> flights = new ArrayList<Flight>();
        
        try{
            FileReader reader = new FileReader(DataConstants.FLIGHT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i =0;i<flightsJSON.size();i++){
                 JSONObject flightJSON= (JSONObject)flightsJSON.get(i);
                 int id = ((Long)flightJSON.get(DataConstants.FLIGHT_ID)).intValue();
                 String takeOffLocation = (String)flightJSON.get(FLIGHT_TAKEOFF_LOCATION);
                 String takeoffCode = (String)flightJSON.get(FLIGHT_TAKEOFF_CODE);
                 String destinationLocation = (String)flightJSON.get(FLIGHT_DESTINATION_LOCATION);
                 String destinationCode = (String)flightJSON.get(FLIGHT_DESTINATION_CODE);
                 String takeoffTime = (String)flightJSON.get(FLIGHT_TAKEOFF_TIME);
                 String takeoffDate = (String)flightJSON.get(FLIGHT_TAKEOFF_DATE);
                 String landingTime = (String)flightJSON.get(FLIGHT_LANDING_TIME);
                 String duration = (String)flightJSON.get(FLIGHT_DURATION);
                 int transferCount = ((Long)flightJSON.get(TRANSFER_COUNT)).intValue();
                 ArrayList<String> transferCodes = (ArrayList<String>)flightJSON.get(TRANSFER_CODES);
                 boolean layover = (Boolean)flightJSON.get(FLIGHT_LAYOVER);
                 boolean covid = (Boolean)flightJSON.get(FLIGHT_COVID);
                 ArrayList<String> economySeating = (ArrayList<String>)flightJSON.get(FLIGHT_ECONOMY_SEATING);
                 double economyCostOW = (Double)flightJSON.get(FLIGHT_ECONO_COST_OW);
                 double economyCostRT = (Double)flightJSON.get(FLIGHT_ECONO_COST_RT);
                 ArrayList<String> FCSeating = (ArrayList<String>)flightJSON.get(FLIGHT_FC_SEATING);
                 double FCCostOW = (double)flightJSON.get(FLIGHT_FC_COST_OW);
                 double FCCostRT = (double)flightJSON.get(FLIGHT_FC_COST_RT);
                 boolean pets = (boolean)flightJSON.get(FLIGHT_PETS);

                 flights.add(new Flight(id, takeOffLocation, takeoffCode, destinationLocation, destinationCode, takeoffTime,
                    takeoffDate, landingTime, duration, transferCount, transferCodes, layover, covid, economySeating,
                    economyCostOW, economyCostRT, FCSeating, FCCostOW,FCCostRT, pets));
            } 
        return flights;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //HOTEL LOADER
    public static ArrayList<Hotel> getHotels(){
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();

        try{
            FileReader reader = new FileReader(HOTEL_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray hotelsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i =0;i<hotelsJSON.size();i++){
                 JSONObject hotelJSON= (JSONObject)hotelsJSON.get(i);
                 int id = ((Long)hotelJSON.get(HOTEL_ID)).intValue();
                 String name = (String)hotelJSON.get( HOTEL_NAME);
                 String location = (String)hotelJSON.get(HOTEL_LOCATION);
                 ArrayList<Integer> singleAvailability = (ArrayList<Integer>)hotelJSON.get(HOTEL_SINGLE_ROOM_AVAILABILITY);
                 ArrayList<Integer> smokingAvailability = (ArrayList<Integer>)hotelJSON.get(HOTEL_SMOKING_ROOM_AVAILABILITY);
                 ArrayList<Integer>queenAvailability = (ArrayList<Integer>)hotelJSON.get(HOTEL_QUEEN_ROOM_AVAILABILIITY);
                 ArrayList<Integer> doubleAvailability = (ArrayList<Integer>)hotelJSON.get(HOTEL_DOUBLE_QUEEN_ROOM_AVAILABILITY);
                 double singleCost = (double)hotelJSON.get(HOTEL_SINGLE_ROOM_COST);
                 double smokingPremium = (double)hotelJSON.get(HOTEL_SMOKING_PREMIUM);
                 double queenCost = (double)hotelJSON.get(HOTEL_QUEEN_ROOM_COST);
                 double doubleCost = (double)hotelJSON.get(HOTEL_DOUBLE_ROOM_COST);
                 String rating = (String)hotelJSON.get(HOTEL_RATING);
                 ArrayList<Amenities> amenities = (ArrayList<Amenities>)hotelJSON.get(HOTEL_AMENITIES);

                 hotels.add(new Hotel(id, name,location, singleAvailability,smokingAvailability, queenAvailability, doubleAvailability,
                    singleCost, smokingPremium, queenCost, doubleCost,rating, amenities));
            }
        return hotels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }
    
    