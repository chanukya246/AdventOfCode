package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day1_Full {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day1_ip.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int countZero = 0, currPos = 50;
            while ((line = br.readLine()) != null) {
                char direction = line.charAt(0);     // 'R' or 'L'
                int distance = Integer.parseInt(line.substring(1));

                int oldPos = currPos;

                if (direction == 'L') {
                    currPos -= distance;
                } else if (direction == 'R') {
                    currPos += distance;
                }

                int zeroCrossings = countZeroCrossings(oldPos, currPos);
                countZero += zeroCrossings;

                currPos = ((currPos % 100) + 100) % 100;

            }
            System.out.println("2025 day 1 full result : " + countZero);
        } catch (Exception ignored) {
            System.out.println("2025 day 1 full Exception occurred!!!");
        }
    }

    private static int countZeroCrossings(int oldPos, int newPos) {
        if (oldPos == newPos) {
            return 0;
        }
        // The key insight: count how many times we cross a multiple of 100

        if (newPos >= oldPos) {
            /// Moving right
            // Count multiples of 100 in the range (oldPos, newPos]
            // We include newPos if it's a multiple, exclude oldPos
            return (newPos / 100 - oldPos / 100);
        } else {
            // Moving left
            // Count multiples of 100 in the range [newPos, oldPos)
            // We include newPos if it's a multiple, exclude oldPos

            // Use Math.floorDiv to handle negatives correctly
            return Math.floorDiv(oldPos - 1, 100) - Math.floorDiv(newPos - 1, 100);
        }
    }

}
