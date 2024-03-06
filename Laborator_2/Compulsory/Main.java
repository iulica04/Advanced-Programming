package Compulsory;
import java.time.LocalDateTime;
public class Main {
    public static void main(String args[])
    {
        Depot audiDepot = new Depot("Audi Depot");
        Depot toyotaDepot = new Depot("Toyota Depot");

        LocalDateTime startTimeForClient1 = LocalDateTime.of(2024, 02, 01, 12, 00);
        LocalDateTime endTimeForClient1 = LocalDateTime.of(2024, 03, 01, 12, 00);
        TimeInterval timeIntervalForClient1 = new TimeInterval(startTimeForClient1, endTimeForClient1);

        LocalDateTime startTimeForClient2 = LocalDateTime.of(2024, 07, 01, 14, 00);
        LocalDateTime endTimeForClient2 = LocalDateTime.of(2024, 12, 15, 15, 00);
        TimeInterval timeIntervalForClient2 = new TimeInterval(startTimeForClient2, endTimeForClient2);
        System.out.println(timeIntervalForClient1.getTimeInterval());

        Client client1 = new Client("Vreme Iulia", timeIntervalForClient1, ClientType.PREMIUM);
        Client client2 = new Client("Pirlac Diana", timeIntervalForClient2, ClientType.REGULAR);

        Vehicle vehicle1 = new Vehicle("Toyota Elantra", toyotaDepot);
        Vehicle vehicle2 = new Vehicle("Audi RS7", audiDepot);
        Vehicle vehicle3 = new Vehicle("Audi A6", audiDepot);
        Vehicle vehicle4 = new Vehicle("Audi A5", audiDepot);

        Tour tour1 = new Tour();
        tour1.setClients(client1, client1);
        tour1.setVehicle(vehicle1);


        audiDepot.setVehicles(vehicle3, vehicle4);
        audiDepot.setVehicles(vehicle2);


         System.out.println(audiDepot.toString());
         System.out.println(toyotaDepot.toString());
         System.out.println(vehicle1.toString());
         System.out.println(vehicle2.toString());
         System.out.println(client1.toString());
         System.out.println(client2.toString());
         System.out.println(tour1.toString());
    }
}
