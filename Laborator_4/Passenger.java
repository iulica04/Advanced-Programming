public class Passenger extends Person implements Comparable<Passenger> {
    Passenger(String name, int age, String destination)
    {
        super(name, age, destination);
    }

    public String getType()
    {
        return "Passenger";
    }

    @Override
    public int compareTo(Passenger otherPassenger) {
        // Comparăm pasagerii după nume
        return this.getName().compareTo(otherPassenger.getName());
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", " +
                "Age: " + getAge() + ", " +
                "Destination: " + getDestination() + ", " +
                "Type: passenger" + "\n";
    }
}
