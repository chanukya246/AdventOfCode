package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day5_Full {

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
                    readingRanges = false;
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
            System.out.println("2025 day 5 full Exception occurred!!!");
        }

        // Merge overlapping ranges
        ranges.sort(Comparator.comparingLong(a -> a[0]));
        List<long[]> mergedRanges = new ArrayList<>();

        for (long[] range : ranges) {
            if (mergedRanges.isEmpty() || mergedRanges.get(mergedRanges.size() - 1)[1] < range[0] - 1) {
                mergedRanges.add(range);
            } else {
                long[] last = mergedRanges.get(mergedRanges.size() - 1);
                last[1] = Math.max(last[1], range[1]);
            }
        }

        // Calculate total count of IDs in merged ranges
        long totalFreshIngredients = 0;
        for (long[] range : mergedRanges) {
            totalFreshIngredients += (range[1] - range[0] + 1);
        }

        System.out.println("2025 day 5 full result : " + totalFreshIngredients);

    }

}
