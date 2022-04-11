import java.util.ArrayList;

public class Hotels{
    private static Hotels hotels;
    private ArrayList<Hotel> hotelList;

private Hotels(){
    hotelList = DataLoader.getHotels();
}

public static Hotels getInstance(){
    if(hotels == null){
        hotels = new Hotels();
    }
    return hotels;
}
public ArrayList<Hotel> getHotel(String location){
        ArrayList<Hotel> results = new ArrayList<Hotel>();
        for(Hotel hotel: hotelList){
            if(hotel.getLocation().equalsIgnoreCase(location));
                results.add(hotel);
        }
    return results;
}
public ArrayList<Hotel> getHotels(){
    return hotelList;
}
}