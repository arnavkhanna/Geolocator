package files;

import entity.City;
import entity.Location;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVReader {


    public static HashMap readFile() { //reads csv file
        HashMap<String, ArrayList<City>> cityMap
                = new HashMap<>();
            String csvFile = "src//files//us-area-code-cities.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";

            try {

                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] lineItems = line.split(cvsSplitBy);
                    String areaCode = lineItems[0];
                    String cityName = lineItems[1];
                    double latitude = Double.parseDouble(lineItems[4]);
                    double longitude = Double.parseDouble(lineItems[5]);
                    City city = new City(new Location(cityName,latitude,longitude),areaCode);

                    if(cityMap.containsKey(areaCode)){
                        cityMap.get(areaCode).add(city);
                    }
                    else {
                        ArrayList<City> cityArrayList = new ArrayList<City>();
                        cityArrayList.add(city);
                        cityMap.put(areaCode,cityArrayList);
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return cityMap;

        }

    }


