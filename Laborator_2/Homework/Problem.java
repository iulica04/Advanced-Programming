package Compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * The Problem class represents a problem instance containing information about depots, clients, and vehicles.
 */
public class Problem {
    /**
     * The list of depots in the problem instance.
     */
    private List<Depot> depots;

    /**
     * The list of clients in the problem instance.
     */
    private List<Client> clients;

    /**
     * Constructs a new Problem object with empty lists of depots and clients.
     */
    Problem() {
        clients = new ArrayList<>();
        depots = new ArrayList<>();
    }

    /**
     * Gets the list of depots in the problem instance.
     *
     * @return The list of depots.
     */
    public List<Depot> getDepots() {
        return depots;
    }

    /**
     * Sets the list of depots in the problem instance.
     *
     * @param depots The list of depots to be set.
     */
    public void setDepots(List<Depot> depots) {
        for(Depot depot : depots)
        {
            if(this.depots.equals(null))
            {
                this.depots.add(depot);
            }
            else
            {
                if(!this.depots.contains(depot))
                {
                    this.depots.add(depot);
                }
                else
                {
                    System.out.println("Its not allowed to add same depot twice.");
                }
            }
        }
    }

    /**
     * Gets the list of clients in the problem instance.
     *
     * @return The list of clients.
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Sets the list of clients in the problem instance.
     *
     * @param clients The list of clients to be set.
     */
    public void setClients(List<Client> clients) {
        for(Client client : clients)
        {
            if(this.clients.equals(null))
            {
                this.clients.add(client);
            }
            else
            {
                if(!this.clients.contains(client))
                {
                    this.clients.add(client);
                }
            }
        }
    }

    /**
     * Gets an array of all vehicles available in the problem instance across all depots.
     *
     * @return An array of vehicles.
     */
    public Vehicle[] getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Depot depot : depots) {
            Vehicle[] vehicleInDepot = depot.getVehicles();
            for (Vehicle vehicle : vehicleInDepot) {
                vehicles.add(vehicle);
            }
        }
        return vehicles.toArray(new Vehicle[0]);
    }

}
