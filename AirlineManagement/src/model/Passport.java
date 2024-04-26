package model;

public class Passport {

    public String passportNumber;
    public String dob;
    public Address address;
    public String expiryDate;

    public Passport(String passportNumber, String dob, Address address, String expiryDate) {
        this.passportNumber = passportNumber;
        this.dob = dob;
        this.address = address;
        this.expiryDate = expiryDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
