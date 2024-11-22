package org.prog.homework3;

public class Plane {
    public String flightId;
    public String destination;
    public String airlines;

    @Override
    public String toString() {
        return "This plane  "+flightId+ " belongs to " + airlines+ " and is heading to "+ destination+"!";
    }


    @Override
    public int hashCode() {
        return (flightId+airlines+destination).hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Plane) {
            Plane p = (Plane) obj;
            return this.flightId.equals(p.flightId) &&
                    this.airlines.equals(p.airlines) &&
                    this.destination.equals(p.destination);
        }
        return false;
    }
}