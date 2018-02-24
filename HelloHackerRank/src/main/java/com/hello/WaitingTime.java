package com.hello;

public class WaitingTime {
    public static long waitingTime(int[] tickets, int p) {
        if (tickets == null || tickets.length <= 0 || p < 0 || p >= tickets.length) {
            return -1;
        }

        int count = 0;
        int ticket = tickets[p];
        for (int i = 0; i < tickets.length; i++) {
            int tmp = tickets[i];
            if (tmp < ticket) {
                count += tmp;
            } else {
                count += ticket;
                if (i > p) {
                    count--;
                }
            }
        }
        return count;
    }
}
