import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HotelTest {
    private Hotel hotel;

    @Test 
      void testIfToStringEmpty(){
          ArrayList<Integer> roomsOpen = new ArrayList<Integer>();
          roomsOpen.add(101);
          roomsOpen.add(102);
          roomsOpen.add(103);
          ArrayList<Amenities> hotelAmenitites= new ArrayList<Amenities>();
          hotelAmenitites.add(Amenities.GYM);
          hotel=new Hotel(1,"Hoovile", "Louieville",roomsOpen, roomsOpen, roomsOpen, roomsOpen, 1.0, 1.0, 1.0, 1.0, "3 stars", hotelAmenitites);
          String output = hotel.toString();
          assertFalse(output.equals(""));
      }

      @Test 
      void testIfAllAmenitiesPresent(){
          ArrayList<Integer> roomsOpen = new ArrayList<Integer>();
          roomsOpen.add(101);
          roomsOpen.add(102);
          roomsOpen.add(103);
          ArrayList<Amenities> hotelAmenitites= new ArrayList<Amenities>();
          hotelAmenitites.add(Amenities.GYM);
          hotelAmenitites.add(Amenities.FREE_BREAKFAST);
          hotelAmenitites.add(Amenities.FREE_PARKING);
          hotelAmenitites.add(Amenities.POOL);
          hotelAmenitites.add(Amenities.ROOM_APPLIANCES);
          hotel=new Hotel(1,"Hoovile", "Louieville",roomsOpen, roomsOpen, roomsOpen, roomsOpen, 1.0, 1.0, 1.0, 1.0, "3 stars", hotelAmenitites);
          String output = hotel.toString();
          assertTrue(output.contains("pool") && output.contains("gym")&& output.contains("Breakfast included")&& output.contains("Parking included")&& output.contains("In-room appliances"));
      }
      @Test 
      void testRating(){
          ArrayList<Integer> roomsOpen = new ArrayList<Integer>();
          roomsOpen.add(101);
          roomsOpen.add(102);
          roomsOpen.add(103);
          ArrayList<Amenities> hotelAmenitites= new ArrayList<Amenities>();
          hotelAmenitites.add(Amenities.GYM);
          hotel=new Hotel(1,"Hoovile", "Louieville",roomsOpen, roomsOpen, roomsOpen, roomsOpen, 1.0, 1.0, 1.0, 1.0, "4 stars", hotelAmenitites);
          String output = hotel.toString();
          assertTrue(output.contains("4 stars"));
      }
      

    



    
}
