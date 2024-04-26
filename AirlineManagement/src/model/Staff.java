package model;

import java.util.ArrayList;
import java.util.List;

public class Staff extends Account{

    private List<AirCraft> airCrafts;
    private List<Flight> flights;

    public Staff(String id, String name, String password, String email, String phone, Passport passport) {
        super(id, name, password, email, phone, passport);
        this.airCrafts = new ArrayList<AirCraft>();
        this.flights = new ArrayList<Flight>();
    }

    public void addAirCraft(AirCraft flight) {
        this.airCrafts.add(flight);
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
}
