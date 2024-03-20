package Compulsory;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Solution2 {
    Problem problem;
    final static int INF = 99999;

    Solution2(Problem problem)
    {
        this.problem = problem;
    }


    public void generatorClients(List<Client> clients, int clientsNumber)
    {
        for(int i=1; i<=clientsNumber; i++)
        {
            String clientName = "client".concat(String.valueOf(i));
            int randomType = (int)(Math.random() * 1);
            ClientType clientType;
            if(randomType == 0)
            {
                clientType = ClientType.REGULAR;
            }
            else
            {
                clientType = ClientType.PREMIUM;
            }
            TimeInterval timeInterval = new TimeInterval(LocalDateTime.of(2024, 3,10, 10, 0), LocalDateTime.of(2024, 3,10, 20, 0));

            Client client = new Client(clientName, timeInterval, clientType);
            clients.add(client);
        }
    }



    public void generatorDepotsAndVehicles(List<Depot> depots, int depotsNumber, List<Vehicle> vehicles, int vehicleNumber)
    {
        int countVehicles = 1;
        for(int i=1; i<=depotsNumber; i++)
        {
            List<Vehicle> vehiclesForDepot = new ArrayList<>();
            String depotName = "depot".concat(String.valueOf(i));
            Depot depot = new Depot(depotName);

            int randomNumberForVehicles = (int)(Math.random() * 20) +1;
            for(int j=1; j<=randomNumberForVehicles; j++)
            {
                String vehicleName = "vehicle".concat(String.valueOf(countVehicles));
                countVehicles++;

                int randomType = (int)(Math.random() * 1);

                if(randomType == 0)
                {
                    Vehicle vehicle = new Truck(vehicleName, depot, 100);
                    vehicles.add(vehicle);
                    vehiclesForDepot.add(vehicle);
                }
                else
                {
                    Vehicle vehicle = new Drone(vehicleName, depot, LocalTime.of(2, 0));
                    vehicles.add(vehicle);
                    vehiclesForDepot.add(vehicle);
                }
            }
            depot.setVehicles(vehiclesForDepot.toArray(new Vehicle[0]));
            depots.add(depot);

        }

        vehicleNumber = --countVehicles;
    }


    public void setLocationsForDepots(List<Pair<Integer, Integer>> locationsForDepots, int depotsNumber, int number)
    {
        for(int i=0; i<depotsNumber; i++)
        {
            int first = (int)(Math.random() * Math.sqrt(number));
            int second = (int)(Math.random() * Math.sqrt(number));
            locationsForDepots.add(new Pair<>(first, second)); // o sa avem un depozit la o pozitie i, j -> care va fi de fapt la nodul i*number+j
        }
    }

    public boolean sameLocation(Pair<Integer, Integer> pair, List<Pair<Integer, Integer>> locations)
    {
        return locations.contains(pair); // returneaza true daca locatia se gaseste in lista
    }

    public void setLocationForClients(List<Pair<Integer, Integer>> locationsForClients, int clientsNumber, List<Pair<Integer, Integer>> locationsForDepots, int number)
    {
        for(int i=0; i<clientsNumber; i++)
        {
            int first = (int)(Math.random() *  Math.sqrt(number));
            int second = (int)(Math.random() *  Math.sqrt(number));
            Pair<Integer, Integer> pairToAdd = new Pair<>(first, second);

            if(!sameLocation(pairToAdd, locationsForDepots))
            {
                locationsForClients.add(pairToAdd);
            }
            else {
                i--;
            }

        }
    }

    public void setAdjMatrixForGridGraph(int[][] matrix, int number, List<Pair<Integer, Integer>> locationsForDepots, List<Pair<Integer, Integer>> locationsForClients)
    {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(i != j)
                {
                    matrix[i][j] = INF;
                }
            }
        }

       // int randomNumber = (int)(Math.random() * 24) +1; // pentru cazul cand vrem sa generam o matrice de costuri egale

        int newNumber = (int)Math.sqrt(number);
        for (int i = 0; i < newNumber; i++) {
            for (int j = 0; j < newNumber; j++) {

                /**
                 * Mereu ne uitam doar la muchia de sub sau din dreapta nodului */

                int nodeIndex = i * newNumber + j; // la nodul acesta avem un client sau un depozit
                if (i < newNumber - 1 )// Nodul de dedesubt
                {
                    int randomNumber = (int)(Math.random() * 24) +1;
                    matrix[nodeIndex][(i+1)*newNumber+j] = randomNumber;
                    matrix[(i+1)*newNumber+j][nodeIndex] = randomNumber;

                }
                if (j < newNumber - 1)// Nodul din dreapta
                {
                    int randomNumber = (int)(Math.random() * 24) +1;
                    matrix[nodeIndex][i * newNumber + (j + 1)] = randomNumber;
                    matrix[i * newNumber + (j + 1)][nodeIndex] = randomNumber;
                }

            }
        }


    }

    public void floydWarshall(int[][] matrix, int number, List<Pair<Integer, Integer>> locationsForDepots , List<Pair<Integer, Integer>> locationsForClients)
    {
        /**
         * Vom actualiza matricea astfel: actualizam costul unei muchii cu cea mai mica suma dintre muchiile care constituie drumul de la i la j*/

        int i, j, k;
        for(k=0; k<number; k++)
        {
            for(i=0; i<number; i++)
            {
                for(j=0; j<number; j++)
                {

                    if(matrix[i][k] + matrix[k][j] < matrix[i][j])
                    {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
    }

    public void printMatrix(int[][] matrix, int number)
    {
        for (int i = 0; i < number; i++)
        {
            for (int j = 0; j < number; j++)
            {   if(matrix[i][j] == INF)
                {
                    System.out.print("INF ");
                }
                else
                {
                    System.out.print(matrix[i][j] + "  ");
                }
            }
            System.out.print("\n");
        }
    }

    // caz special pentru un grid graph in care costurile tuturor muchiilor sunt egale
    public boolean costsOfAllEdgesAreEquals(int[][] matrix, int number)
    {
        int cost = matrix[0][1]; // strim sigur ca intr un grid graph exista aceatsa muchie

        for(int i=0; i<number; i++)
        {
            for(int j=0; j<number; j++)
            {
                if(matrix[i][j] != INF && i != j)
                {
                    if(matrix[i][j] != cost)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int costOfPath(int cost, int number, int startNode, int endNode)
    {
        int numberOfRows = (int)Math.sqrt(number);

        int iForStartNode = startNode / numberOfRows;
        int jForStartNode = startNode % numberOfRows;
        System.out.println("Index for start node: " + iForStartNode + ", " + jForStartNode);

        int iForEndNode = endNode / numberOfRows;
        int jForEndNode = endNode % numberOfRows;
        System.out.println("Index for end node: " + iForEndNode + ", " + jForEndNode);

        int numberOfEdgesFromStartNodeToEndNode = Math.abs(iForStartNode-iForEndNode) + Math.abs(jForStartNode-jForEndNode);

        return numberOfEdgesFromStartNodeToEndNode * cost;
    }

    public void alg()
    {
        int clientsNumber = (int)(Math.random() * 100) +1;
        System.out.println("Number of clients for problem: "+ clientsNumber);
        int depotsNumber = (int)(Math.random() * 50) +1;
        System.out.println("Number of depots for problem: "+ depotsNumber);


        List<Client> clients = new ArrayList<>();
        List<Depot> depots = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();



        int vehiclesNumber = 0;
        generatorClients(clients, clientsNumber);
        generatorDepotsAndVehicles(depots, depotsNumber, vehicles, vehiclesNumber);


        int number= clientsNumber + depotsNumber; // cate linii si coloane avem in grid graph
        while(Math.sqrt(number) != Math.floor(Math.sqrt(number)))
        {
            number++;
        }

        List<Pair<Integer, Integer>> locationsForDepots = new ArrayList<>(); // pentru a sti unde sunt depozitele in matrice
        List<Pair<Integer, Integer>> locationsForClients= new ArrayList<>();

        // setam locatiile pentru depozite si clienti in grid graph
        setLocationsForDepots(locationsForDepots, depotsNumber, number);
        System.out.println(locationsForDepots.toString());
        setLocationForClients(locationsForClients, clientsNumber, locationsForDepots, number);
        System.out.println(locationsForClients.toString());

        int[][] matrix = new int[number][number];
        setAdjMatrixForGridGraph(matrix, number, locationsForDepots, locationsForClients);
        printMatrix(matrix, number);

        System.out.println("\n\n-----------------------------------------------------\n\n");

        //verificam daca matricea are toate costurile egale
        if(costsOfAllEdgesAreEquals(matrix, number))
        {
            System.out.println("Costs of all edges are equal.");
            //trebuie sa specificam costul, nodul de start si nodul de end
            //le vom genera random pentru a verifica comportamentul

            int startNode = (int)(Math.random() * number-1) +1;
            int endNode = (int)(Math.random() * number-1) +1;

            int cost = costOfPath(matrix[0][1], number, startNode, endNode);
            System.out.println("Cost of path from " + startNode + " to " + endNode + " is: " + cost);
        }
        else
        {
            System.out.println("Costs of all edges aren't equal.");
            floydWarshall(matrix, number, locationsForDepots, locationsForClients);
            printMatrix(matrix, number);
        }

    }

}
