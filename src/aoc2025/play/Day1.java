package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day1 {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day1a_ip.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < 1000) {
                String[] temp = line.split("   ");
                i++;
            }
            System.out.println("2025 day 1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
