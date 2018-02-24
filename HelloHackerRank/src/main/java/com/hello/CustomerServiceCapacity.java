package com.hello;

import java.util.Arrays;

public class CustomerServiceCapacity {
    public static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        if (callsTimes == null || callsTimes.length <= 0) {
            return 0;
        }

        // Convert to classes and sort
        Call[] calls = new Call[callsTimes.length];
        for (int i = 0; i < calls.length; i++) {
            calls[i] = new Call(callsTimes[i][0], callsTimes[i][1]);
        }
        Arrays.sort(calls);

        // Count the overlapped ones
        for (int i = 0; i < calls.length - 1; i++) {
            for (int j = i + 1; j < calls.length; j++) {
                if (calls[i].isOverlap(calls[j])) {
                    calls[i].addCount();
                } else {
                    break;
                }
            }
        }

        // Find the max count
        int max = calls[0].count;
        for (int i = 1; i < calls.length; i++) {
            if (max < calls[i].count) {
                max = calls[i].count;
            }
        }

        // Return the needed new agents
        if (max <= noOfCurrentAgents) {
            return 0;
        }
        return max - noOfCurrentAgents;
    }

    public static class Call implements Comparable {
        long start;
        long end;
        int count;

        public Call(long start, long end) {
            this.start = start;
            this.end = end;
            this.count = 1;
        }

        public void addCount() {
            this.count++;
        }

        public boolean isOverlap(Call o) {
            if (o == null) {
                return false;
            }
            return !(this.start > o.end || this.end < o.start);
        }

        public int compareTo(Object o) {
            if (o instanceof Call) {
                Call obj = (Call) o;
                long diff = this.start - obj.start;
                if (diff == 0) {
                    diff = this.end - obj.end;
                }
                return diff == 0 ? 0 : (diff > 0 ? 1 : -1);
            }
            return 0;
        }
    }
}
