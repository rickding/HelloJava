package com.hello;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by user on 2017/6/11.
 */
public class WinOrLose {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        // Scan the first score and find loops with the left ones.
        long score = sc.nextLong();

        // Calculate the loops
        long index = 0;
        long mark = 1;
        int loop = 0;

        while (n-- > 0 && sc.hasNextLine()) {
            if (winOrLose(score, sc.nextLong()) == 1) {
                index++;
                if (index >= mark) {
                    // Start the next loop
                    mark *= 2;
                    loop++;
                }
            } else {
                break;
            }
        }

        sc.close();

        System.out.println(loop);
    }

    /**
     * Decide if the first one wins or loses
     * @param first
     * @param second
     * @return
     */
    public static int winOrLose(long first, long second) {
        // Compare the scores
        final long compare = first - second;
        if (compare > 0)
            return 1;
        else if (compare < 0)
            return 0;

        // Select one randomly if the scores are same.
        return random.nextBoolean() ? 1 : 0;
    }
}
