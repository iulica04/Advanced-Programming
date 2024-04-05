import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FindMaximalGroups implements Command {
    Map<String, List<String>> abilitiesForEachPerson;
    String pathForXlsxFile;
    int numberOfPersons;
    String[][] matrix;
    private Set<Set<Integer>> maxCliques;
    private List<String> persons;

    FindMaximalGroups(String pathForXlsxFile) {
        abilitiesForEachPerson = new HashMap<>();
        this.pathForXlsxFile = pathForXlsxFile;
        numberOfPersons = 0;
        persons = new ArrayList<>();
    }


    public void printAllAbilitiesForAllPersons() {
        System.out.println("Number of persons: " + numberOfPersons);
        for (Map.Entry<String, List<String>> entry : abilitiesForEachPerson.entrySet()) {
            String personName = entry.getKey();
            List<String> abilities = entry.getValue();
            System.out.println("Person: " + personName);
            System.out.println("Abilities: " + abilities);
        }
    }

    public boolean commonAbility(String name1, String name2) {
        List<String> listForName1 = abilitiesForEachPerson.get(name1);
        List<String> listForName2 = abilitiesForEachPerson.get(name2);

        List<String> common = new ArrayList<>(listForName1);
        common.retainAll(listForName2);

        return !common.isEmpty();
    }

    public void createGraph() {
        matrix = new String[numberOfPersons + 1][numberOfPersons + 1]; // adjacency matrix between persons
        int index = 1;

        for (String name : abilitiesForEachPerson.keySet()) {
            matrix[0][index] = name;
            matrix[index][0] = name;
            index++;
        }

        for (int i = 1; i < numberOfPersons + 1; i++) {
            for (int j = 1; j < numberOfPersons + 1; j++) {
                if (i != j) {
                    String name1 = matrix[0][j];
                    String name2 = matrix[i][0];

                    if (commonAbility(name1, name2)) {
                        matrix[i][j] = "true";
                    }
                }
            }
        }

        for (int i = 0; i < numberOfPersons + 1; i++) {
            for (int j = 0; j < numberOfPersons + 1; j++) {
                System.out.print(matrix[i][j] + "     ");
            }
            System.out.println("\n");
        }
    }

    public void findMaximalCliques() {
        maxCliques = new HashSet<>();

        boolean[] visited = new boolean[numberOfPersons + 1];
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= numberOfPersons; i++) {
            candidates.add(i);
        }

        findCliques(visited, new ArrayList<>(), candidates);


        System.out.println("Maximal Cliques:");
        for (Set<Integer> clique : maxCliques) {
            System.out.print("{ ");
            for (int index : clique) {
                System.out.print(matrix[index][0] + ", ");
            }
            System.out.println("}");
        }
    }

    private void findCliques(boolean[] visited, List<Integer> currentClique, List<Integer> candidates) {
        if (candidates.isEmpty()) {
            maxCliques.add(new HashSet<>(currentClique));
            return;
        }

        List<Integer> candidatesArray = new ArrayList<>(candidates);
        for (int i : candidatesArray) {
            List<Integer> newCandidates = new ArrayList<>();
            for (int j : candidatesArray) {
                if (matrix[i][j] != null) {
                    if (i != j && matrix[i][j].equals("true") && !visited[j]) {
                        newCandidates.add(j);
                    }
                }
            }

            currentClique.add(i);
            visited[i] = true;
            findCliques(visited, currentClique, newCandidates);
            currentClique.remove(currentClique.size() - 1);
            visited[i] = false;
            candidates.remove(Integer.valueOf(i));
        }
    }

    @Override
    public void execute() throws IOException {
        try (FileInputStream inputStream = new FileInputStream(new File(pathForXlsxFile));
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                numberOfPersons++;
                Cell nameCell = row.getCell(0);
                Cell abilitiesCell = row.getCell(1);

                String name = nameCell.getStringCellValue();
                persons.add(name);
                String[] abilitiesArray = abilitiesCell.getStringCellValue().split(",");

                List<String> abilities = Arrays.asList(abilitiesArray);

                abilitiesForEachPerson.put(name, abilities);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printAllAbilitiesForAllPersons();
        createGraph();
        System.out.println("-------------------------------------------");
        findMaximalCliques();
    }
}
