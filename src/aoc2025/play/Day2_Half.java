package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day2_Half {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day2_ip.txt"; // Replace with your file path
        long totalSum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                for (String str : strs) {
                    String[] longs = str.split("-");
                    long left = Long.parseLong(longs[0]);
                    long right = Long.parseLong(longs[1]);
                    while (left <= right) {
                        totalSum += isRepeated(left);
                        left++;
                    }
                }
            }
            System.out.println("2025 day 2 first half result : " + totalSum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static long isRepeated(long left) {
        String value = String.valueOf(left);
        if (value.length() % 2 != 0) return 0;
        int mid = value.length() / 2;

        String firstHalf = value.substring(0, mid);
        String secondHalf = value.substring(mid);

        return firstHalf.equalsIgnoreCase(secondHalf) ? left : 0;
    }

}
