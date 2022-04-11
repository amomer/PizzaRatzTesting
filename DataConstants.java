public abstract class DataConstants{
    //user constants
    protected static final String USER_FILE_NAME= "rip/users.json";
    protected static final String USER_ID="id";
    protected static final String USER_NAME = "name";
    protected static final String USER_USERNAME= "username";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PASSWORD = "password";
    public static final String USER_AGE = "age";
    public static final String USER_FRIEND_NAMES="friendNames";
    public static final String USER_FRIEND_AGES ="friendAges";
    public static final String USER_BOOKINGS = "bookings";
    //hotel constants
    protected static final String HOTEL_FILE_NAME="hotels.json";
    protected static final String HOTEL_ID="id";
    protected static final String HOTEL_NAME = "hotelName";
    protected static final String HOTEL_LOCATION ="location";
    protected static final String HOTEL_SINGLE_ROOM_AVAILABILITY = "singleRoomsAvailable";
    protected static final String HOTEL_SMOKING_ROOM_AVAILABILITY = "smokingRoomsAvailable";
    protected static final String HOTEL_QUEEN_ROOM_AVAILABILIITY = "queenRoomsAvailable";
    protected static final String HOTEL_DOUBLE_QUEEN_ROOM_AVAILABILITY = "doubleQueenRoomsAvailable";
    protected static final String HOTEL_SINGLE_ROOM_COST = "singleCost";
    protected static final String HOTEL_SMOKING_PREMIUM = "smokingRoomCost";
    protected static final String HOTEL_QUEEN_ROOM_COST = "queenCost";
    protected static final String HOTEL_DOUBLE_ROOM_COST = "doubleCost";
    protected static final String HOTEL_RATING = "rating";
    protected static final String HOTEL_AMENITIES = "amenities";
    //flight constants
    protected static final String FLIGHT_FILE_NAME="flights.json"; 
    protected static final String FLIGHT_ID ="id";
    protected static final String FLIGHT_TAKEOFF_LOCATION ="takeoffLocation";
    protected static final String FLIGHT_TAKEOFF_CODE ="takeoffCode";
    protected static final String FLIGHT_DESTINATION_LOCATION ="destinationLocation";
    protected static final String FLIGHT_DESTINATION_CODE="destinationCode";
    protected static final String FLIGHT_TAKEOFF_TIME ="takeoffTime";
    protected static final String FLIGHT_TAKEOFF_DATE ="takeoffDate";
    protected static final String FLIGHT_LANDING_TIME = "landingTime";
    protected static final String FLIGHT_DURATION ="travelDuration";
    protected static final String TRANSFER_COUNT = "transferCount";
    protected static final String TRANSFER_CODES = "transferAirportCodes";
    protected static final String FLIGHT_LAYOVER = "layover";
    protected static final String FLIGHT_COVID ="covidRestricted";
    protected static final String FLIGHT_ECONOMY_SEATING ="economyOpenSeating";
    protected static final String FLIGHT_ECONO_COST_OW ="costEconomyOneWay";
    protected static final String FLIGHT_ECONO_COST_RT= "costEconomyRoundTrip";
    protected static final String FLIGHT_FC_SEATING = "firstClassOpenSeating";
    protected static final String FLIGHT_FC_COST_OW ="costFirstClassOneWay";
    protected static final String FLIGHT_FC_COST_RT="costFirstClassRoundTrip";
    protected static final String FLIGHT_PETS ="petsAllowed";
    //booking constants
    protected static final String BOOKING_FILE_NAME="bookings.json"; 
    protected static final String BOOKING_ID ="bookingId";
    protected static final String BOOKING_FLIGHT_ID ="flightId";
    protected static final String BOOKING_USER_ID ="userId";
    protected static final String BOOKING_HOTEL_ID ="hotelId";
    protected static final String BOOKING_ROOMS_BOOKED="roomsBooked";
    protected static final String BOOKING_ROUNDTRIP ="roundtrip";
    protected static final String BOOKING_FLIGHTCLASS ="flightclass";
    protected static final String BOOKING_SEATCOUNT = "seatCount";
    protected static final String BOOKING_SEATSBOOKED ="seatsBooked";
    protected static final String BOOKING_SPECIALASSSISTANCE = "specialAssisReq";
    protected static final String BOOKING_PETS = "pets";
    protected static final String BOOKING_COST = "totalCost";
}