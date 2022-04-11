import java.util.ArrayList;
public class Booking{
    private int bookingId;
    private int flightId;
    private int userId;
    private int hotelId;
    private ArrayList<Integer> roomsBooked;
    private boolean roundtrip;
    private String flightclass;
    private int seatCount;
    private ArrayList<String> seatsBooked;
    private boolean specialAssisReq;
    private boolean pets;
    private double totalCost;
public Booking(){
    this.bookingId=0;
    this.flightId=0;
    this.userId=0;
    this.hotelId=0;
    this.roomsBooked = new ArrayList<Integer>();
    this.roundtrip =false;
    this.flightclass = "";
    this.seatCount=0;
    this.seatsBooked=new ArrayList<String>();
    this.specialAssisReq = false;
    this.pets=false;
    this.totalCost = 0.0;

}
public Booking(int bookingId,int flightId,int userId ,int hotelId , ArrayList<Integer> roomsBooked ,boolean roundtrip,String flightclass,int seatCount ,ArrayList<String> seatsBooked,
boolean specialAssisReq,boolean pets,double totalCost){
    this.bookingId=bookingId;
    this.flightId=flightId;
    this.userId=userId;
    this.hotelId=hotelId;
    this.roomsBooked = roomsBooked;
    this.roundtrip =roundtrip;
    this.flightclass = flightclass;
    this.seatCount=seatCount;
    this.seatsBooked=seatsBooked;
    this.specialAssisReq = specialAssisReq;
    this.pets=pets;
    this.totalCost = totalCost;


   }
public int getBookingId(){
    return this.bookingId;
}
public void setBookingId(int bookingId){
    this.bookingId =bookingId;
}
public int getFlightId(){
    return this.flightId;
}
public void setFlightId(int flightId){
    this.flightId = flightId;
}
public int getUserId(int userId){
    return this.userId;
}
public void setUserId(int userId){
    this.userId = userId;
}
public int getHotelId(){
    return this.hotelId;
}
public void setHotelID(int hotelId){
    this.hotelId = hotelId;
}
public ArrayList<Integer> getRoomsBooked(){
    return this.roomsBooked;
}
public void setRoomsBooked(ArrayList<Integer> roomsBooked){
    this.roomsBooked = roomsBooked;
}
public boolean getRoundtrip(){
    return this.roundtrip;
}
public void setRoundTrip(boolean rountrip){
    this.roundtrip = roundtrip;
}
public String getFlightClass(){
    return this.flightclass;
}
public void setFlightClass(String flightclass){
    this.flightclass = flightclass;
}
public int getSeatCount(){
    return this.seatCount;
}
public void setSeatCount(int seatCount){
    this.seatCount = seatCount;
}
public ArrayList<String> getSeatsBooked(){
    return this.seatsBooked;
}
public void setSeatsBooked(ArrayList<String> seatsBooked){
    this.seatsBooked = seatsBooked;
}
public boolean getSpecialAssisReq(){
    return this.specialAssisReq;
}
public void setSpecialAssistNeeded(boolean specialAssisReq){
    this.specialAssisReq = specialAssisReq;
}
public boolean getPets(){
    return this.pets;
}
public void setPets(boolean petsAllowed){
    this.pets = petsAllowed;
}
public double getTotalCost(){
    return this.totalCost;
}
public void setTotalCost(double totalCost){
    this.totalCost = totalCost;
}
}