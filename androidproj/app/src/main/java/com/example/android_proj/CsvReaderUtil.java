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
    public static void readCsv(String filePath) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            Map<String, List<Map<String, String>>> multimap = new HashMap<>();

            // Read in data from file or other source, and split into rows
            List<String[]> rows = reader.readAll();

            // Loop through rows and split into columns
            for (String[] row : rows) {
                for (String rowData : row) {
                    String[] columns = rowData.split(",");

                    // Create a new Map to hold the data for this row
                    Map<String, String> rowMap = new HashMap<>();
                    rowMap.put("tutorLast", columns[1]);
                    rowMap.put("tutorFirst", columns[2]);
                    rowMap.put("location", columns[4]);
                    rowMap.put("time", columns[5]);

                    // Get the course code for this row
                    String courseCode = columns[0];

                    // If this course code isn't already in the multimap, add it with an empty List
                    List<Map<String, String>> courseData = multimap.get(courseCode);
                    if (courseData == null) {
                        courseData = new ArrayList<>();
                        multimap.put(courseCode, courseData);
                    }
                    courseData.add(rowMap);
                }
            }

            // Filter the data for each course code
            for (String courseCode : multimap.keySet()) {
                filterByCourse(courseCode, multimap);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, String>> filterByCourse(String courseCode, Map<String, List<Map<String, String>>> multimap) {
        List<Map<String, String>> filteredData = multimap.get(courseCode);
        if (filteredData == null) {
            filteredData = new ArrayList<>();
        }
        return filteredData;
    }
}









