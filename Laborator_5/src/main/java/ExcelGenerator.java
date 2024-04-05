import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.github.javafaker.Faker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExcelGenerator {

    public static void main(String[] args) {
        Faker fake = new Faker();
        List<List<String>> abilities = new ArrayList<>();
        abilities.add(Arrays.asList("Programming", "Creativity and Innovation"));
        abilities.add(Arrays.asList("Programming", "Data Analysis", "Project Management", "Algorithmic and Computational Thinking"));
        abilities.add(Arrays.asList("Communication", "Programming"));
        abilities.add(Arrays.asList("Data Analysis", "Creativity", "Problem Solving"));
        abilities.add(Arrays.asList("Problem Solving", "Teamwork"));
        abilities.add(Arrays.asList("Algorithmic and Computational Thinking", "Teamwork"));
        abilities.add(Arrays.asList("Algorithmic and Computational Thinking", "Teamwork", "Data Analysis"));
        abilities.add(Arrays.asList("Creativity and Innovation", "Emotional Intelligence and Stress Management"));
        abilities.add(Arrays.asList("Attention to Detail and Precision", "Creativity and Innovation", "Teamwork"));

        Map<String, List<String>> data = IntStream.range(0, 100)
                .mapToObj(index -> {
                    String name = fake.name().fullName();
                    Random random = new Random();
                    int randomNumber = random.nextInt(9);
                    return Map.entry(name, abilities.get(randomNumber));
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        generateExcelFile(data, "Abilities.xlsx");
    }


    public static void generateExcelFile(Map<String, List<String>> data, String outputPath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Persons");

            int rowNum = 0;
            for (Map.Entry<String, List<String>> entry : data.entrySet()) {
                Row row = sheet.createRow(rowNum++);
                int cellNum = 0;

                String name = entry.getKey();
                List<String> abilities = entry.getValue();

                Cell nameCell = row.createCell(cellNum++);
                nameCell.setCellValue(name);

                Cell abilitiesCell = row.createCell(cellNum++);
                abilitiesCell.setCellValue(String.join(", ", abilities));
            }

            try (FileOutputStream outputStream = new FileOutputStream(new File(outputPath))) {
                workbook.write(outputStream);
                System.out.println("Excel file generated successfully: " + outputPath);
                CreateDirectoriesAndFiles create = new CreateDirectoriesAndFiles();
                create.get();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
