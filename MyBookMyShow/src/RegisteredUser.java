package src;

import java.util.ArrayList;

public class RegisteredUser extends User {

    private boolean isLoggedIn;
    private ArrayList<Ticket> bookingHistory;

    public RegisteredUser(String name) {
        super(name);
        this.bookingHistory = new ArrayList<>();
        isLoggedIn = false;
    }

    public void login(String name, String pwd) {
        // Check on backend
        isLoggedIn = true;
    }
}
