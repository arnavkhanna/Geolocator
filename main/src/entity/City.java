package entity;

import java.util.Objects;

public class City { //city class
    private Location location;
    private String areaCode;

    public City(Location location, String areaCode) {//constructor
        this.location = location;
        this.areaCode = areaCode;
    }

    //accessors and mutators
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(location, city.location) &&
                Objects.equals(areaCode, city.areaCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, areaCode);
    }

    @Override
    public String toString() {
        return "City{" +
                "location=" + location +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
