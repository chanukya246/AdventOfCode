package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day1_Half {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day1_ip.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int countZero = 0, currPos = 50;
            while ((line = br.readLine()) != null) {
                char direction = line.charAt(0);     // 'R' or 'L'
                int distance = Integer.parseInt(line.substring(1));

                if (direction == 'L') {
                    currPos -= distance;
                } else if (direction == 'R') {
                    currPos += distance;
                }

                currPos = ((currPos % 100) + 100) % 100;
                if (currPos == 0) {
                    countZero++;
                }

            }
            System.out.println("2025 day 1 first half result : " + countZero);
        } catch (Exception ignored) {
            System.out.println("2025 day 1 first half Exception occurred!!!");
        }
    }

}
