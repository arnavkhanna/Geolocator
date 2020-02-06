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
        CSVReader csvReader = new CSVReader();
        cityMap = csvReader.readFile();
    }

    /**
     * returns all locations with the given area code
     *
     * @param areaCode
     * @return
     */
    public List<Location> getAllLocations(String areaCode) {

        ArrayList<City> cityList = cityMap.get(areaCode);

        ArrayList<Location> locationList = new ArrayList<>();

        if (cityList != null) {
            for (City city : cityList) {
                locationList.add(city.getLocation());
            }
        }
        return locationList;
    }

    /**
     * returns the first location with the area code
     *
     * @param areaCode
     * @return
     */
    public Location getLocation(String areaCode) {
        if (cityMap.get(areaCode) != null) {
            return cityMap.get(areaCode).get(0).getLocation();
        } else {
            return null;
        }
    }

}
