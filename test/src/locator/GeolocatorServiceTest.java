package locator;

import entity.Location;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class GeolocatorServiceTest {


    @Test
    public void testGeolocatorServiceManyEmpty(){

        GeolocatorService geolocatorService = new GeolocatorService();

        ArrayList<Location> locations = new ArrayList<>();

        assertEquals("Unknown area code should return empty array", locations, geolocatorService.getAllLocations("unknown"));
    }

    @Test
    public void testGeolocatorServiceOneLocation(){

        GeolocatorService geolocatorService = new GeolocatorService();

        Location location = new Location("Hilo", 19.72991,-155.09073);

        assertEquals("Locations should match first city in area code in 808", location, geolocatorService.getLocation("808"));
    }

    @Test
    public void testGeolocatorServiceManyLocations(){

        GeolocatorService geolocatorService = new GeolocatorService();


        ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location("Hilo", 19.72991,-155.09073));
        locations.add(new Location("Honolulu", 21.30694,-157.85833));
        locations.add(new Location("Kahului", 20.88953,-156.47432));
        locations.add(new Location("Kailua-Kona", 19.63927,-155.99024));
        locations.add(new Location("Kāne‘ohe", 21.39994,-157.79895));
        locations.add(new Location("\"Mililani Town\"", 21.45,-158.00111));
        locations.add(new Location("\"Pearl City\"", 21.39734,-157.97516));
        locations.add(new Location("Waimalu", 21.40472,-157.94333));
        locations.add(new Location("Waipahu", 21.38667,-158.00917));

        assertEquals("Locations should match for area code 808", locations, geolocatorService.getAllLocations("808"));
    }
    @Test
    public void testGeolocatorServiceOneEmpty(){

        GeolocatorService geolocatorService = new GeolocatorService();

        Location location = null;

        assertEquals("Unknown area code should return null location", location, geolocatorService.getLocation("unknown"));
    }

}
