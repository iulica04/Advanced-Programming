package Compulsory;
import java.util.ArrayList;
import java.util.List;
public class Vehicle {
    private String vehicleModel;
    private Depot depot;
    Vehicle() {

    }

    Vehicle(String vehicleModel, Depot depot) {
        this.vehicleModel = vehicleModel;
        this.depot = depot;
    }

    public String getVehicleModel()
    {
        return vehicleModel;
    }

    public Depot getDepot()
    {
        return depot;
    }

    public void setVehicleModel(String vehicleModel)
    {
        this.vehicleModel = vehicleModel;
    }

    public void setDepot(Depot depot)
    {
        this.depot = depot;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleModel='" + vehicleModel + '\'' +
                ", depot=" + depot.getDepotName() + "}";
    }

}
