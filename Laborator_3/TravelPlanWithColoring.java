import org.w3c.dom.Attr;

import java.lang.reflect.Array;
import java.time.Period;
import java.util.*;

public class TravelPlanWithColoring {
    Trip trip;
    Map<Integer, List<Attraction>> plan;

    TravelPlanWithColoring(Trip trip) {
        this.trip = trip;
        plan = new HashMap<>();
    }

    public void constructTheGraph(int[][] matrix, List<Attraction> attractions, int numberOfAttractions) {
        for (int i = 0; i < numberOfAttractions; i++) {
            for (int j = 0; j < numberOfAttractions; j++) {
                if (i != j) {
                    if ((attractions.get(i) instanceof Church && attractions.get(j) instanceof Church) ||
                            (attractions.get(i) instanceof Concert && attractions.get(j) instanceof Concert) ||
                            (attractions.get(i) instanceof Statue && attractions.get(j) instanceof Statue)) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }
    }

    public void printGraph(int[][] matrix, int numberOfAttractions) {
        for (int i = 0; i < numberOfAttractions; i++) {
            for (int j = 0; j < numberOfAttractions; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void findDegree(int[][] matrix, int number, int[] degree) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (matrix[i][j] == 1) {
                    degree[i]++;
                }
            }
        }
    }

    public void orderVerticesOfDescendingDegree(int[] degree, int number, int[] order) {

        for (int i = 0; i < number; i++) {
            order[i] = i;
        }

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (degree[i] > degree[j]) {
                    int aux = degree[i];
                    degree[i] = degree[j];
                    degree[j] = aux;

                    aux = order[i];
                    order[i] = order[j];
                    order[j] = aux;
                }
            }
        }
    }

