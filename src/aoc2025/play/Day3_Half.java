package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day3_Half {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day3_ip.txt"; // Replace with your file path
        int totalJoltage = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int maxJoltage = findMaxJoltage(line);
                totalJoltage += maxJoltage;
            }
            System.out.println("2025 day 3 first half result : " + totalJoltage);
        } catch (Exception ignored) {
            System.out.println("2025 day 3 first half Exception occurred!!!");
        }
    }

    private static int findMaxJoltage(String bank) {
        int max = 0;
        int n = bank.length();

        // Check all pairs (i, j) where i < j
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int joltage = (bank.charAt(i) - '0') * 10 + (bank.charAt(j) - '0');
                max = Math.max(max, joltage);
            }
        }

        return max;
    }

}
