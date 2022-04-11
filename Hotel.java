import java.util.ArrayList;

public class Hotel {
    private int id;
    private String name;
    private String location;
    private ArrayList<Integer> singleAvailability;
    private ArrayList<Integer> smokingAvailability;
    private ArrayList<Integer> queenAvailability;
    private ArrayList<Integer> doubleAvailability;
    private double singleCost;
    private double smokingCost;
    private double queenCost;
    private double doubleCost;
    private String rating;
    private ArrayList<Amenities> amenities;

public Hotel(int id, String name , String location, ArrayList<Integer> singleAvailabillity, ArrayList<Integer> smokingAvailability, 
    ArrayList<Integer> queenAvailibilty, ArrayList<Integer> doubleAvailibilty, double singleCost, double smokingCost, 
        double queenCost, double doubleCost, String rating, ArrayList<Amenities> amenities){
            this.id = id;
            this.name=name;
            this.location = location;
            this.singleAvailability=singleAvailabillity;
            this.smokingAvailability=smokingAvailability;
            this.queenAvailability=queenAvailibilty;
            this.doubleAvailability=doubleAvailibilty;
            this.singleCost=singleCost;
            this.smokingCost=smokingCost;
            this.queenCost=queenCost;
            this.doubleCost=doubleCost;
            this.rating = rating;
            this.amenities=amenities;

}
public int getID(){
    return this.id;
}
public String getName(){
    return this.name;
}
public String getLocation(){
    return this.location;
}
public ArrayList<Integer> getSingleAvailability(){
    return this.singleAvailability;
}
public ArrayList<Integer> getSmokingAvailability(){
    return this.smokingAvailability;
}
public ArrayList<Integer> getQueenAvailability(){
    return this.queenAvailability;
}
public ArrayList<Integer> getDoubleAvailability(){
    return this.doubleAvailability;
}
public double getSingleCost(){
    return this.singleCost;
}
public double getSmokingCost(){
    return this.smokingCost;
}
public double getQueenCost(){
    return this.queenCost;
}
public double getDoubleCost(){
    return this.doubleCost;
}
public String getRating(){
    return this.rating;
}
public ArrayList<Amenities> getAmenities(){
    return this.amenities;
}
public String toString(){
    String retString = " ";
     retString = ("Hotel Name: "+this.name+"\nAmenities: ");
        if(this.amenities.contains(Amenities.POOL))
            retString += ("\npool");
        if(this.amenities.contains(Amenities.GYM))
            retString += ("\ngym");
        if(this.amenities.contains(Amenities.FREE_BREAKFAST))
            retString += ("\nBreakfast included");
        if(this.amenities.contains(Amenities.FREE_PARKING))
            retString += ("\nParking included");
        if(this.amenities.contains(Amenities.ROOM_APPLIANCES))
            retString += ("\n In-room appliances");
        retString += "\nRating: "+this.rating;
        
        return retString;

        

}
}