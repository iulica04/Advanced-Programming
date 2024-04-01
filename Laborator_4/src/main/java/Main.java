
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int personsNumber = rand.nextInt(11) + 30;
        int driversNumber = rand.nextInt(10) + 6; // intre 6 si 16 soferii

        System.out.println("Number of persons: " + personsNumber);
        System.out.println("Number of drivers: " + driversNumber);

        Faker fake = new Faker();

        List<String> driversDestination = new ArrayList<>();
        for (int i = 1; i <= driversNumber; i++) {
            driversDestination.add(fake.address().cityName());
        }


        List<Person> persons = IntStream.rangeClosed(0, personsNumber).mapToObj(i -> {
            if (i < driversNumber) {
                return new Driver(fake.name().fullName(), (int) (Math.random() * 41 + 10) + 10, driversDestination.get(i));
            } else {
                int randomForStartLocation = rand.nextInt(driversNumber);
                int random = rand.nextInt(driversNumber / 4); // o marja ca sa nu avem locatia de start egala cu destinatia finala
                int randomForDestination = rand.nextInt(driversNumber - random);
                return new Passenger(fake.name().fullName(), (int) (Math.random() * 41) + 10, driversDestination.get(randomForStartLocation), driversDestination.get(randomForDestination));
            }
        }).toList();

        List<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));

        Set<Passenger> passengers = persons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(drivers.toString());
        System.out.println(passengers.toString());

        //---------------------------------------------------------------------

        Problem problem = new Problem(drivers, passengers);
        problem.algGreedy();

    }
}
