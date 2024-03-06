package Compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tour {
    private Vehicle vehicle;
    private  List<Client> clients;

    Tour()
    {
        clients = new ArrayList<>();
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public Client[] getClients()
    {
        return clients.toArray(new Client[0]);
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    public void setClients(Client...clients)
    {
        for(Client client : clients)
        {
            this.clients.add(client);
        }
    }

    @Override
    public String toString() {
        return "Tour{" +
                "vehicle=" + vehicle +
                ", clients=" + Arrays.toString(clients.toArray()) +
                '}';
    }
}
