package Compulsory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.Collections;

/**
 * A class representing a solution for VRP problem
 * */
public class Solution {
    Problem problem;

    /**
     * Constructs a solution with a given problem.
     *
     * @param problem The problem for which this solution is constructed.
     */
    Solution(Problem problem)
    {
        this.problem = problem;
    }

    /**
     * Generates random intervals from the depot to clients.
     *
     * @param timeIntervals   Array to store generated time intervals.
     * @param numberOfClients The number of clients.
     */
    public void randomIntervalFormDepotToClients(int[] timeIntervals, int numberOfClients)
    {

        for(int i=0; i<numberOfClients; i++)
        {
            int randomToAdd = (int)(Math.random() * 24) + 1;
            timeIntervals[i] = randomToAdd ; // ore intre 1 si 24
        }
    }

    /**
     * Generates random intervals from one client to another.
     *
     * @param timeIntervals   matrix to store generated time intervals.
     * @param numberOfClients The number of clients.
     */
    public void randomIntervalFromClientToClients(int[][] timeIntervals, int numberOfClients)
    {
        for(int i=0; i<numberOfClients; i++)
        {
            for(int j=0; j<numberOfClients; j++)
            {
                if(i != j)
                {
                    int randomToAdd = (int)(Math.random() * 24) + 1;
                    timeIntervals[i][j] = randomToAdd;
                }
            }
        }
    }


    /**
     * Gets the index of the closest client from the depot.
     *
     * @param timeIntervals   Array of time intervals from depot to clients.
     * @param visitedClients  Array indicating visited clients.
     * @return The index of the closest client from the depot.
     */
    public int getIndexOfTheClosestClientFromDepot(int[] timeIntervals, int[] visitedClients)
    {
        int minValue = 25;
        int indexOfMinValue = 0;
        for(int i=0; i<timeIntervals.length; i++)
        {
            if(timeIntervals[i] < minValue && visitedClients[i] != -1)
            {
                minValue = timeIntervals[i];
                indexOfMinValue = i;
            }
        }

        return indexOfMinValue;
    }

    /**
     * Gets the index of the closest client from another client.
     *
     * @param timeIntervals 2D array of time intervals from one client to another.
     * @param indexClient   The index of the client.
     * @return The index of the closest client from another client.
     */
    public int getIndexOfTheClosestClientFromAnotherClient(int[][] timeIntervals, int indexClient)
    {
        int minValue = 25;
        int indexOfMinValue = 0;
        for(int i=0; i<timeIntervals.length; i++)
        {
            if(timeIntervals[indexClient][i] < minValue && timeIntervals[indexClient][i] != 0 && timeIntervals[indexClient][i] != -1)
            {
                minValue = timeIntervals[indexClient][i];
                indexOfMinValue = i;
            }
        }

        return indexOfMinValue;
    }

    /**
     * Marks the visited client in the time intervals matrix.
     *
     * @param timeIntervals            2D array of time intervals.
     * @param indexOfTheClosestClient   Index of the closest client.
     */
    public void setTheVisitedClient(int[][] timeIntervals, int indexOfTheClosestClient)
    {
        for(int i=0; i<timeIntervals.length; i++)
        {
            timeIntervals[i][indexOfTheClosestClient] = -1; // -1-> vizitat deja
        }
    }

    /**
     * Checks if all clients are visited from the depot.
     *
     * @param visitedClients Array indicating visited clients.
     * @return True if all clients are visited from the depot, false otherwise.
     */
    public boolean allClientsAreVisitedFromDepot(int[] visitedClients)
    {
        for(int i=0; i<visitedClients.length; i++)
        {
            if(visitedClients[i] != -1)
                return false;
        }

        return true;
    }

    /**
     * Checks if all clients are visited.
     *
     * @param timeIntervals 2D array of time intervals.
     * @return True if all clients are visited, false otherwise.
     */
    public boolean allClientsAreVisited(int[][] timeIntervals)
    {
        for(int i=0; i<timeIntervals.length; i++)
        {
            for(int j=0; j<timeIntervals.length; j++)
            {
                if(i != j)
                {
                    if(timeIntervals[i][j] != -1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * Applies the greedy algorithm to solve the problem.
     */
    public void greedyAlg()
    {
        List<Client> clients = problem.getClients();
        Vehicle[] vehicles = problem.getVehicles();
        List<Tour> tours = new ArrayList<>();

        // Constructing time intervals from depot to clients
        int[] timeIntervalsFromDepotToClients =  new int[clients.size()];
        int[] visitedClients = new int[clients.size()];
        randomIntervalFormDepotToClients(timeIntervalsFromDepotToClients, clients.size());

        // Display the time intervals from depot to clients
        for(int i=0; i<timeIntervalsFromDepotToClients.length; i++)
        {
            System.out.print(timeIntervalsFromDepotToClients[i] + " ");
        }
        System.out.print("\n\n");

        // Constructing time intervals from clients to clients (matrix)
        int[][] timeIntervalsFromClientsToClients = new int[clients.size()][clients.size()];
        randomIntervalFromClientToClients(timeIntervalsFromClientsToClients, clients.size());

        //Display the time intervals from a client to another client
        for(int i=0; i<timeIntervalsFromClientsToClients.length; i++)
        {
            for(int j=0; j<timeIntervalsFromClientsToClients.length; j++)
            {
                System.out.print(timeIntervalsFromClientsToClients[i][j] + " ");
            }

            System.out.print("\n");
        }


        for(Vehicle vehicle : vehicles)
        {
            // where all clients are visited -> the vehicules have nowhere to go
            if(allClientsAreVisitedFromDepot(visitedClients) == true)
            {
                break;
            }
            Tour tour = new Tour();
            List<Client> clientsForTour = new ArrayList<>();
            tour.setVehicle(vehicle);

            // calculate which is the closest client to the depot
            int indexOfTheClosestClient = getIndexOfTheClosestClientFromDepot(timeIntervalsFromDepotToClients, visitedClients);

            clientsForTour.add(clients.get(indexOfTheClosestClient));

            setTheVisitedClient(timeIntervalsFromClientsToClients, indexOfTheClosestClient);
            visitedClients[indexOfTheClosestClient] = -1;

            while(allClientsAreVisited(timeIntervalsFromClientsToClients) == false)
            {
                int indexOfTheClosestClientFromAnotherClient = getIndexOfTheClosestClientFromAnotherClient(timeIntervalsFromClientsToClients, indexOfTheClosestClient); // indexul urmatorului client
                
                if(timeIntervalsFromClientsToClients[indexOfTheClosestClient][indexOfTheClosestClientFromAnotherClient] > timeIntervalsFromDepotToClients[indexOfTheClosestClient])
                {
                    visitedClients[indexOfTheClosestClient] = -1;
                    break;
                }
                clientsForTour.add(clients.get(indexOfTheClosestClientFromAnotherClient));
                setTheVisitedClient(timeIntervalsFromClientsToClients, indexOfTheClosestClientFromAnotherClient);
                visitedClients[indexOfTheClosestClientFromAnotherClient] = -1;
                indexOfTheClosestClient = indexOfTheClosestClientFromAnotherClient;

            }
            tour.setClients(clientsForTour.toArray(new Client[0]));
            tours.add(tour);

        }
        for(Tour tour : tours)
        {
            System.out.println(tour.toString());
        }

    }
}
