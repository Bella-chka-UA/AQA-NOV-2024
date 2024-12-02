package org.prog.cars;

import java.util.List;

public class Car {

    public String color;

    @Override
    public String toString() {
        return color + " car";
    }

    @Override
    public int hashCode() {
        //"red"+"John" => "redJohn"
        return (color).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car c = (Car) obj;
            boolean carColorsAreTheSame = this.color.equals(c.color);
            return carColorsAreTheSame;
        }
        return false;
    }


    public void goTo(String destination) {
        goTo(destination, "current location");
    }

    public void goTo(String destination, String from) {
        goTo(destination, from, "nowhere");
    }

    public void goTo(String destination, String from, String passingThrough) {
        goTo(destination, from, passingThrough, "no passengers");
    }

    public void goTo(String destination, String from, String passingThrough, String withPassenger) {
        System.out.println("Going from " + from + " to " + destination +
                " stopping at " + passingThrough + " with " + withPassenger);
    }

    public void pickUpPassenger() {

    }

    public int getColorLengthSafe() {
        if (color == null) {
            color = "";
        }
        return getColorLength();
    }

    private int getColorLength() {
        return color.length();
    }

    protected void smth() {

    }

    String someString() {
        return "abc";
    }
}
