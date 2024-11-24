package org.prog.collections;

//TODO:
// - each car can have several owners
// - owners can have several cars
// - list cars belonging to specific owner

import org.prog.cars.Car;

import java.util.*;

public class CollectionsDemo {

    //TODO: Homework 1: add owners list ad parameter for addCarToCompany;
    //TODO*: Do only if you want! Make owners random! WARNING: make list of owers to pick from

    public static void main(String[] args) {
        Map<Car, List<String>> carsAndOwners = new HashMap<>();
        addCarToCompany(carsAndOwners, "black");
        addCarToCompany(carsAndOwners, "white");
        addCarToCompany(carsAndOwners, "red");
        addCarToCompany(carsAndOwners, "blue");

        String requestedOwnerName = "John";
        Set<Car> carsOwnedBySpecificPerson = findCars(carsAndOwners, requestedOwnerName);

        for (Car c : carsOwnedBySpecificPerson) {
            System.out.println(c);
        }
    }

    public static void addCarToCompany(Map<Car, List<String>> carsAndOwners,
                                       String color) {
        Car car = new Car();
        car.color = color;
        carsAndOwners.put(car, new ArrayList<>());
        carsAndOwners.get(car).add("John");
        carsAndOwners.get(car).add("Jane");
    }

    public static Set<Car> findCars(Map<Car, List<String>> carsAndOwners, String requestedOwnerName) {
        Set<Car> carsOwnedBySpecificPerson = new HashSet<>();
        Iterator<Map.Entry<Car, List<String>>> iterator =
                carsAndOwners.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Car, List<String>> entry = iterator.next();
            Car carrUnderInspection = entry.getKey();
            List<String> owners = entry.getValue();
            if (owners.contains(requestedOwnerName)) {
                carsOwnedBySpecificPerson.add(carrUnderInspection);
            }
        }

        return carsOwnedBySpecificPerson;
    }
}
