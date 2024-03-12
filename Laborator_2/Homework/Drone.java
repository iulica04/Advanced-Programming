package Compulsory;

import java.time.LocalTime;

/**
 * The Drone class represents a type of vehicle known as a drone, extending the Vehicle class.
 */
public class Drone extends Vehicle {
    /**
     * The duration of the drone's flight.
     */
    private LocalTime duration;

    /**
     * Constructs a new Drone object with the specified model, depot, and duration.
     *
     * @param vehicleModel The model of the drone.
     * @param depot        The depot associated with the drone.
     * @param duration     The duration of the drone's flight.
     */
    Drone(String vehicleModel, Depot depot, LocalTime duration) {
        super(vehicleModel, depot);
        this.duration = duration;
    }

    /**
     * Constructs a new Drone object with default values.
     * The duration is set to 0 by default.
     */
    Drone() {
        this.duration = LocalTime.of(0, 0);
    }

    /**
     * Gets the type of vehicle.
     * Overrides the superclass method to return the specific type of vehicle, which is "drone".
     *
     * @return A string representing the type of vehicle, which is "drone".
     */
    @Override
    public String getVehicleType() {
        return "drone";
    }

    /**
     * Gets the duration of the drone's flight.
     *
     * @return The duration of the drone's flight.
     */
    public LocalTime getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the drone's flight.
     *
     * @param duration The duration of the drone's flight.
     */
    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
