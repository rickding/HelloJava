package com.hello;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by user on 2017/6/11.
 */
public class WinOrLose {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger();

        // Scan the scores and find the first winner compared with the first one
        long score = sc.nextLong();

        BigInteger index = BigInteger.ZERO;
        BigInteger mark = BigInteger.ONE;
        int loop = 0;

        while (sc.hasNext()) {
            if (winOrLose(score, sc.nextLong()) == 1) {
                index = index.add(BigInteger.ONE);

                int tmp = index.compareTo(mark);
                if (tmp >= 0) {
                    // Start the next loop
                    mark = mark.multiply(new BigInteger("2"));
                    loop++;
                }
            } else {
                break;
            }
        }

        sc.close();

        // Calculate the loops
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
