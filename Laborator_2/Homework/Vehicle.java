package Compulsory;

import java.util.Objects;

/**
 * The Vehicle class represents a vehicle entity containing information about its model and associated depot.
 */
public abstract class Vehicle {
    /**
     * The model of the vehicle.
     */
    private String vehicleModel;

    /**
     * The depot associated with the vehicle.
     */
    private Depot depot;

    /**
     * Constructs a new Vehicle object with default values.
     */
    Vehicle() {

    }

    /**
     * Gets the type of vehicle.
     * This method should be implemented by subclasses to return the specific type of vehicle.
     *
     * @return A string representing the type of vehicle.
     */
    public abstract String getVehicleType();

    /**
     * Constructs a new Vehicle object with the specified model and depot.
     *
     * @param vehicleModel The model of the vehicle.
     * @param depot        The depot associated with the vehicle.
     */
    Vehicle(String vehicleModel, Depot depot) {
        this.vehicleModel = vehicleModel;
        this.depot = depot;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return The model of the vehicle.
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * Gets the depot associated with the vehicle.
     *
     * @return The depot associated with the vehicle.
     */
    public Depot getDepot() {
        return depot;
    }

    /**
     * Sets the model of the vehicle.
     *
     * @param vehicleModel The model of the vehicle.
     */
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     * Sets the depot associated with the vehicle.
     *
     * @param depot The depot associated with the vehicle.
     */
    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    /**
     * Returns a string representation of the Vehicle object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleModel='" + vehicleModel + '\'' +
                ", depot=" + depot.getDepotName() + "}";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * This method overrides the default equals implementation to compare
     * the current vehicle object with the specified object based on their
     * vehicleModel and depot attributes.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this vehicle is the same as the object
     *         argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleModel, vehicle.vehicleModel) && Objects.equals(depot, vehicle.depot);
    }


}
