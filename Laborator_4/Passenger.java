public class Passenger extends Person implements Comparable<Passenger> {

    String startLocation;

    Passenger(String name, int age, String destination, String startLocation) {
        super(name, age, destination);
        this.startLocation = startLocation;
    }

    public String getType() {
        return "Passenger";
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    @Override
    public int compareTo(Passenger otherPassenger) {
        return this.getName().compareTo(otherPassenger.getName());
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", " +
                "Age: " + getAge() + ", " +
                "Start location: " + getStartLocation() + ", " +
                "Destination: " + getDestination() + ", " +
                "Type: passenger" + "\n";
    }


}

