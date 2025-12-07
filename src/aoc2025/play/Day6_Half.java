package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6_Half {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day6_ip.txt"; // Replace with your file path
        List<List<Integer>> numbersList = new ArrayList<>();
        List<String> operands = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
           while ((line = br.readLine()) != null) {

               if (line.trim().matches("[*+\\s]+")) {
                   operands = Arrays.stream(line.split(""))
                           .filter(s -> !s.trim().isEmpty())
                           .collect(Collectors.toList());
               } else {
                   // Parse into List<String>
                   List<String> list = Arrays.asList(line.trim().split("\\s+"));

                   // Convert to integers for analysis
                   List<Integer> temp = list.stream()
                           .map(Integer::parseInt)
                           .collect(Collectors.toList());

                   numbersList.add(temp);
               }
           }
        } catch (Exception ignored) {
            System.out.println("2025 day 6 Half Exception occurred!!!");
        }

        long totalSum = 0;

        for (int idx = 0; idx < operands.size(); idx++) {
            String operator = operands.get(idx);

            // Start with the first row's value
            long result = numbersList.get(0).get(idx);

            // Apply operator with remaining rows dynamically
            for (int row = 1; row < numbersList.size(); row++) {
                long currentValue = numbersList.get(row).get(idx);

                if (operator.equalsIgnoreCase("*")) {
                    result *= currentValue;
                } else if (operator.equalsIgnoreCase("+")) {
                    result += currentValue;
                }
            }

            totalSum += result;
        }

        System.out.println("2025 day 6 first half result : " + totalSum);
    }

}
