import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateDirectoriesAndFiles {

    public void get() {
        String excelFilePath = "D:\\Advanced-Programming\\Abilities.xlsx";
        String masterDirectoryPath = "D:\\MasterDirectory\\";
        Random random = new Random();
        int nrRandom = random.nextInt(100000) + 100000;

        try (Workbook workbook = new XSSFWorkbook(new File(excelFilePath))) {
            Sheet sheet = workbook.getSheetAt(0);
            Set<String> existingDirectories = new HashSet<>();

            for (Row row : sheet) {
                Cell nameCell = row.getCell(0);
                String name = nameCell.getStringCellValue().trim();

                String directoryName = name.replaceAll("\\s+", "") + "_" + nrRandom;
                nrRandom++;
                File directory = new File(masterDirectoryPath + directoryName);

                if (!existingDirectories.contains(directoryName)) {
                    if (directory.mkdirs()) {
                        System.out.println("Director creat: " + directory.getAbsolutePath());

                        String fileName = "document.pdf";
                        File file = new File(directory, fileName);
                        try {
                            if (file.createNewFile()) {
                                System.out.println("Fișier creat: " + file.getAbsolutePath());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        existingDirectories.add(directoryName);
                    } else {
                        System.out.println("Eroare la crearea directorului: " + directory.getAbsolutePath());
                    }
                }
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
