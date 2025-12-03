package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Stack;

public class Day3_Full {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day3_ip.txt"; // Replace with your file path
        BigInteger totalJoltage = BigInteger.ZERO;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String maxNumber = findMax12Digit(line, 12);
                totalJoltage = totalJoltage.add(new BigInteger(maxNumber));
//                System.out.println(line + " -> " + maxNumber);
            }
            System.out.println("2025 day 3 full result : " + totalJoltage);
        } catch (Exception ignored) {
            System.out.println("2025 day 3 full Exception occurred!!!");
        }
    }

    private static String findMax12Digit(String bank, int keepCount) {
        int n = bank.length();
        int removeCount = n - keepCount; // How many digits to remove

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char current = bank.charAt(i);

            // Remove smaller digits from stack if we can still afford to remove them
            while (!stack.isEmpty() &&
                    stack.peek() < current &&
                    removeCount > 0) {
                stack.pop();
                removeCount--;
            }

            stack.push(current);
        }

        // If we still need to remove digits, remove from the end
        while (removeCount > 0) {
            stack.pop();
            removeCount--;
        }

        // Build result from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
