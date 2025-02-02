import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Report implements Command {
    /*creates (and opens) an HTML report representing the content of the repository.
Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.*/

    private Repository repository;

    public Report(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() throws IOException {
        Configuration configuration = new Configuration(new Version(2, 3, 25));
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");


        try {
            Template template = configuration.getTemplate("report_template.ftl");

            repository.displayRepositoryContent();

            Map<String, Object> dataModel = new HashMap<>();
            if (repository != null && repository.getDocuments() != null) {
                dataModel.put("foldersAndDocuments", repository.getDocuments());
            } else {
                System.err.println("Repository or documents are empty or null.");
                return;
            }

            String outputPath = "D:\\Advanced-Programming\\Laborator_5\\src\\main\\resources\\Report.html";
            File outputFile = new File(outputPath);

            try {
                if (!outputFile.exists()) {
                    if (!outputFile.createNewFile()) {
                        throw new IOException("Failed to create file: " + outputFile.getAbsolutePath());
                    }
                }
            } catch (SecurityException e) {
                throw new IOException("Permission denied while creating file: " + outputFile.getAbsolutePath());
            }

            try (FileWriter writer = new FileWriter(outputFile)) {
                template.process(dataModel, writer);
                System.out.println("Report generated successfully: " + outputFile.getAbsolutePath());
                new View("D:\\Advanced-Programming\\Laborator_5\\src\\main\\resources\\Report.html").execute();
            } catch (TemplateException e) {
                System.err.println("Error processing template: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error loading template: " + e.getMessage());
        }
    }

}
