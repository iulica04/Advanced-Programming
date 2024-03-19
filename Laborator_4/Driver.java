public class Driver extends Person {
    Driver(String name, int age, String destination {
        super(name, age, destination);
    }

    public String getType() {
        return "Drier";
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", " +
                "Age: " + getAge() + ", " +
                "Destination: " + getDestination() + ", " +
                "Type: driver" + "\n";
    }
}
