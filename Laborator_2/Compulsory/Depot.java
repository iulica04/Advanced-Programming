package Compulsory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Depot {
    private String depotName;
    private List<Vehicle> vehiclesInDepot;
    Depot(){

    }
    Depot(String depotName) {

        this.depotName = depotName;
        vehiclesInDepot = new ArrayList<>();
    }
    public String getDepotName() {
        return depotName;
    }
    public Vehicle[] getVehicle()
    {
        return vehiclesInDepot.toArray(new Vehicle[0]);
    }

    public void setVehicles(Vehicle... vehicles) {
        for(Vehicle v : vehicles) {
            vehiclesInDepot.add(v);
        }
    }


    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }


    @Override
    public String toString() {
        return "Depot{" +
                "depotName='" + depotName + '\'' +
                ", vehiclesInDepot=" + Arrays.toString(vehiclesInDepot.toArray()) +
                '}';
    }
}
