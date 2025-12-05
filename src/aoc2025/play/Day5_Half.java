package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day5_Half {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day5_ip.txt"; // Replace with your file path
        List<long[]> ranges = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean readingRanges = true;
           while ((line = br.readLine()) != null) {
               line = line.trim();

               if (line.isEmpty()) {
                   readingRanges = false; // Empty line separates ranges from numbers
                   continue;
               }

               if (readingRanges && line.contains("-")) {
                   String[] parts = line.split("-");
                   long start = Long.parseLong(parts[0].trim());
                   long end = Long.parseLong(parts[1].trim());
                   ranges.add(new long[]{start, end});
               } else if (!line.contains("-") && line.matches("\\d+")) {
                   numbers.add(Long.parseLong(line));
               }
            }
        } catch (Exception ignored) {
            System.out.println("2025 day 5 Half Exception occurred!!!");
        }

        // Count valid numbers
        int validCount = 0;
        for (long num : numbers) {
            for (long[] range : ranges) {
                if (num >= range[0] && num <= range[1]) {
                    validCount++;
                    break; // Number is valid, no need to check other ranges
                }
            }
        }

        System.out.println("2025 day 5 first half result : " + validCount);
    }

}
