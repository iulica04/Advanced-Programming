package Compulsory;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[])
    {
        Depot scaniaDepot = new Depot("Scania Depot");
        Depot djiDepot = new Depot("DJI Depot");

        LocalDateTime startTimeForClient1 = LocalDateTime.of(2024, 02, 01, 12, 00);
        LocalDateTime endTimeForClient1 = LocalDateTime.of(2024, 03, 01, 12, 00);
        TimeInterval timeIntervalForClient1 = new TimeInterval(startTimeForClient1, endTimeForClient1);

        LocalDateTime startTimeForClient2 = LocalDateTime.of(2024, 07, 01, 14, 00);
        LocalDateTime endTimeForClient2 = LocalDateTime.of(2024, 12, 15, 15, 00);
        TimeInterval timeIntervalForClient2 = new TimeInterval(startTimeForClient2, endTimeForClient2);
        System.out.println(timeIntervalForClient1.getTimeInterval());

        Client client1 = new Client("Vreme Iulia", timeIntervalForClient1, ClientType.PREMIUM);
        Client client2 = new Client("Pirlac Diana", timeIntervalForClient2, ClientType.REGULAR);
        Client client3 = new Client("Ana", timeIntervalForClient1, ClientType.REGULAR);
        Client client4 = new Client("Andrei", timeIntervalForClient2, ClientType.PREMIUM);

        Vehicle truck1 = new Truck("Scania Seria S", scaniaDepot, 100);
        Vehicle truck2 = new Truck("Scania Seria R", scaniaDepot, 150);
        Vehicle drone1 = new Drone("DJI Mini 3 Pro", djiDepot, LocalTime.of(12, 00));
        Vehicle drone2 = new Drone("DJI Mini 2 SE", djiDepot, LocalTime.of(00, 30));

        Tour tour1 = new Tour();
        tour1.setClients(client1, client1);
        tour1.setVehicle(truck1);


        scaniaDepot.setVehicles(truck1, truck2);
        djiDepot.setVehicles(drone1, drone2);


         System.out.println(scaniaDepot.toString());
         System.out.println(djiDepot.toString());
         System.out.println(drone1.toString());
         System.out.println(drone2.toString());
         System.out.println(client1.toString());
         System.out.println(client2.toString());
         System.out.println(tour1.toString());

         Problem problem1 = new Problem();
         List<Depot> depotsForProblem = new ArrayList<>();
         depotsForProblem.add(scaniaDepot);
         depotsForProblem.add(djiDepot);
         List<Client> clientsForProblem = new ArrayList<>();
         clientsForProblem.add(client1);
         clientsForProblem.add(client2);
         clientsForProblem.add(client3);
         clientsForProblem.add(client4);

         problem1.setDepots(depotsForProblem);
         problem1.setClients(clientsForProblem);


         Vehicle[] allVehicles = problem1.getVehicles();
         System.out.println("All vehicles from all depots: ");
         for(Vehicle vehicle : allVehicles)
         {
             System.out.println(vehicle);
         }


         Solution solution1 = new Solution(problem1);
         solution1.greedyAlg();
    }
}
