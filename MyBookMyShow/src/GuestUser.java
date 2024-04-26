package src;

public class GuestUser extends User{

    private boolean isRegistered;

    public GuestUser(String name) {
        super(name);
        isRegistered = false;
    }

    public void register(String name, String email, String pwd) {
        // logic to register user
        isRegistered = true;
    }
}


