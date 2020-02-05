package locator;

import entity.City;
import entity.Location;
import files.CSVReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GeolocatorService {
    private HashMap<String, ArrayList<City>> cityMap;

    public GeolocatorService() {
        cityMap =  CSVReader.readFile();
    }

    /**
     *returns all locations with the given area code
     * @param areaCode
     * @return
     */
    public ArrayList<Location> getAllLocations(String areaCode){
        ArrayList<City> cityList = cityMap.get(areaCode);
        ArrayList<Location> locationList = new ArrayList<Location>();
        for(City city:cityList){
            locationList.add(city.getLocation());
        }
        return locationList;
    }

    /**
     * returns the first location with the area code
     * @param areaCode
     * @return
     */
    public Location getLocation(String areaCode){
        return cityMap.get(areaCode).get(0).getLocation();
    }

}
