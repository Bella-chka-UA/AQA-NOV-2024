package org.prog.homework3;

import org.prog.cars.Car;

//TODO: write class Plane with fields "flightId", "destination", "airlines"
//TODO: write hashCode and Equals (see Car)
//TODO: compare planes with null flightId and catch exception, in catch write "flight id is missing"
//TODO: in try-catch-finally add finally and print "works anyway"
public class HomeWork3 {
    public static void main(String[] args) {
        Object o = new Object();
        Plane plane1 = new Plane();
        Plane plane2 = new Plane();
        Plane plane3 = new Plane();
        Plane plane4 = new Plane();

        plane1.flightId = "IR1234";
        plane2.flightId = "IR1234";
        plane1.destination = "Hurgada";
        plane2.destination = "Hurgada";
        plane1.airlines = "Wizz Air";
        plane2.airlines = "Wizz Air";


        System.out.println(plane1.flightId.hashCode());
        System.out.println(plane2.flightId.hashCode());

        System.out.println(plane2.airlines.hashCode());
        System.out.println(plane1.airlines.hashCode());

        System.out.println(plane1.destination.hashCode());
        System.out.println(plane2.destination.hashCode());

        System.out.println(plane1.equals(plane2));
        System.out.println(plane1.hashCode());
        System.out.println(plane2.hashCode());
        System.out.println(plane1.toString());
        System.out.println(plane2.toString());
        try {
            System.out.println(plane3.equals(plane4));
        } catch (Exception e) {
            System.out.println("Flight id is missing...");
        }finally {
            System.out.println("Works anyway!!!");
        }
    }
}
