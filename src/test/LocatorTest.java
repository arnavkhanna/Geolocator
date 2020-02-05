package test;

import locator.GeolocatorService;

public class LocatorTest {//tester class
    public static void main(String[] args){
        GeolocatorService geolocatorService = new GeolocatorService();

        System.out.println(geolocatorService.getAllLocations("808"));
        System.out.println(geolocatorService.getLocation("808"));
    }
}
