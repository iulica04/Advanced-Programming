import Exceptions.InvalidCommandException;

import java.io.IOException;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter command (view, report, or export): ");
        String command = scanner.nextLine();

        try {
            switch (command) {
                case "view":
                    System.out.print("Enter document path: ");
                    String docPath = scanner.nextLine();
                    new View(docPath).execute();
                    break;
                case "report":
                    System.out.print("Enter repository path: ");
                    String repoPath = scanner.nextLine();
                    new Report(new Repository(repoPath)).execute();
                    break;
                case "export":
                    System.out.print("Enter output path for JSON file: ");
                    String outputPath = scanner.nextLine();
                    System.out.print("Enter repository path: ");
                    String repositoryPath = scanner.nextLine();
                    new Export(outputPath, new Repository(repositoryPath)).execute();
                    break;
                default:
                    throw new InvalidCommandException("Invalid command: " + command);
            }
        } catch (IOException | InvalidCommandException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}