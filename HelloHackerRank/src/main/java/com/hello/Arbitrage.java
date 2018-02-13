package com.hello;

public class Arbitrage {
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
