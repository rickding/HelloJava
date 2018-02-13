package com.hello;

public class ZombieCluster {
    static int zombieCluster(String[] zombieArr) {
        if (zombieArr == null || zombieArr.length <= 0) {
            return 0;
        }

        // Convert to matrics
        int len = zombieArr.length;
        boolean[][] zombieMatric = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            int j = 0;
            for (char c : zombieArr[i].toCharArray()) {
                zombieMatric[i][j++] = (c == '1');
            }
        }

        // Find and mark the connections
        markCluster(zombieMatric, len, 0);

        // Count the lead zombies, which show the clusters
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (zombieMatric[i][i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Mark the connected zombies
     * @param zombieMatric
     * @param n
     * @param index
     */
    static void markCluster(boolean[][] zombieMatric, int n, int index) {
        if (zombieMatric == null || n <= 0 || index < 0 || index >= n) {
            return;
        }

        // Find and mark the connections
        for (int i = index; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }

                if (zombieMatric[i][j]) {
                    zombieMatric[i][j] = false;
                    zombieMatric[j][i] = false;
                    zombieMatric[j][j] = false;

                    // Continue to connect
                    markCluster(zombieMatric, n, j);
                }
            }
        }
    }
}
