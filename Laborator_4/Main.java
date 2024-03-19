import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String args[])
    {
        /**
         * Create a random group of persons. Use streams in order to filter the drivers and the passengers.
         * Put all the drivers in a LinkedList and print them sorted by their age.
         * Put all the passengers in a TreeSet and print them sorted by their name.*/

       // var persons = IntStream.rangeClosed(0, 5).mapToObj(i -> new Person("Person"+i, (int)Math.random() * 50 + 10, "Destination"+i)).toArray(Person[]::new);

        List<Person> persons = IntStream.rangeClosed(0, 5).mapToObj(i->{
            if(i%2 == 0)
            {
                return new Driver("Driver"+i,(int)(Math.random() * 41 + 10)+10,"Destination" + i % 3+1);
            }
            else
            {
                return new Passenger("Passenger"+i, (int)(Math.random() * 41) + 10,"Destination" + (i % 3+1));
            }
        }).toList();

        LinkedList<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toCollection(LinkedList :: new));

        Set<Passenger> passengers = persons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(drivers.toString());
        System.out.println(passengers.toString());

    }
}
