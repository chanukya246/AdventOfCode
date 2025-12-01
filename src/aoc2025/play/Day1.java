package aoc2025.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day1 {

    public static void main(String[] args) {
        String filePath = "src/aoc2025/input/files/day1a_ip.txt"; // Replace with your file path
        int[] al1 = new int[1000];
        int[] al2 = new int[1000];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < 1000) {
                String[] temp = line.split("   ");
                al1[i] = Integer.parseInt(temp[0]);
                al2[i] = Integer.parseInt(temp[1]);
                i++;
            }
            Arrays.sort(al1);
            Arrays.sort(al2);
            int result = 0;
            for (int k = 0; k < 1000; k++){
                result += Math.abs(al1[k] - al2[k]);
            }
            System.out.println("result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
