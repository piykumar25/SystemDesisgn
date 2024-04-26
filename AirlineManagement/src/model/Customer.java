package model;

public class Customer extends Account {

    public Boolean frequentFlyer;


    public Customer(String id, String name, String password, String email, String phone, Passport passport) {
        super(id, name, password, email, phone, passport);
    }

    public Customer(String id, String name, String password, String email, String phone, Passport passport, Boolean frequentFlyer) {
        super(id, name, password, email, phone, passport);
        this.frequentFlyer = frequentFlyer;
    }
}
