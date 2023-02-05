package com.internship.Controllers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvController {
    public static void appendDataToCSV(String question,String answer) {
        String user = System.getProperty("user.home");
        String filename = user + File.separator + "Documents" + File.separator + "History.csv";
        File file = new File(filename);
        FileWriter fileWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
                fileWriter = new FileWriter(file);
                fileWriter.append("Question");
                fileWriter.append(";");
                fileWriter.append("Answer");
                fileWriter.append("\n");
            } else {
                fileWriter = new FileWriter(file, true);
            }
            fileWriter.append(question);
            fileWriter.append(";");
            fileWriter.append(answer);
            fileWriter.append("\n");
            System.out.println("Data appended to file successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while appending data to file: " + e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}
