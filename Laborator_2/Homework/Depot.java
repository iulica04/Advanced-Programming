package Compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The Depot class represents a depot entity containing information about its name and vehicles stored in it.
 */
public class Depot {
    /**
     * The name of the depot.
     */
    private String depotName;

    /**
     * The list of vehicles stored in the depot.
     */
    private List<Vehicle> vehiclesInDepot;

    /**
     * Constructs a new Depot object with an empty list of vehicles.
     */
    Depot() {

    }

    /**
     * Constructs a new Depot object with the specified depot name.
     *
     * @param depotName The name of the depot.
     */
    Depot(String depotName) {
        this.depotName = depotName;
        vehiclesInDepot = new ArrayList<>();
    }

    /**
     * Gets the name of the depot.
     *
     * @return The name of the depot.
     */
    public String getDepotName() {
        return depotName;
    }

    /**
     * Gets the array of vehicles stored in the depot.
     *
     * @return An array of vehicles.
     */
    public Vehicle[] getVehicles() {
        return vehiclesInDepot.toArray(new Vehicle[0]);
    }

    /**
     * Sets the vehicles stored in the depot.
     *
     * @param
     * ehicles An array of vehicles to be added to the depot.
     */
    public void setVehicles(Vehicle... vehicles) {
        vehiclesInDepot.addAll(Arrays.asList(vehicles));
    }

    /**
     * Sets the name of the depot.
     *
     * @param depotName The name of the depot.
     */
    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    /**
     * Returns a string representation of the Depot object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Depot{" +
                "depotName='" + depotName + '\'' +
                ", vehiclesInDepot=" + Arrays.toString(vehiclesInDepot.toArray()) +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * This method overrides the default equals implementation to compare
     * the current depot object with the specified object based on their
     * depotName and vehiclesInDepot attributes.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this depot is the same as the object
     *         argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(depotName, depot.depotName) && Objects.equals(vehiclesInDepot, depot.vehiclesInDepot);
    }

}
