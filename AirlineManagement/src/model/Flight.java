package model;

import java.time.LocalDateTime;
import java.util.Timer;

public class Flight {

    public LocalDateTime departure;
    public LocalDateTime arrival;
    public Timer duration;
    public String origin;

    public String destination;
    public AirCraft airCraft;

    public Flight(LocalDateTime departure, LocalDateTime arrival,
                  Timer duration, String origin, String destination, AirCraft airCraft) {
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
        this.origin = origin;
        this.destination = destination;
        this.airCraft = airCraft;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public Timer getDuration() {
        return duration;
    }

    public void setDuration(Timer duration) {
        this.duration = duration;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }
}
