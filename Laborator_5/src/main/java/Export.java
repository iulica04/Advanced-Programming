import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Export implements Command {
    private final String outputPath;
    private final Repository repository;

    public Export(String outputPath, Repository repository) {
        this.outputPath = outputPath;
        this.repository = repository;
    }

    @Override
    public void execute() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File outputFile = new File(outputPath); // trebuie sa se sspecifice si fisierul
        try {
            objectMapper.writeValue(outputFile, repository.getCastDocumentsToString());
            System.out.println("Repository exported successfully to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error exporting repository: " + e.getMessage());
        }
    }
}
