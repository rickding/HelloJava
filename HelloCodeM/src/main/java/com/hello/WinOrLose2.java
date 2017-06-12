package com.hello;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by user on 2017/6/11.
 */
public class WinOrLose2 {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        ArrayList<Long> ar = new ArrayList<Long>(1024);

        while (n-- > 0 && sc.hasNextLong()) {
            ar.add(sc.nextLong());
        }

        sc.close();

        System.out.println(calculateLoop(ar, 0, ar.size() - 1));
    }

    /**
     * Check how far the first person can go, the scope is [start, end]
     * @param ar
     * @param start
     * @param end
     * @return
     */
    public static int calculateLoop(ArrayList<Long> ar, int start, int end) {
        int n = end - start + 1;
        if (n <= 1 || (n & (n - 1)) != 0) {
            return 0;
        }

        // Return if it loses, or it is the last loop.
        int win = winOrLose(ar.get(start), ar.get(start + 1));
        if (win == 0 || n == 2) {
            return win;
        }

        // Continue the left ones
        int index = start + 1;
        for (int i = start + 2; i < end; i += 2) {
            Long first = ar.get(i), second = ar.get(i + 1);
            win = winOrLose(first, second);
            ar.set(index++, (win == 1) ? first : second);
        }

        // Start the next loop
        return 1 + calculateLoop(ar, start, index - 1);
    }

    /**
     * Decide if the first one wins or loses
     * @param first
     * @param second
     * @return
     */
    public static int winOrLose(long first, long second) {
        // Compare the scores
        if (first > second)
            return 1;
        else if (first < second)
            return 0;

        // Select one randomly if the scores are same.
        return random.nextBoolean() ? 1 : 0;
    }
}