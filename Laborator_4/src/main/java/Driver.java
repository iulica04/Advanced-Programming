

public class Driver extends Person {
    Driver(String name, int age, String destination) {
        super(name, age, destination);
    }

    public String getType() {
        return "Drier";
    }

    public String toString() {
        String var10000 = this.getName();
        return "Name: " + var10000 + ", Age: " + this.getAge() + ", Destination: " + this.getDestination() + ", Type: driver\n";
    }
}
