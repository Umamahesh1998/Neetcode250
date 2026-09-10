package org.rohit_sheet.arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = prices[0], min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min < prices[i]) {
                min = prices[i];
                max = prices[i];
            } else if (max < prices[i]) {
                max = prices[i];
            }
            profit = Math.max(profit, max - min);
        }
        return profit;
    }
}
