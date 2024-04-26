package model;

import java.util.ArrayList;

public class Airport {

    private String name;

    private Address address;

    private int uniqueID;

    public ArrayList<AirCraft> flights = new ArrayList<AirCraft>();

    public Airport(int uniqueID, Address address, String name) {
        this.uniqueID = uniqueID;
        this.address = address;
        this.name = name;
    }

    public void addAirCraft(AirCraft flight) {
        flights.add(flight);
    }

    public ArrayList<AirCraft> getAirCraft() {
        return flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }


}
