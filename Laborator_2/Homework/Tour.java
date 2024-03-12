package Compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Tour class represents a tour entity containing information about the vehicle and a list of clients.
 */
public class Tour {
    /**
     * The vehicle associated with the tour.
     */
    private Vehicle vehicle;

    /**
     * The list of clients included in the tour.
     */
    private List<Client> clients;

    /**
     * Constructs a new Tour object with an empty list of clients.
     */
    Tour() {
        clients = new ArrayList<>();
    }

    /**
     * Gets the vehicle associated with the tour.
     *
     * @return The vehicle.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Gets the array of clients included in the tour.
     *
     * @return An array of clients.
     */
    public Client[] getClients() {
        return clients.toArray(new Client[0]);
    }

    /**
     * Sets the vehicle associated with the tour.
     *
     * @param vehicle The vehicle.
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Sets the clients included in the tour.
     *
     * @param clients An array of clients to be added to the tour.
     */
    public void setClients(Client... clients) {
        this.clients.addAll(Arrays.asList(clients));
    }

    /**
     * Returns a string representation of the Tour object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Tour{" +
                "vehicle=" + vehicle +
                ", clients=" + Arrays.toString(clients.toArray()) +
                '}';
    }
}
