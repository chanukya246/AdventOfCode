package aoc2024.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2A {

    public static void main(String[] args) {
        String filePath = "src/aoc2024/input/files/day2a_ip.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            int safeReports = 0;
            while ((line = br.readLine()) != null && i < 1000) {
                String[] str = line.split(" ");
                boolean ascending = false, descending = false;
                if (str.length > 1 && (Integer.parseInt(str[0]) > Integer.parseInt(str[1]))
                        && Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[1])) > 0
                        && Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[1])) < 4) {
                    descending = true;
                } else if (str.length > 1 && (Integer.parseInt(str[0]) < Integer.parseInt(str[1]))
                        && Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[1])) > 0
                        && Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[1])) < 4) {
                    ascending = true;
                }

                if (ascending) {
                    for (int j = 1; j < str.length; j++) {
                        int prev = Integer.parseInt(str[j - 1]);
                        int curr = Integer.parseInt(str[j]);
                        int abs = Math.abs(curr - prev);
                        if (!((prev < curr) && abs > 0 && abs < 4)) {
                            ascending = false;
                            break;
                        }
                    }
                } else if (descending) {
                    for (int j = 1; j < str.length; j++) {
                        int prev = Integer.parseInt(str[j - 1]);
                        int curr = Integer.parseInt(str[j]);
                        int abs = Math.abs(curr - prev);
                        if (!((prev > curr) && abs > 0 && abs < 4)) {
                            descending = false;
                            break;
                        }
                    }
                }
                i++;
                if (ascending || descending) {
                    safeReports++;
                }
            }
            System.out.println("safeReports: " + safeReports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
