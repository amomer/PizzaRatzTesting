import java.util.ArrayList;
public class Flight{
    private int flightID;
    private String takeoffLocation;
    private String takeoffCode;
    private String destinationLocation;
    private String destinationCode;
    private String takeoffTime;
    private String takeoffDate;
    private String landingTime;
    private String flightDuration;
    private int transferCount;
    private ArrayList<String> transferAirportCodes;
    private boolean layover;
    private boolean covidRestricted;
    private ArrayList<String> economyOpenSeating;
    private double costEconomyOneWay;
    private double costEconomyRoundTrip;
    private ArrayList<String> firstClassOpenSeating;
    private double costFirstClassOneWay;
    private double costFirstClassRoundTrip;
    private boolean petsAllowed;
    

    public Flight(int flightID, String takeoffLocation, String takeoffCode, String destinationLocation, String destinationCode,
            String takeoffTime, String takeoffDate, String landingTime, String flightDuration, int transferCount,
            ArrayList<String> transferAirportCodes, boolean layover, boolean covidRestricted, ArrayList<String> economyOpenSeating, double costEconomyOneWay,
            double costEconomyRoundTrip, ArrayList<String> firstClassOpenSeating, double costFirstClassOneWay,
            double costFirstClassRoundTrip, boolean petsAllowed) {
        
        this.flightID = flightID;
        this.takeoffLocation = takeoffLocation;
        this.takeoffCode = takeoffCode;
        this.destinationLocation = destinationLocation;
        this.destinationCode = destinationCode;
        this.takeoffTime = takeoffTime;
        this.takeoffDate = takeoffDate;
        this.landingTime = landingTime;
        this.flightDuration = flightDuration;
        this.transferCount = transferCount;
        this.transferAirportCodes = transferAirportCodes;
        this.layover = layover;
        this.covidRestricted = covidRestricted;
        this.economyOpenSeating = economyOpenSeating;
        this.costEconomyOneWay = costEconomyOneWay;
        this.costEconomyRoundTrip = costEconomyRoundTrip;
        this.firstClassOpenSeating = firstClassOpenSeating;
        this.costFirstClassOneWay = costFirstClassOneWay;
        this.costFirstClassRoundTrip = costFirstClassRoundTrip;
        this.petsAllowed = petsAllowed;
    }
    public int getFlightID(){
        return this.flightID;
    }
    public String getTakeoffLocation(){
        return this.takeoffLocation;
    }
    public String getTakeoffCode(){
        return this.takeoffCode;
    }
    public String getDestinationLocation(){
        return this.destinationLocation;
    }
    public String getDestinationCode(){
        return this.destinationCode;
    }
    public String getTakeoffTime(){
        return this.takeoffTime;
    }
    public String getTakeOffDate(){
        return this.takeoffDate;
    }
    public String getLandingTime(){
     return this.landingTime;
    }
    public String getDuration(){
        return this.flightDuration;
    }
    public int getTransfers(){
        return this.transferCount;
    }
    public ArrayList<String> getTransferAirports(){
        return this.transferAirportCodes;
    }
    public boolean getLayover(){
        return this.layover;
    }
    public boolean getCovidRestriction(){
        return this.covidRestricted;
    }
    public ArrayList<String> getEconoSeating(){
        return this.economyOpenSeating;
    }
    public double getEconoCost(String tripCode){
        if(tripCode.equals("OW"))
            return this.costEconomyOneWay;
        else
            return this.costEconomyRoundTrip;
    }
    public ArrayList<String> getFirstClassSeating(){
        return this.firstClassOpenSeating;
    }
    public double getFirstClassCost(String tripCode){
        if(tripCode.equals("OW"))
            return this.costFirstClassOneWay;
        else
            return this.costFirstClassRoundTrip;
    }
    public boolean getPets(){
        return this.petsAllowed;
    }  
    public String toString(){
        String ret = "Flight ID: "+this.flightID+"\nDeparts: "+this.takeoffLocation+"\nDestination: "+this.destinationLocation+"\nDuration: "+this.flightDuration+"\nTransfers "+this.transferCount+" times in : ";
        for(int i = 0; i < this.transferAirportCodes.size();i++){
            if(i == this.transferAirportCodes.size()-1)
                ret += (transferAirportCodes.get(i)); 
            else
                ret += (transferAirportCodes.get(i)+", "); 
        }
        return ret;
    }
}