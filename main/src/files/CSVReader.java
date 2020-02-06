package files;

import entity.City;
import entity.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVReader {


    public HashMap<String, ArrayList<City>> readFile() {

        HashMap<String, ArrayList<City>> cityMap = new HashMap<>();

        String csvFile = "us-area-code-cities.csv";

        String line;
        String cvsSplitBy = ",";


        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(csvFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] lineItems = line.split(cvsSplitBy);
                String areaCode = lineItems[0];
                String cityName = lineItems[1];
                double latitude = Double.parseDouble(lineItems[4]);
                double longitude = Double.parseDouble(lineItems[5]);
                City city = new City(new Location(cityName, latitude, longitude), areaCode);

                if (cityMap.containsKey(areaCode)) {
                    cityMap.get(areaCode).add(city);
                } else {
                    ArrayList<City> cityArrayList = new ArrayList<City>();
                    cityArrayList.add(city);
                    cityMap.put(areaCode, cityArrayList);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityMap;

    }

}


