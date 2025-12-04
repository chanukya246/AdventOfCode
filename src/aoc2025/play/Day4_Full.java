package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day4_Full {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day4_ip.txt"; // Replace with your file path
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read into dynamic list first
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            // Convert to 2D array
            int rows = lines.size();
            int cols = lines.getFirst().length();
            char[][] grid = new char[rows][cols];

            for (int r = 0; r < rows; r++) {
                grid[r] = lines.get(r).toCharArray();
            }

            int totalRemoved = removeAllAccessibleRolls(grid);
            System.out.println("2025 day 4 full result: " + totalRemoved);

        } catch (Exception ignored) {
            System.out.println("2025 day 4 full Exception occurred!!!");
        }
    }

    private static int removeAllAccessibleRolls(char[][] grid) {
        int totalRemoved = 0;
        int removed;

        // Keep removing until no more can be removed
        do {
            removed = removeAccessibleRolls(grid);
            totalRemoved += removed;
        } while (removed > 0);

        return totalRemoved;
    }

    private static int removeAccessibleRolls(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<int[]> toRemove = new ArrayList<>();

        // 8 directions: N, S, E, W, NE, NW, SE, SW
        int[][] directions = {
                {-1, 0},  // North
                {1, 0},   // South
                {0, -1},  // West
                {0, 1},   // East
                {-1, -1}, // NW
                {-1, 1},  // NE
                {1, -1},  // SW
                {1, 1}    // SE
        };

        // Find all accessible rolls in this iteration
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '@') {
                    int adjacentRolls = countAdjacent(grid, r, c, directions);
                    if (adjacentRolls < 4) {
                        toRemove.add(new int[]{r, c});
                    }
                }
            }
        }

        // Remove all at once
        for (int[] pos : toRemove) {
            grid[pos[0]][pos[1]] = '.';
        }

        return toRemove.size();
    }

    private static int countAdjacent(char[][] grid, int row, int col, int[][] directions) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] == '@') {
                count++;
            }
        }

        return count;
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}
