package org.ps2.stacks;

import java.util.Stack;

/**
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 *
 * The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
 *
 * For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
 * Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
 * Input: ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 *
 * Output: [null, 1, 1, 1, 2, 1, 4, 6]
 */
public class OnlineStockSpan_901_4 {
    Stack<int[]> tracker;
    public OnlineStockSpan_901_4() {
        tracker=new Stack<>();
    }

    /**
     *
     * basic ga ask enti antey we have set of prices we need to check the consecutive days our current day price is >= then previous days prices
     * here we will use Stack<int[]> ans
     * we will store new int[]{price,span}
     * for every price we will check stack peek lo vunna price low vunda leda if yes we will append the span value and insert the new price into stack
     */
    public int next(int price) {
        int span=1;
        while (!tracker.isEmpty()&&tracker.peek()[0]<=price)
            span+=tracker.pop()[1];

        tracker.push(new int[]{price,span});
        return span;
    }

}
