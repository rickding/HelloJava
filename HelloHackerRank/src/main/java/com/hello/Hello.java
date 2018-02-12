package com.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hello {
    public static long findMax(int n, String tree) {
        if (n <= 0 || tree == null || tree.trim().length() <= 0) {
            return 0;
        }

        // Split the nodes
        String[] nodes = tree.trim().split(" ");
        if (nodes.length < n) {
            return 0;
        }

        // Count the nodes
        List<Long> sumList = new ArrayList<Long>();
        int countExpected = 1;
        int count = 0;
        int index = 0;
        long sum = 0;
        for (int i = 0; i < nodes.length; i++) {
            String node = nodes[i];
            if (!node.equals("#")) {
                count++;
                sum += Long.valueOf(node);
            }
            index++;

            // Check if next level starts
            if (index >= countExpected) {
                sumList.add(sum);
                countExpected = (int)Math.pow(2, count);

                count = 0;
                index = 0;
                sum = 0;
            }
        }

        // Find the max sum
        Long[] sumArr = new Long[sumList.size()];
        sumList.toArray(sumArr);
        return findMax(sumArr, 0);
    }

    public static long findMax(Long[] sumArr, int startIndex) {
        if (sumArr == null || sumArr.length <= startIndex || startIndex < 0) {
            return 0;
        }

        // Find the max sum
        long max = 0;
        for (int i = startIndex; i < sumArr.length; i++) {
            // Itself
            long sum = sumArr[i];
            if (max < sum) {
                max = sum;
            }

            // Plus later ones
            for (int j = i + 2; j < sumArr.length; j++) {
                sum = sumArr[i] + findMax(sumArr, j);
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static String electionWinner(String[] votes) {
        if (votes == null || votes.length <= 0) {
            return null;
        }

        // Count the vote
        Map<String, Integer> voteCountMap = new HashMap<String, Integer>();
        int maxCount = 0;
        for (String vote : votes) {
            String tmp = vote.trim();
            int count = 1 + (voteCountMap.containsKey(tmp) ? voteCountMap.get(tmp) : 0);
            voteCountMap.put(tmp, count);

            // Remember the max count
            if (maxCount < count) {
                maxCount = count;
            }
        }

        // Get the candidates with max count votes
        List<String> candidates = new ArrayList<String>();
        for (Map.Entry<String, Integer> voteCount : voteCountMap.entrySet()) {
            if (voteCount.getValue() == maxCount) {
                candidates.add(voteCount.getKey());
            }
        }

        if (candidates.size() <= 0) {
            return null;
        } else if (candidates.size() == 1) {
            return candidates.get(0);
        }

        // Sort alphabetically and get the last one
        String[] candidatesArr = new String[candidates.size()];
        candidates.toArray(candidatesArr);
        Arrays.sort(candidatesArr);
        return candidatesArr[candidatesArr.length - 1];
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
        }};

        System.out.println(map.toString());
        System.out.println(map.keySet().toString());
    }

    public static int[] arbitrage(String[] quotes) {
        if (quotes == null || quotes.length <= 0) {
            return null;
        }

        int[] profits = new int[quotes.length];
        for (int i = 0; i < quotes.length; i++) {
            // Get the prices
            double[] prices = parseQuote(quotes[i]);

            // Calculate
            int profit = 0;
            if (prices != null) {
                double dollar = 100000;
                for (int j = 0; j < prices.length; j++) {
                    dollar /= prices[j];
                }
                profit = (int) dollar - 100000;
                if (profit < 0) {
                    profit = 0;
                }
            }
            profits[i] = profit;
        }
        return profits;
    }

    static double[] parseQuote(String quote) {
        if (quote == null || quote.trim().length() <= 0) {
            return null;
        }

        // Split the prices
        String[] prices = quote.trim().split(" ");
        if (prices.length != 3) {
            return null;
        }

        // Convert to double
        double[] results = new double[prices.length];
        for (int i = 0; i < prices.length; i++) {
            try {
                results[i] = Double.valueOf(prices[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
        }
        return results;
    }
}
