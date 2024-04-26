package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import Enum.ClassType;
import Enum.SeatCategory;

public class AirLineBookingSystem {

    private final ArrayList<Airport> airports;
    private final ArrayList<Flight> flights;

    private HashMap<String, ArrayList<Flight>> flightMap;

    public AirLineBookingSystem(ArrayList<Airport> airports, ArrayList<Flight> flights) {
        this.airports = airports;
        this.flights = flights;
        this.flightMap = new HashMap<>();

        generateFlightMap();
    }

    private void generateFlightMap() {
        for (Flight flight : this.flights) {
            if (flightMap.containsKey(flight.getDestination())) {
                this.flightMap.get(flight.getDestination()).add(flight);
            } else {
                ArrayList<Flight> flightList = new ArrayList<>();
                flightList.add(flight);
                this.flightMap.put(flight.getDestination(), flightList);
            }
        }
    }

    // Customer can search for flights
    public ArrayList<Flight> searchFlight(String destination) throws Exception {
        if(this.flightMap.containsKey(destination)) {
            return this.flightMap.get(destination);
        } else {
            throw new Exception("No flights available for destination " + destination);
        }
    }

    public Reservation bookFlight(LocalDateTime creationDate, Flight flight,
    Seat seats, Airport destinationAirport, Airport sourceAirport,
    Customer customer, int numberOfSeats) throws Exception {
        if(numberOfSeats > flight.getAirCraft().getSeats()) {
            throw new Exception("Not enough seats available");
        }
        int remainingSeats = flight.getAirCraft().getSeats() - numberOfSeats;
        flight.getAirCraft().setSeats(remainingSeats);

        return new Reservation(creationDate, flight, seats, destinationAirport, sourceAirport, customer);
    }

    public static void main(String[] args) throws Exception {
        // Address data

        Address harshAddress = new Address("123 Main St", "New York", "NY", "KA", "India");
        Address goaAirportAddress = new Address("123 Main St", "Goa", "GA", "Goa", "India");
        Address delhiAirportAddress = new Address("123 Main St", "Delhi", "DL", "Delhi", "India");
        Address staffMemberAddress = new Address("123 Main St", "New York", "NY", "Bihar", "India");

        // Passport data
        Passport harshPassport = new Passport("239999", "1234567890", harshAddress,"21/10/2030");
        Passport bobPassport = new Passport("888888", "1234567890", staffMemberAddress,"21/10/2040");

        // User and Staff data
        Customer harsh = new Customer("1", "Harsh","12345",  "Harsh@gmail.com", "111111111", harshPassport);
        Staff bob = new Staff("2", "Bob","12345",  "Bob@gmail.com", "111111111", bobPassport);

        // AirCraft data
        AirCraft indigo = new AirCraft("Indigo", "2", "2020", 30);
        AirCraft airIndia = new AirCraft("Air India", "23", "2024", 25);

        // Airport data
        Airport goaAirport = new Airport(1, goaAirportAddress, "Goa Airport");
        Airport delhiAirport = new Airport(2, delhiAirportAddress, "Delhi Airport");

        delhiAirport.addAirCraft(indigo);
        goaAirport.addAirCraft(airIndia);

        // Flight data
        LocalDateTime arrival1 = LocalDateTime.of(2023, 4, 10, 9, 50, 40);
        LocalDateTime departure1 = LocalDateTime.of(2023, 4, 10, 8, 50, 40);
        LocalDateTime arrival2 = LocalDateTime.of(2023, 4, 10, 9, 50, 40);
        LocalDateTime departure2 = LocalDateTime.of(2023, 4, 10, 8, 50, 40);

        Flight delhiToGoaFlight = new Flight(departure1, arrival1, new Timer("120"), "Delhi", "Goa", indigo);
        Flight goaToDelhiFlight = new Flight(departure2, arrival2, new Timer("120"), "Goa", "Delhi", airIndia);

        ArrayList<Flight> flightList = new ArrayList<>();
        flightList.add(delhiToGoaFlight);
        flightList.add(goaToDelhiFlight);

        ArrayList<Airport> airportList = new ArrayList<>();
        airportList.add(delhiAirport);
        airportList.add(goaAirport);

        // AircraftMangementSystem
        AirLineBookingSystem airLineBookingSystem = new AirLineBookingSystem(airportList, flightList);

        // Search a flight
        try {
            ArrayList<Flight> searchFlight = airLineBookingSystem.searchFlight("Goa");
            System.out.println("searchFlight: " + searchFlight);
        } catch (Exception e) {
            System.out.println("No Flights available");
        }

        // Book a flight
        try {
            Reservation harshReservation = airLineBookingSystem.bookFlight(LocalDateTime.now(), delhiToGoaFlight,
                    new Seat(5, ClassType.BusinessClass, SeatCategory.ACCESSIBLE),
                    goaAirport, delhiAirport, harsh, 5);
            System.out.println("Flight booked successfully");
            System.out.println("harshReservation: " + harshReservation);
        } catch (Exception e) {
            System.out.println("No Seats available");
        }

    }
}
