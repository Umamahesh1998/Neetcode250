package org.ps2.arrays_hashing;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. However, you can buy it then immediately sell it on the same day. Also, you are allowed to perform any number of transactions but can hold at most one share of the stock at any time.
 * Find and return the maximum profit you can achieve.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 */
public class BestTimetoBuyandSellStockII_122 {
    public static void main(String[] args) {

    }

    /**
     * manam eni sarlu iena sell cheyachu buy cheyachu so
     * we will identify the place previous day price current day kante low vunadi
     * then we will buy there and sell it append the profit
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

}
