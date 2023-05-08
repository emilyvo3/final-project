package com.example.android_proj;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReaderUtil {
    public static void readCsv(String filePath, String coursesList) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> rows = reader.readAll();

            // Iterate over each row
            for (String[] row : rows) {
                // Access individual columns using array indices
                String course = row[0];
                String student = row[2];
                String location = row[3];
                String time = row[4];

                // Check if course matches coursesList
                if (course.equals(coursesList)) {
                    // Process the data as needed
                    // ...
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
