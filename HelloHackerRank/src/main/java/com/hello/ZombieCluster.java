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
        for (int i = 0; i < len; i++) {

        }

        return 0;
    }
}
