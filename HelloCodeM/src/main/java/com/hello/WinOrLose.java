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
        BigInteger score = sc.nextBigInteger();
        BigInteger index = BigInteger.ZERO;
        boolean ignore = false;

        while (sc.hasNextLong()) {
            if (!ignore && winOrLose(score, sc.nextBigInteger()) == 1) {
                index.add(BigInteger.ONE);
            } else {
                ignore = true;
            }
        }

        sc.close();

        // Calculate the loops
        System.out.println(index);
    }

    /**
     * Decide if the first one wins or loses
     * @param first
     * @param second
     * @return
     */
    public static int winOrLose(BigInteger first, BigInteger second) {
        // Compare the scores
        int compare = first.compareTo(second);
        if (compare > 0)
            return 1;
        else if (compare < 0)
            return 0;

        // Select one randomly if the scores are same.
        return random.nextBoolean() ? 1 : 0;
    }
}
