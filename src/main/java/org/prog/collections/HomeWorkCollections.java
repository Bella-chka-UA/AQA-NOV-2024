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
        Map<Car, Set<Owner>> carsAndOwners = new HashMap<>();


        addOwnersToCar(carsAndOwners, Set.of("Jane","Bill"),"Car 1");
        addOwnersToCar(carsAndOwners, Set.of("Jane"),"Car 2");
        addOwnersToCar(carsAndOwners, Set.of("Jane"),"Car 3");
        addOwnersToCar(carsAndOwners, Set.of("John", "Sarah"),"Car 4");
        addOwnersToCar(carsAndOwners, Set.of("Bill", "Sarah"),"Car 5");

        printRepetitiveCars(carsAndOwners);
    }

    public static void addOwnersToCar (Map<Car, Set<Owner>> ownersAndCar, Set<String> names, String nameCar) {
        Car car = new Car();
        car.color = "White" ;
        car.name = nameCar;
        var owners = new HashSet<Owner>();
        for (String nameOwner : names) {
            Owner owner = new Owner();
            owner.name = nameOwner;
            owners.add(owner);
        }
        ownersAndCar.put(car, owners);
    }

    public static void printRepetitiveCars (Map<Car, Set<Owner>> ownersAndCar) {
        Iterator<Map.Entry<Car, Set<Owner>>> iterator =
                ownersAndCar.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Car, Set<Owner>> entry = iterator.next();
            Car car = entry.getKey();
            Set<Owner> owners = entry.getValue();
            if (owners.size()>1){
                System.out.print(car.name+": ");
                for (Owner owner : owners) {
                    System.out.print(owner.name + " ");

                }
                System.out.println();
            }
            }


    }
}
