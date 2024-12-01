package org.prog.collections;

//TODO:
// - each car can have several owners
// - owners can have several cars
// - list cars belonging to specific owner

import org.prog.cars.Car;

import java.util.*;

public class CollectionsDemo {

    //TODO: Homework 1: add owners list ad parameter for addCarToCompany;
    //TODO*: Do only if you want! Make owners random! WARNING: make list of owners to pick from

    public static void main(String[] args) {
        Map<Car, List<String>> carsAndOwners = new HashMap<>();
        ArrayList<String> owners = new ArrayList<String>();
        owners.add("John");
        owners.add("Jane");
        owners.add("Bill");
        owners.add("Sarah");

        addCarToCompany(carsAndOwners, "black", owners);
        addCarToCompany(carsAndOwners, "white", owners);
        addCarToCompany(carsAndOwners, "red" , owners);
        addCarToCompany(carsAndOwners, "blue", owners);

        String requestedOwnerName = "Bill";

        Set<Car> carsOwnedBySpecificPerson = findCars(carsAndOwners, requestedOwnerName);

        for (Car c : carsOwnedBySpecificPerson) {
            System.out.println( requestedOwnerName + " has " + c);

        }
    }

    public static void addCarToCompany(Map<Car, List<String>> carsAndOwners,
                                       String color, ArrayList<String> owners) {
        Car car = new Car();
        car.color = color;
        car.name = "Car";
        Random random = new Random();
        ArrayList<String> randomOwners = new ArrayList<>();
        for (int i=0; i<= random.nextInt(0, owners.size());i++) {
            var randomOwner = owners.get(random.nextInt(0, owners.size()));
            if (randomOwners.contains(randomOwner)) {
            i--;
            continue;
            }
            randomOwners.add(randomOwner);
            carsAndOwners.put(car, randomOwners);
            System.out.println("Company randomly give " + randomOwner + " " + car);
        }
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
