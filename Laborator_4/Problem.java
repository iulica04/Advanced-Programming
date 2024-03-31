import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    private final List<Driver> drivers;
    private final Set<Passenger> passengers;
    private final Map<Driver, List<Passenger>> matchingDriverWithPassenger;

    public Problem(List<Driver> drivers, Set<Passenger> passengers) {
        this.drivers = drivers;
        this.passengers = passengers;
        matchingDriverWithPassenger = new HashMap<>();
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public List<String> getDriverDestinations() {
        return drivers.stream()
                .map(Driver::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, List<Passenger>> getPassengersPerDestination() {
        return drivers.stream()
                .collect(Collectors.toMap(
                        Driver::getDestination,
                        driver -> passengers.stream()
                                .filter(passenger -> passenger.getDestination().equals(driver.getDestination()))
                                .collect(Collectors.toList()),
                        (existing, replacement) -> existing)); // creaza lista combinata de pasageri pentru aceiasi destinatie -> in caz ca mai multi soferi au aceiasi destinatie
    }

    public void print() {
        for (Driver driver : matchingDriverWithPassenger.keySet()) {
            System.out.println("Driver: " + driver.getName() + " ----> Passengers: " + matchingDriverWithPassenger.get(driver));
        }
    }

    public List<Passenger> isCompatible(Map<String, List<Passenger>> passengersPerDestination, String driverDestination) {

        List<Passenger> compatiblePassengers = new ArrayList<>();

        for (String destination : passengersPerDestination.keySet()) {
            if (destination.equals(driverDestination)) {
                return passengersPerDestination.get(destination);
            }
        }

        return compatiblePassengers;

    }


    public Passenger sameStartLocation(List<Passenger> compatiblePassengers, String startLocationForDriver, List<Passenger> takenPassengers) {
        for (Passenger passenger : compatiblePassengers) {
            if (passenger.getStartLocation().equals(startLocationForDriver) && !takenPassengers.contains(passenger)) {
                return passenger;
            }

        }
        return null;
    }

    public Passenger getPassengerWithLittleRide(List<Passenger> takenPassengers, int indexDriverStartLocation, int indexDriverEndLocation, List<String> destinations, Map<String, List<Passenger>> passengersPerDestination) {
        for (String destination : passengersPerDestination.keySet()) {
            if (destinations.indexOf(destination) < indexDriverEndLocation) {
                List<Passenger> passengers = passengersPerDestination.get(destination);
                for (Passenger passenger : passengers) {
                    if (destinations.indexOf(passenger.getStartLocation()) >= indexDriverStartLocation && !takenPassengers.contains(passenger) && destinations.indexOf(passenger.getStartLocation()) < destinations.indexOf(destination)) { // ori il ia fix de acolo-> ori se deplaseaza pana la el
                        return passenger;
                    }
                }
            }
        }
        return null;
    }


    public void algGreedy() {


        List<String> destinations = getDriverDestinations();
        Collections.sort(destinations);
        System.out.println("\n" + destinations);

        Map<String, List<Passenger>> passengersPerDestination = getPassengersPerDestination();

        List<Passenger> takenPassengers = new ArrayList<>();
        List<Passenger> passengersToTake = new ArrayList<>();


        for (Driver driver : drivers) {
            passengersToTake.clear();
            int indexForDriverDestination = destinations.indexOf(driver.getDestination());

            String startLocationForDriver = destinations.getFirst();
            // daca gasesc un passenger care merge pana la destinatia finala, all good -> daca nu vom cauta unul care merge la o destinatie care e in drumul destinatiei driver ului

            List<Passenger> compatiblePassengers = isCompatible(passengersPerDestination, driver.getDestination());


            while (!startLocationForDriver.equals(driver.getDestination())) {
                Passenger passengerToTake = sameStartLocation(compatiblePassengers, startLocationForDriver, takenPassengers); // pasagerul care merge lacelasi treaseu ca driverul

                if (compatiblePassengers.isEmpty()) {
                    // cazul in care nu se gasesc pasageri care nu merg pana la destinatia finala a driverului

                    passengerToTake = getPassengerWithLittleRide(takenPassengers, destinations.indexOf(startLocationForDriver), indexForDriverDestination, destinations, passengersPerDestination);
                    if (passengerToTake != null && !takenPassengers.contains(passengerToTake)) {
                        passengersToTake.add(passengerToTake);
                        takenPassengers.add(passengerToTake);
                        startLocationForDriver = passengerToTake.getDestination();
                        matchingDriverWithPassenger.put(driver, passengersToTake);
                    } else {
                        startLocationForDriver = driver.getDestination();
                    }

                } else {
                    if (passengerToTake != null && !takenPassengers.contains(passengerToTake)) { // fix pasagerii care au traseul identic cu soferii
                        passengersToTake.add(passengerToTake);
                        takenPassengers.add(passengerToTake);
                        matchingDriverWithPassenger.put(driver, passengersToTake);
                        startLocationForDriver = driver.getDestination();

                    } else // pasagerii care nu au startLocation ca driverul, dar merg in acelasi loc
                    {
                        for (Passenger passenger : compatiblePassengers) {
                            int indexForPassengerStartLocation = destinations.indexOf(passenger.getStartLocation());


                            if (indexForPassengerStartLocation < indexForDriverDestination && !takenPassengers.contains(passenger)) {
                                passengersToTake.add(passenger);
                                takenPassengers.add(passenger);
                                matchingDriverWithPassenger.put(driver, passengersToTake);
                                startLocationForDriver = driver.getDestination();
                                break;
                            } else {
                                startLocationForDriver = driver.getDestination();
                            }
                        }
                    }
                }
            }

            System.out.println("Driver: " + driver.getName() + " with destination: " + driver.getDestination() + " ----> Passenger: " + passengersToTake);
        }

    }

}
