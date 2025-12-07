package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day6_Full {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day6_ip.txt"; // Replace with your file path
        List<List<Integer>> numbersList = new ArrayList<>();
        List<String> operands = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("2025 day 6 Full result : YET to be released");
            }
        } catch (Exception ignored) {
            System.out.println("2025 day 6 Full Exception occurred!!!");
        }
    }

}
