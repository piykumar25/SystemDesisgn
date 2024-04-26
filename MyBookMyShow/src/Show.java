package src;

import java.util.Date;

public class Show {

    private static int idCounter = 0;

    private int id;
    private Date showTime;
    private int availableSeats;
    private Movie movie;

    private Theater theatre;

    public Show(Date showTime, Movie movie, Theater theatre) {
        idCounter += 1;
        this.id = idCounter;
        this.showTime = showTime;
        this.movie = movie;
        this.theatre = theatre;
        this.availableSeats = theatre.getCapacity();
    }

    public Ticket bookTickets(int seats, RegisteredUser user, String theatreName) throws Exception {
        if(this.availableSeats < seats) {
            throw new Exception("Seats not available");
        } else {
            Ticket ticket = new Ticket(user.getName(), new Date(), seats, theatreName);
            this.availableSeats -= seats;
            System.out.println("Ticket booked successfully");
            return ticket;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheatre() {
        return theatre;
    }

    public void setTheatre(Theater theatre) {
        this.theatre = theatre;
    }
}
