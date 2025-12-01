package aoc2024.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day13 {

    public static void main(String[] args) {
        String input = "src/aoc2024/input/files/day13_ip.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line; int i = 0;
            int a1 = 0, a2 = 0, b1 = 0, b2  = 0, c1 = 0, c2 = 0;
            while (i < 1280) {
                line = br.readLine();
                Pattern pattern;
                Matcher matcher;

                // Check if the pattern matches
                if (line.contains("Button A:")) {
                    pattern = Pattern.compile("X\\+(\\d+),\\s*Y\\+(\\d+)");
                    matcher = pattern.matcher(line);
                    a1 = Integer.parseInt(matcher.group(1).replace("X+", ""));
                    a2 = Integer.parseInt(matcher.group(2).replace("Y+", ""));
                } else if (line.contains("Button B:")) {
                    pattern = Pattern.compile("X\\+(\\d+),\\s*Y\\+(\\d+)");
                    matcher = pattern.matcher(line);
                    b1 = Integer.parseInt(matcher.group(1).replace("X+", ""));
                    b2 = Integer.parseInt(matcher.group(2).replace("Y+", ""));
                } else {
                    pattern = Pattern.compile("X=(\\d+),\\s*Y=(\\d+)");
                    matcher = pattern.matcher(line);
                    c1 = Integer.parseInt(matcher.group(1).replace("X=", ""));
                    c2 = Integer.parseInt(matcher.group(2).replace("Y=", ""));
                }
                i++;

                // Elimination method to solve for a and b
                int determinant = a1 * b2 - a2 * b1;

                if (determinant == 0) {
                    System.out.println("No unique solution exists.");
                } else {
                    // Calculate a and b
                    if ((c1 * b2 - c2 * b1) % determinant == 0) {
                        int a = (c1 * b2 - c2 * b1) / determinant;
                    }
                    if ((a1 * c2 - a2 * c1) % determinant == 0) {
                        int b = (a1 * c2 - a2 * c1) / determinant;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
