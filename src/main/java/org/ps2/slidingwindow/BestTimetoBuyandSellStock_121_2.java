package org.ps2.slidingwindow;

/**
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
 * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
 * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 * Example 1:
 * Input: prices = [10,1,5,6,7,1]
 * Output: 6
 */
public class BestTimetoBuyandSellStock_121_2 {
    public static void main(String[] args) {

    }

    /**
     * we need to calculate the max profit we can achieve by selling the shares
     * ikkada manam two variables maintain chestam max, min we will initiate them with prices[0]
     * when ever we find element which is min>prices[i] we will assign that value to both min, max
     * when ever we find element which is greater then max --> max<prices[i] we will assign that value to max
     * now we will get the maxprofit value --> maxProfit=Math.max(maxProfit, max-min)
     * return that value
     */
    public int maxProfit(int[] prices) {
        int min = prices[0], max = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                max = prices[i];
            } else if (max < prices[i])
                max = prices[i];

            maxProfit = Math.max(maxProfit, max - min);
        }
        return maxProfit;
    }
}
