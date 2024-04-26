package src;

import java.util.Date;

public class Ticket {

    private static int idCounter = 0;

    private int id;
    private String ownerName;
    private Date bookingTime;
    private String theater;
    private int noOfSeats;
    private Show bookedShow;

    public Ticket(String ownerName, Date bookingTime, int noOfSeats, String theater) {
        idCounter += 1;
        this.id = idCounter;
        this.ownerName = ownerName;
        this.bookingTime = bookingTime;
        this.theater = theater;
        this.noOfSeats = noOfSeats;
    }

    public String getTicketInfo() {
        return "Ticket booked for: " + this.ownerName + "Number of seats booked: " + this.noOfSeats
                + " in Theater: " + this.theater;
    }

    public int cancelTicket() {
        this.theater = null;
        this.noOfSeats = 0;
        this.ownerName = null;

        System.out.println("Ticket got cancelled successfully");
        return this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Show getBookedShow() {
        return bookedShow;
    }

    public void setBookedShow(Show bookedShow) {
        this.bookedShow = bookedShow;
    }
}
