import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class FlightsTest {
    private Flights flights = Flights.getInstance();
    private ArrayList<Flight> flightList = flights.getFlights();
    private Flight flight;
    
   /* @BeforeEach
    public void setup(){
        flightList.clear();
        ArrayList<String> transferAirportCodes = new ArrayList<String>();
        transferAirportCodes.add("N/A");
        ArrayList<String> economyOpenSeating = new ArrayList<String>();
        economyOpenSeating.add("A1");
        economyOpenSeating.add("A2");
        economyOpenSeating.add("A3");
        ArrayList<String> firstClassOpenSeating = new ArrayList<String>();
        firstClassOpenSeating.add("S1");
        firstClassOpenSeating.add("S2");
        firstClassOpenSeating.add("S3");
        flightList.add(new Flight(1, "Columbia SC, USA", "CAE", "Charlotte NC, USA", "CLT", "12:00pm", "01/01/2022", "01:00pm", "1hr", 0, transferAirportCodes, false, true, economyOpenSeating, 50.0, 100.0, firstClassOpenSeating, 75.0, 150.0, true));
        flightList.add(new Flight(2, "Columbia SC, USA", "CAE", "New York City NY, USA", "JFK", "12:00pm", "01/01/2022", "05:00pm", "5hr", 0, transferAirportCodes, false, false, economyOpenSeating, 75.0, 150.0, firstClassOpenSeating, 150.0, 300.0, false));
}
*/

    @Test
    void testToStringReturn(){
        ArrayList<String> transferAirportCodes = new ArrayList<String>();
        transferAirportCodes.add("N/A");
        ArrayList<String> economyOpenSeating = new ArrayList<String>();
        economyOpenSeating.add("A1");
        economyOpenSeating.add("A2");
        economyOpenSeating.add("A3");
        ArrayList<String> firstClassOpenSeating = new ArrayList<String>();
        firstClassOpenSeating.add("S1");
        firstClassOpenSeating.add("S2");
        firstClassOpenSeating.add("S3");
        flight = new Flight(1, "Columbia SC, USA", "CAE", "Charlotte NC, USA", "CLT", "12:00pm", "01/01/2022", "01:00pm", "1hr", 0, transferAirportCodes, false, true, economyOpenSeating, 50.0, 100.0, firstClassOpenSeating, 75.0, 150.0, true);
        String output = flight.toString();
        assertFalse(output.equals(""));
    }

    @Test
    void testToStringOutput(){
        ArrayList<String> transferAirportCodes = new ArrayList<String>();
        transferAirportCodes.add("N/A");
        ArrayList<String> economyOpenSeating = new ArrayList<String>();
        economyOpenSeating.add("A1");
        economyOpenSeating.add("A2");
        economyOpenSeating.add("A3");
        ArrayList<String> firstClassOpenSeating = new ArrayList<String>();
        firstClassOpenSeating.add("S1");
        firstClassOpenSeating.add("S2");
        firstClassOpenSeating.add("S3");
        flight = new Flight(2, "Columbia SC, USA", "CAE", "New York City NY, USA", "JFK", "12:00pm", "01/01/2022", "05:00pm", "5hr", 0, transferAirportCodes, false, false, economyOpenSeating, 75.0, 150.0, firstClassOpenSeating, 150.0, 300.0, false);
        String output = flight.toString();
        assertTrue(output.contains("Columbia"));
    }
}
