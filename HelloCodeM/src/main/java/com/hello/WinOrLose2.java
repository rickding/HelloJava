package com.hello;

import java.util.*;

/**
 * Created by user on 2017/6/11.
 */
public class WinOrLose2 {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        List<Long> ar = new ArrayList<Long>(1024);

        // Scan the scores.
        while (n-- > 0 && sc.hasNextLong()) {
            ar.add(sc.nextLong());
        }

        sc.close();

        // Calculate the loops
        System.out.println(calculateLoop(ar));
    }

    /**
     * Check how far the first person can go
     *
     * @param ar
     * @return
     */
    public static int calculateLoop(List<Long> ar) {
        int n = ar.size();
        if (n <= 1 || (n & (n - 1)) != 0) {
            return 0;
        }

        // Compare the first score and find loops with the left ones.
        Iterator<Long> iterator = ar.iterator();
        long score = iterator.next();
        long index = 0;
        long mark = 1;
        int loop = 0;

        while (iterator.hasNext()) {
            if (winOrLose(score, iterator.next()) == 1) {
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

        return loop;
    }

    /**
     * Check how far the first person can go, the scope is [start, end]
     * @param ar
     * @return
     */
    /*
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
    }*/

    /**
     * Decide if the first one wins or loses
     *
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