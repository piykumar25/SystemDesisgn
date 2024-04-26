package model;

import java.time.LocalDateTime;
public class Reservation {

    private static int idCounter = 0;

    public LocalDateTime creationDate;

    public String reservationNumber;

    public Flight flight;

    public Seat seats;

    public Airport destinationAirport;

    public Airport sourceAirport;

    public Customer customer;

    public Reservation(LocalDateTime creationDate, Flight flight,
                       Seat seats, Airport destinationAirport, Airport sourceAirport,
                       Customer customer) {
        idCounter++;
        this.reservationNumber = String.valueOf(idCounter);
        this.creationDate = creationDate;
        this.flight = flight;
        this.seats = seats;
        this.destinationAirport = destinationAirport;
        this.sourceAirport = sourceAirport;
        this.customer = customer;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeats() {
        return seats;
    }
}
