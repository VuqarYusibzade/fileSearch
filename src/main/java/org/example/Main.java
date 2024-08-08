package org.example;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\yusib\\IdeaProjects\\HomeWorkFiles\\src\\main\\java\\org\\example\\DriverDate.txt"));

            String line;
            List<Integer> integers = new ArrayList<>();
            List<String> strings = new ArrayList<>();
            List<Date> dates = new ArrayList<>();
            List<String> carNumbers = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                try {
                    if (line.matches("\\d+")) {
                        integers.add(Integer.parseInt(line));
                    } else if (line.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                        Date date = dateFormat.parse(line);
                        dates.add(date);
                    } else if (line.matches("[A-Z0-9]+")) {
                        carNumbers.add(line);
                    } else {
                        strings.add(line);
                    }
                } catch (NumberFormatException | ParseException ignored) {

                }
            }

            bufferedReader.close();


            Collections.sort(integers);
            Collections.sort(strings);
            Collections.sort(dates);
            Collections.sort(carNumbers);


            writeToFile("sortedIntegers.txt", integers);
            writeToFile("sortedStrings.txt", strings);
            writeToFile("sortedDates.txt", dates);
            writeToFile("sortedCarNumbers.txt", carNumbers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String fileName, List<?> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Object obj : data) {
                writer.println(obj.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
