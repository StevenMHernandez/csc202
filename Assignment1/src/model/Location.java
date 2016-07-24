package model;

public class Location implements Comparable<Location> {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public int compareTo(Location location) {
        if (this.latitude != location.latitude) {
            return this.latitude > location.latitude ? 1 : -1;
        }
        if (this.longitude != location.longitude) {
            return this.longitude > location.longitude ? 1 : -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
