package com.hello;

public class GridSearch {
    public static String gridSearch(String[] G, String[] P) {
        if (G == null || G.length <= 0 || P == null || P.length <= 0 || G.length < P.length) {
            return "NO";
        }

        for (int i = 0; i < G.length - P.length; i++) {
            for (int j = 0; j < G[0].length() - P[0].length(); j++) {
                // Match the pattern
                boolean matched = true;
                for (int u = 0; u < P.length; u++) {
                    for (int v = 0; v < P[0].length(); v++) {
                        if (G[i + u].charAt(j + v) != P[u].charAt(v)) {
                            matched = false;
                            break;
                        }
                    }
                }

                if (matched) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
