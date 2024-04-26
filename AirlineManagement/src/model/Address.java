package model;

public class Address {

    public String apartments;

    public String area;

    public String landmark;

    public String city;

    public String state;

    public String country;

    public Address(String apartments, String area, String landmark, String city, String state, String country) {
        this.apartments = apartments;
        this.area = area;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address(String apartments, String area, String city, String state, String country) {
        this.apartments = apartments;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
        this.landmark = "";
    }

    public String getApartments() {
        return apartments;
    }

    public void setApartments(String apartments) {
        this.apartments = apartments;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
