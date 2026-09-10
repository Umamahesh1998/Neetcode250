package org.ps1.SlidingWindow;

public class  BestTimetoBuyandSellStock_121_2 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {

        int min = prices[0], max = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                max = prices[i];
            }
            if (max < prices[i])
                max = prices[i];
            profit = Math.max(profit, max - min);
        }
        return profit;
    }
}
/**
 * window has no fixed lenght can expand and shrink as per the requirement
 *
 */
