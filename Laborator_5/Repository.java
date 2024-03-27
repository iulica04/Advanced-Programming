import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Repository {
    private final String directory;
    private final Map<Person, List<Document>> documents = new HashMap<>();

    public Repository(String directory) {
        this.directory = directory;
        loadDocuments();
    }

    private void loadDocuments() {
        try {
            Files.walkFileTree(Paths.get(directory), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!dir.equals(Paths.get(directory))) {
                        Person person = parsePerson(dir.getFileName().toString());
                        List<Document> personDocuments = new ArrayList<>();
                        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                            for (Path file : stream) {
                                personDocuments.add(parseDocument(file.getFileName().toString()));
                            }
                        } catch (IOException e) {
                            System.err.println("Error parsing documents: " + e.getMessage());
                        }
                        documents.put(person, personDocuments);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error loading documents: " + e.getMessage());
        }
    }


    private Person parsePerson(String directoryName) {
        String[] parts = directoryName.split("_");
        if (parts.length == 2) {
            int id = Integer.parseInt(parts[1]);
            if (id > 0) {
                return new Person(parts[0], id);
            } else {
                throw new InvalidDirectoryNameException("Id must to be a positive and not null number.");
            }
        } else {
            // return new Document("?", "?")
            throw new InvalidDirectoryNameException("Invalid directory name.");
        }
    }


    private Document parseDocument(String fileName) {
        String[] parts = fileName.split("\\.");
        if (parts.length == 2) {
            return new Document(parts[0], parts[1]);
        } else {
            // return new Document("?", "?")
            throw new InvalidDocumentException("Invalid document: " + fileName);
        }
    }

    public void displayRepositoryContent() {
        for (Map.Entry<Person, List<Document>> entry : documents.entrySet()) {
            System.out.println("Person: " + entry.getKey().name() + "_" + entry.getKey().id());
            System.out.println("Documents:");
            for (Document document : entry.getValue()) {
                System.out.println("  - " + document.name() + "." + document.format());
            }
        }
    }
}