    public boolean notSameType(List<Attraction> addedAttraction, Attraction attraction) {
        for (Attraction attractionIterator : addedAttraction) {
            if ((attractionIterator instanceof Church && attraction instanceof Church) ||
                    (attractionIterator instanceof Concert && attraction instanceof Concert) ||
                    (attractionIterator instanceof Statue && attraction instanceof Statue)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Welsh-Powell: Este un algoritm euristic greedy care colorează nodurile grafului în funcție de gradul lor.
     * Nodurile sunt sortate descrescător după grad și li se atribuie cea mai mică culoare disponibilă care nu este deja folosită de vecinii lor.
     * Acest algoritm poate fi eficient pentru grafuri mari cu distribuții uniforme ale gradelor.
     */
    public void welshPowellAlgorithm(int[][] matrix, int numberOfAttractions, List<Attraction> attractions, int colors) {

        int[] degree = new int[numberOfAttractions];
        findDegree(matrix, numberOfAttractions, degree);
        int[] order = new int[numberOfAttractions]; // ordinea atractiilor in in funtie de gradul lor
        orderVerticesOfDescendingDegree(degree, numberOfAttractions, order);


        List<Attraction> coloredAttractions = new ArrayList<>();
        Map<Attraction, Integer> map = new HashMap<>(); // perechi de forma atractie-culoare
        List<Attraction> attractionWithSameColor = new ArrayList<>();

        int color = 1;
        for (int i = 0; i < numberOfAttractions; i++) {

            int index = order[i];
            attractionWithSameColor.clear();
            if (!coloredAttractions.contains(attractions.get(index))) {


                map.put(attractions.get(index), color);
                coloredAttractions.add(attractions.get(index));

                for (int j = 0; j < numberOfAttractions; j++) {
                    if (matrix[index][j] == 0 && !coloredAttractions.contains(attractions.get(j))) {

                        if (notSameType(attractionWithSameColor, attractions.get(j))) {
                            attractionWithSameColor.add(attractions.get(j)); // verific daca exista un acelasi tip de vecin intre nodurile deja colorate cua ceiasi culoare
                            map.put(attractions.get(j), color);
                            coloredAttractions.add(attractions.get(j));
                        }

                    }
                }

                if (attractions.size() == coloredAttractions.size()) {
                    System.out.println("All attractions are visitable in this number of days.");
                    break;
                }

                color++;
                if (color > colors) {
                    System.out.println("To much attractions for this number of days.");
                    break;
                }

            }
        }

        for (int i = 1; i <= colors; i++) {
            List<Attraction> attractionToVisitEachDay = new ArrayList<>();
            for (Attraction attraction : map.keySet()) {
                if (map.get(attraction) == i) {
                    attractionToVisitEachDay.add(attraction);
                }
            }

            plan.put(i, attractionToVisitEachDay);
            System.out.println("DAY " + i + ": ");
            System.out.println(attractionToVisitEachDay.toString() + "\n");
        }

    }


    /**
     * DSATUR
     */

    public Attraction getMaxDegreeAttraction(List<Attraction> attractions, int number, int[][] matrix) {
        int[] order = new int[number];
        int[] degree = new int[number];

        findDegree(matrix, number, degree);
        orderVerticesOfDescendingDegree(degree, number, order);

        return attractions.get(order[0]);
    }

    public int getNextAttraction(int number, boolean[] colored, int[] saturationDegree) {
        int maxSatDegree = -1;
        int indexOfNextAttraction = -1;
        for (int i = 0; i < number; i++) {
            if (!colored[i] && saturationDegree[i] > maxSatDegree) {
                maxSatDegree = saturationDegree[i];
                indexOfNextAttraction = i;
            }
        }

        return indexOfNextAttraction;
    }

    public void colorAttraction(int indexOfAttraction, int[] color, int number, int[][] matrix) {
        boolean[] usedColors = new boolean[number];
        for (int i = 0; i < number; i++) {
            if (matrix[indexOfAttraction][i] == 1 && color[i] != -1) {
                usedColors[color[i]] = true;
            }
        }

        for (int i = 0; i < number; i++) {
            if (!usedColors[i]) {
                color[indexOfAttraction] = i;
                break;
            }
        }
    }

    public void updateSaturationDegree(int indexOfAttraction, int number, int[][] matrix, int[] saturationDegree, boolean[] colored) {

        for (int i = 0; i < number; i++) {
            if (matrix[indexOfAttraction][i] == 1 && colored[i]) {
                saturationDegree[i]++;
            }
        }
    }

    public void dsatur(int[][] matrix, int numberOfAttractions, List<Attraction> attractions, int colors) {
        int[] saturationDegree = new int[numberOfAttractions];
        int[] color = new int[numberOfAttractions];
        boolean[] colored = new boolean[numberOfAttractions];

        Arrays.fill(color, -1);
        Arrays.fill(saturationDegree, 0);
        Arrays.fill(colored, false);

        Attraction getMaxDegreeAttraction = getMaxDegreeAttraction(attractions, numberOfAttractions, matrix);
        int indexOfMaxDegreeAttraction = attractions.indexOf(getMaxDegreeAttraction);
        color[indexOfMaxDegreeAttraction] = 0; // prima culoare
        colored[indexOfMaxDegreeAttraction] = true;

        for (int i = 1; i < numberOfAttractions; i++) {
            int indexOfNextAttraction = getNextAttraction(numberOfAttractions, colored, saturationDegree);

            colorAttraction(indexOfNextAttraction, color, numberOfAttractions, matrix);
            colored[indexOfNextAttraction] = true;
            updateSaturationDegree(indexOfNextAttraction, numberOfAttractions, matrix, saturationDegree, colored);
        }

        if(Arrays.stream(color).max().orElse(0) > colors-1){
            System.out.println("Not all attraction can be visited in " + colors + "days.");
        }


        Map<Attraction, Integer> colorForEachAttraction = new HashMap<>();
        for (int i = 0; i < numberOfAttractions; i++) {
            colorForEachAttraction.put(attractions.get(i), color[i]);
        }

        List<Attraction> attractionList = new ArrayList<>();
        int colorNumber = 0;
        while (colorNumber < colors) {
            attractionList.clear();
            for (Attraction attraction : colorForEachAttraction.keySet()) {
                if (colorForEachAttraction.get(attraction) == colorNumber) {
                    attractionList.add(attraction);
                }
            }
            System.out.println("DAY " + (colorNumber + 1) + ": ");
            System.out.println(attractionList);
            plan.put(colorNumber + 1, attractionList);
            colorNumber++;
        }

    }


    public void planingAttractionsForEachDay() {
        List<Attraction> attractions = trip.getAttractions();

        int numberOfAttractions = attractions.size();


        int colors = (Period.between(trip.getPeriodOfTime().getFirst(), trip.getPeriodOfTime().getSecond())).getDays();

        System.out.println("Number Of colors: " + colors);

        int[][] matrix = new int[numberOfAttractions][numberOfAttractions];

        constructTheGraph(matrix, attractions, numberOfAttractions);
        printGraph(matrix, numberOfAttractions);

        System.out.println("TRAVEL PLAN WITH WELSH POWELL ALGORITHM: ");
        welshPowellAlgorithm(matrix, numberOfAttractions, attractions, colors);

        System.out.println("__________________________________________\n");

        System.out.println("TRAVEL PLAN WITH DSATUR ALGORITHM: ");
        dsatur(matrix, numberOfAttractions, attractions, colors);

    }
}
