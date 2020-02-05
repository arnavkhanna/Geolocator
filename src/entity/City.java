package entity;

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
    public String toString() {
        return "City{" +
                "location=" + location +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
