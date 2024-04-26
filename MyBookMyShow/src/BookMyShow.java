package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BookMyShow {

    private ArrayList<User> users;
    private ArrayList<Theater> theaters;

    private HashMap<String, ArrayList<Show>> movieMap = new HashMap<>();

    public BookMyShow() {
        users = new ArrayList<>();
        theaters = new ArrayList<>();
        this.movieMap = new HashMap<>();
        generateMovieMap();
    }

    public BookMyShow(ArrayList<Theater> theaterArrayList) {
        this.theaters = theaterArrayList;
        generateMovieMap();
    }

    private void generateMovieMap() {
        for(Theater theater : this.theaters) {
            for(Show show : theater.getShows()) {
                if(!this.movieMap.containsKey(show.getMovie().getName())) {
                    ArrayList<Show> shows = new ArrayList<>();
                    shows.add(show);
                    this.movieMap.put(show.getMovie().getName(), shows);
                } else {
                    this.movieMap.get(show.getMovie().getName()).add(show);
                }

            }
        }

    }

    public ArrayList<Show> searchShows(String movieName) throws Exception {
        if(this.movieMap.containsKey(movieName)) {
            return this.movieMap.get(movieName);
        } else {
            throw new Exception("No shows present");
        }

    }

    public static void main(String[] args) throws ParseException {
        // Initialize all models objects
        // Create object of BookMyShow Application
        // Use it to book tickets & search for shows

        // Users
        RegisteredUser ayush = new RegisteredUser("Ayush");
        RegisteredUser saurabh = new RegisteredUser("Saurabh");
        GuestUser bob = new GuestUser("Bob");

        // Movie
        Movie ironMan = new Movie("Iron Man", Language.ENGLISH, Genre.ACTION);
        Movie avengers = new Movie("Avengers", Language.ENGLISH, Genre.ACTION);
        Movie houseFull = new Movie("House Full", Language.HINDI, Genre.COMEDY);
        Movie walkToRemember = new Movie("Walk To Remember", Language.ENGLISH, Genre.ROMANCE);

        // Theaters
        Theater pvr_gip = new Theater("PVR GIP", "Noida", 30);
        Theater big_cinema = new Theater("Big Cinema", "Gurugram", 25);

        // For time SimpleDateFormatter
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");

        // Shows
        Show ironManShow = new Show(formatter.parse("Friday, May 10, 2023 10:00:00 AM"), ironMan, pvr_gip);
        Show avengersShow = new Show(formatter.parse("Friday, Jun 10, 2023 11:00:00 PM"), avengers, big_cinema);
        Show houseFullShow = new Show(formatter.parse("Friday, May 15, 2023 09:00:00 PM"), houseFull, big_cinema);
        Show walkToRememberShow = new Show(formatter.parse("Friday, May 26, 2023 04:00:00 PM"), walkToRemember, pvr_gip);

//        ArrayList<Show> pvr_gip_shows = new ArrayList<>();
//        pvr_gip_shows.add(ironManShow);
//        pvr_gip_shows.add(walkToRememberShow);
//        pvr_gip.setShows(pvr_gip_shows);
        // BookMyShow
        ArrayList<Theater> theaterArrayList = new ArrayList<>();
        theaterArrayList.add(pvr_gip);
        theaterArrayList.add(big_cinema);

        BookMyShow bookMyShow = new BookMyShow(theaterArrayList);

        // Search for shows
        try {
           ArrayList<Show> shows = bookMyShow.searchShows("Iron Man");
           System.out.println("Shows: " + shows.get(0).getMovie().getName());
        } catch (Exception e) {
            System.out.println("No shows found");
        }

        // Book tickets
        try {
            Ticket ayushTicket = bookMyShow.bookTicket(ayush, ironManShow, 25, pvr_gip.getName());
            System.out.println(ayushTicket.getTicketInfo());
        } catch (Exception e) {
            System.out.println("Ticket Sold out");
        }

        try {
            Ticket bobTicket = bookMyShow.bookTicket(ayush, avengersShow, 25, big_cinema.getName());
            System.out.println(bobTicket.getTicketInfo());
        } catch (Exception e) {
            System.out.println("Ticket Sold out");
        }



    }

    private Ticket bookTicket(User user, Show show, int noOfSeats, String theatre) throws Exception {
        if(user instanceof RegisteredUser) {
            return show.bookTickets(noOfSeats, (RegisteredUser) user, theatre);
        } else {
            throw new Exception("Please register first to book tickets");
        }
    }
}
