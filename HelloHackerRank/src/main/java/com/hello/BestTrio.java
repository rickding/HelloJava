package com.hello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BestTrio {

/*
 * Complete the function below.
 */
/*
    For the unweighted graph:
	1. The number of nodes is <name>_nodes.
	2. The number of edges is <name>_edges.
	3. An edge exists between <name>_from[i] to <name>_to[i].

5 6
1 2
1 3
2 3
2 4
3 4
4 5
2

7 4
2 1
3 6
5 1
1 7
-1
*/

    static int bestTrio(int friends_nodes, int[] friends_from, int[] friends_to) {
        if (friends_nodes < 0 || friends_from == null || friends_to == null || friends_from.length > friends_to.length) {
            return -1;
        }

        // Init
        List<HashSet<Integer>> friends = new ArrayList<HashSet<Integer>>(friends_nodes);
        for (int i = 0; i < friends_nodes; i++) {
            friends.add(new HashSet<Integer>());
        }

        // Scan the edges and store as set
        for (int i = 0; i < friends_from.length; i++) {
            int from = friends_from[i] - 1;
            int to = friends_to[i] - 1;

            friends.get(from).add(to);
            friends.get(to).add(from);
        }

        // Find the trios: i - j - k - i
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < friends.size(); i++) {
            final HashSet<Integer> edges = friends.get(i);
            for (int j : edges) {
                final HashSet<Integer> edgesB = friends.get(j);
                for (int k : edgesB) {
                    final HashSet<Integer> edgesC = friends.get(k);
                    if (edgesC.contains(i)) {
                        // This is a trio
                        List<HashSet> arr = new ArrayList<HashSet>() {{
                           add(edges);
                           add(edgesB);
                           add(edgesC);
                        }};

                        int score = 0;
                        for (HashSet<Integer> u : arr) {
                            HashSet<Integer> trio = new HashSet<Integer>(u);
                            trio.remove(i);
                            trio.remove(j);
                            trio.remove(k);
                            score += trio.size();
                        }

                        if (min > score) {
                            min = score;
                        }
                    }
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }

        return min;
    }
}
