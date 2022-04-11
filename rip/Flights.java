import java.util.ArrayList;

public class Flights{
    private static Flights flights;
    private ArrayList<Flight> flightList;

private Flights(){
    flightList = DataLoader.getFlights();
}

public static Flights getInstance(){
    if(flights == null){
        flights = new Flights();
    }
    return flights;
}
public ArrayList<Flight> getFlight(String from, String to , boolean layover){
    ArrayList<Flight> results = new ArrayList<Flight>();
    for(Flight flight: flightList){
        if(flight.getTakeoffLocation().equalsIgnoreCase(from) &&
            flight.getDestinationLocation().equalsIgnoreCase(to) &&
                (flight.getLayover() == layover)){
            results.add(flight);
        }
    }
    return results;
}
public ArrayList<Flight> getFlights(){
    return flightList;
}
}