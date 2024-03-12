package Compulsory;

/**
 * The Truck class represents a type of vehicle known as a truck, extending the Vehicle class.
 */
public class Truck extends Vehicle {
    /**
     * The capacity of the truck.
     */
    private int capacity;

    /**
     * Constructs a new Truck object with the specified model, depot, and capacity.
     *
     * @param vehicleModel The model of the truck.
     * @param depot        The depot associated with the truck.
     * @param capacity     The capacity of the truck.
     */
    Truck(String vehicleModel, Depot depot, int capacity) {
        super(vehicleModel, depot);
        this.capacity = capacity;
    }

    /**
     * Constructs a new Truck object with default values.
     * The capacity is set to 0 by default.
     */
    Truck() {
        this.capacity = 0;
    }

    /**
     * Gets the type of vehicle.
     * Overrides the superclass method to return the specific type of vehicle, which is "truck".
     *
     * @return A string representing the type of vehicle, which is "truck".
     */
    @Override
    public String getVehicleType() {
        return "truck";
    }

    /**
     * Gets the capacity of the truck.
     *
     * @return The capacity of the truck.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the truck.
     *
     * @param capacity The capacity of the truck.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
