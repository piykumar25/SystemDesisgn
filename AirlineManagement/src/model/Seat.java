package model;
import Enum.SeatCategory;
import Enum.ClassType;

public class Seat {
    public int seatNumber;
    public ClassType classType;
    public SeatCategory seatCategory;

    public Seat(int seatNumber, ClassType classType, SeatCategory seatCategory) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.seatCategory = seatCategory;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public ClassType getClassType() {
        return classType;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }
}
