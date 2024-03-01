import java.util.Scanner;


public class Bonus {
    public static int countOfCycles = 0;

    /**
     * Functia createAdjectiveMatrix creaza matricea de adiacenta pentru un wheel graph astfel:
     * -> prima data concateneaza nodurile care se afla in circuit: am presupus ca acestea sunt cele de la 0 la n-2
     * -> pentru 0 si 1 am tratat cazurile speciale deoarece vecinii lor nu mai sunt i+1 si i-1
     * -> concatenam fiecare nod din circuit cu nodul din mijloc (n-1)
     * Apoi vom calcula numarul circuitelor de 3 noduri dupa urmatoarea stategie:
     * ->cu o parcurgere DFS gasim orice cale posibila de lungime 2 pentru orice nod
     * ->verificam daca nodul cu care incepe calea poate fi si nodul de final
     * -> daca da, am gasit un circuit de lungime 2 si il numaram
     * -> orice cale de lungime 2 poate fi cautata doar in numarul nodurilor din graf minus (3-1) deoarece 2 dintre aceste noduri exista deja in calea pe care dorim sa o extindem la un circuit
     * -> dupa ce am terminat de parcurs toate nodurile, vom imparti numarul total de noduri la 2 deoarece caile gasite vor fi duplicate (spre exemplu 0->1->2->0 si 0->2->1->0)
     * De ce cautam circuite de luingime 3? Pentru ca observam urmatorul tipar:
     * -> lungimea minima a unui circuit intr-ul wheel graph este 3
     * -> unind aceste mici circuite, obtinem unele mai mari -> cu rationamentul acesta obtinem toate circuitele care contin nodul n-1
     * -> adaugam la acest numar circuitul format din nodurile 0...n-1*/
    public static int[][] createAdjectiveMatrix(int numberOfVertices)
    {
        int[][] returnMatrix = new int[numberOfVertices][numberOfVertices];
        for(int i=0; i<numberOfVertices; i++)
        {
            if(i == 0)
            {
                returnMatrix[i][i+1] = 1;
                returnMatrix[i][numberOfVertices-2] = 1;
            }
            else if(i == numberOfVertices-2)
            {
                returnMatrix[i][0] = 1;
                returnMatrix[i][i-1] = 1;
            }
            else if(i != numberOfVertices- 1)
            {
                returnMatrix[i][i+1] = 1;
                returnMatrix[i][i-1] = 1;
            }

            returnMatrix[i][numberOfVertices-1] = 1;
            returnMatrix[numberOfVertices-1][i] = 1;
        }
        returnMatrix[numberOfVertices-1][numberOfVertices-1] = 0;
        return returnMatrix;
    }

    public static void DFS(int[][] adjMatrix, int numberOfVertices, boolean[] visited, int numberOfCyclesVertices, int node, int start)
    {
        visited[node] = true;

        if(numberOfCyclesVertices == 0)
        {
            visited[node] = false;
            if(adjMatrix[node][start] == 1)
            {
                countOfCycles++;
            }
            return;
        }

        for(int i=0; i<numberOfVertices; i++)
        {
            if(!visited[i] && adjMatrix[node][i] == 1)
            {
                DFS(adjMatrix, numberOfVertices, visited, numberOfCyclesVertices-1, i, start);
            }
        }

        visited[node] = false;
    }

    public static int countCyclesWith3Vertices(int[][] adjMatrix, int numberOfCyclesVertices, int numberOfVertices)
    {
        boolean[] visited = new boolean[numberOfVertices];

        for(int i=0; i < numberOfVertices - numberOfCyclesVertices +1; i++)
        {
            DFS(adjMatrix, numberOfVertices, visited, numberOfCyclesVertices-1, i, i);

            visited[i] = true;
        }

        if(numberOfVertices == 4)
        {
            return countOfCycles/2-1;
        }

        return countOfCycles/2;
    }

    public static int numberOfTotalCycles(int numberOfCyclesWith3Vertices)
    {
        int total = 0;
        for(int i=1; i<=numberOfCyclesWith3Vertices-1; i++)
        {
            total += numberOfCyclesWith3Vertices;
        }

        total++; //circuitul de la 1 la n-1
        return total;
    }

    public static void Check(int numberOfVertices, int numberOfCycles)
    {
        int expectedNumberOfVertices = numberOfVertices*numberOfVertices - 3*numberOfVertices +3;

        if(expectedNumberOfVertices == numberOfCycles)
        {
            System.out.println("The number of all cycles in a wheel graph with " + numberOfVertices + " is: " + numberOfCycles);
        }
        else
        {
            System.out.println(numberOfCycles + " is'n the correct number. The number of all cycles in a wheel graph is: " + expectedNumberOfVertices);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de noduri ale grafului: ");

        int numberOfVertices = scanner.nextInt();
        scanner.close();

        int[][] matrix = createAdjectiveMatrix(numberOfVertices);

        for(int i=0; i<numberOfVertices; i++)
        {
            for(int j=0; j<numberOfVertices; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        int numberOfCyclesWith3Vertices = countCyclesWith3Vertices(matrix, 3, numberOfVertices);
        int totalNumberOfVertices = numberOfTotalCycles(numberOfCyclesWith3Vertices);
        Check(numberOfVertices, totalNumberOfVertices);
    }
}
