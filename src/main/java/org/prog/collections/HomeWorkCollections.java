package org.prog.collections;

//TODO: Write code where single car be owned by multiple unique owners
//TODO: some cars can have multiple owners
//TODO: print owner names for all owners that share cars

// > Jane : Car1, Car2, Car3
// > John : Car4
// > Bill: Car1, Car5
// > Sarah : Car4
// > ...
// > ...

import org.prog.cars.Car;

import java.util.*;

// >>>> Car1: Jane, Bill
// >>>> Car4: John, Sarah
public class HomeWorkCollections {
    public static void main(String[] args) {
        Map<Owner, List<String>> ownersAndCar = new HashMap<>();
        String requestedCar = "Car 1";
        Set<Owner> ownersOfSpecificCars = findsOwner(ownersAndCar, requestedCar);
        addOwnersToCompany(ownersAndCar);
        addOwnersToCompany(ownersAndCar);
        addOwnersToCompany(ownersAndCar);
        addOwnersToCompany(ownersAndCar);

        for (Owner owner : ownersOfSpecificCars) {
            System.out.println(owner);
        }
    }

    public static void addOwnersToCompany(Map<Owner, List<String>> ownersAndCar) {
        Owner owner = new Owner();
        ownersAndCar.put(owner, new ArrayList<>());
        ownersAndCar.get(owner).add("Jane");
        ownersAndCar.get(owner).add("John");
        ownersAndCar.get(owner).add("Bill");
    }

    public static Set<Owner> findsOwner(Map<Owner, List<String>> ownersAndCar, String requestedCar) {
        Set<Owner> ownersOfSpecificCars = new HashSet<>();
        Iterator<Map.Entry<Owner, List<String>>> iterator =
                ownersAndCar.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Owner, List<String>> entry = iterator.next();
            Owner ownerVerified = entry.getKey();
            List<String> car = entry.getValue();
            if (car.contains(requestedCar)) {
                ownersOfSpecificCars.add(ownerVerified);
            }
        }

        return ownersOfSpecificCars;
    }
}


