import java.awt.*;
import java.io.File;
import java.io.IOException;

public class View implements Command {
    /*opens a document using the native operating system application*/
    private final String documentPath;

    public View(String documentPath) {
        this.documentPath = documentPath;
    }

    @Override
    public void execute() throws IOException {
        if (!Desktop.isDesktopSupported()) {
            System.err.println("Desktop is not supported on this platform.");
            return;
        }
        File documentFile = new File(documentPath);

        if (!documentFile.exists()) {
            System.err.println("File does not exist: " + documentPath);
            return;
        }


        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(documentFile);
            System.out.println("Document opened successfully.");
        } catch (IOException e) {
            System.err.println("Error opening document: " + e.getMessage());
        }
    }
}
