package Compulsory;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.Collections;

public class Solution2 {
    Problem problem;

    Solution2(Problem problem)
    {
        this.problem = problem;
    }

    public void randomIntervalFormDepotToClients(Client[] clients, List<Integer> timeIntervalsForClients)
    {

        for(Client client : clients)
        {
            int randomToAdd = (int)(Math.random() * 24) + 1;
            timeIntervalsForClients.add(randomToAdd) ; // ore intre 1 si 24
        }
    }

    public void randomIntervalFromClientToClients(Client[] clients, List<Integer> timeIntervalsForClients)
    {
        for(Client client : clients)
        {
            int randomToAdd = (int)(Math.random() * 24) + 1;
            timeIntervalsForClients.add(randomToAdd) ; // ore intre 1 si 24
        }

    }


    public int getIndexOfTheClosestClient(List<Integer> timeIntervalsForClients)
    {
        int minValue = timeIntervalsForClients.get(0); // initializare cu primul element
        int indexOfMinValue = 0;

        for(int i=0; i<timeIntervalsForClients.size(); i++)
        {
            if(timeIntervalsForClients.get(i)<minValue)
            {
                minValue = timeIntervalsForClients.get(i);
                indexOfMinValue = i;
            }
        }

        return indexOfMinValue;
    }

    public void printTimeIntervals(List<Integer> timeIntervals)
    {
        System.out.print("[");
        for(int i=0; i<timeIntervals.size(); i++)
        {
            System.out.print(timeIntervals.get(i)+",");
        }
        System.out.print("]");
    }

    public void greedyAlg()
    {
        List<Client> clients = problem.getClients();
        Vehicle[] vehicles = problem.getVehicles();
        List<Tour> tours = new ArrayList<>();

        for(Vehicle vehicle : vehicles)
        {
            Tour tour = new Tour();
            List<Client> clientsForTour = new ArrayList<>();
            tour.setVehicle(vehicle); // start from depot vehicle.getDepot()

            List<Integer> timeIntervalFormDepotToClients = new ArrayList<>();
            randomIntervalFormDepotToClients(clients.toArray(new Client[0]), timeIntervalFormDepotToClients);
            printTimeIntervals(timeIntervalFormDepotToClients);

            //plecam la cel mai apropiat client din punct de vedere al intervalului de timp
            int indexOfTheClosestClient = getIndexOfTheClosestClient(timeIntervalFormDepotToClients);
            clientsForTour.add(clients.get(indexOfTheClosestClient)); // acum am ajuns la cel mai apropiat client fata de depozit
            // de acum vom merge din depozit in depozit pana cand cea mai apropiata locatie este depozitul sau cat timp nu mai sunt clienti

            while(clients != null)
            {
                List<Integer> timeIntervalFromClientToClients = new ArrayList<>();
                randomIntervalFromClientToClients(clients.toArray(new Client[0]),timeIntervalFromClientToClients);
                printTimeIntervals(timeIntervalFromClientToClients);

                int indexOfTheClosestClientToTheAnotherClient = getIndexOfTheClosestClient(timeIntervalFromClientToClients); // practiv vedem ce client ar fi mai apropiat fata de clientul de care il avem deja

                // clientul la care as putea merge > clientul in care sunt deja
                if(timeIntervalFormDepotToClients.get(indexOfTheClosestClient) != -1)
                {
                    if(timeIntervalFromClientToClients.get(indexOfTheClosestClientToTheAnotherClient) > timeIntervalFormDepotToClients.get(indexOfTheClosestClient))
                    {
                        //ne intoarcem la depozit
                        clients.remove(clients.get(indexOfTheClosestClient));
                        System.out.print("test");
                        for(Client client : clientsForTour)
                        {
                            System.out.println(client.getClientName());
                        }
                        break;

                    }

                    clientsForTour.add(clients.get(indexOfTheClosestClientToTheAnotherClient));
                    clients.remove(clients.get(indexOfTheClosestClient));
                    timeIntervalFormDepotToClients.set(indexOfTheClosestClient, -1);
                    indexOfTheClosestClient = indexOfTheClosestClientToTheAnotherClient;

                    System.out.print("teeest");
                    for(Client client : clientsForTour)
                    {
                        System.out.println(client.getClientName());
                    }

                    System.out.print("\n\n");
                }
            }

            if(clients != null)
            {

                clients.remove(clients.get(indexOfTheClosestClient));
                tour.setClients(clientsForTour.toArray(new Client[0]));
                tours.add(tour);
            }
            else
            {
                break;
            }

        }

//        Afisam tururile
        for(Tour tour : tours)
        {
            System.out.println(tour.toString());
        }
    }
}
