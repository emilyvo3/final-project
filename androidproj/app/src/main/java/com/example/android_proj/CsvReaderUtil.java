package com.example.android_proj;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReaderUtil {
    public static void readCsv(String filePath, String coursesList) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            Map<String, List<Map<String, String>>> multimap = new HashMap<>();

// Read in data from file or other source, and split into rows
            List<String[]> rows = reader.readAll();

// Loop through rows and split into columns
            for (String[] row : rows) {
                for(String rowData : row) {
                    String[] columns = rowData.split(",");

                    // Create a new Map to hold the data for this row
                    Map<String, String> rowMap = new HashMap<>();
                    rowMap.put("instructorLast", columns[1]);
                    rowMap.put("instructorFirst", columns[2]);
                    rowMap.put("location1", columns[4]);
                    // ... and so on for all columns

                    // Get the course code for this row
                    String courseCode = columns[0];

                    // If this course code isn't already in the multimap, add it with an empty List
                    if (!multimap.containsKey(courseCode)) {
                        multimap.put(courseCode, new ArrayList<>());
                    }

                    // Add the row data to the List for this course code
                    multimap.get(courseCode).add(rowMap);
                }
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

    }


}
