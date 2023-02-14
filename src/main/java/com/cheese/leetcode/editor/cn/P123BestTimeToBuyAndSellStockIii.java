package com.cheese.leetcode.editor.cn;

/*
Java：买卖股票的最佳时机 III
------------------------
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// 👍 1325 👎 0

 */
public class P123BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new P123BestTimeToBuyAndSellStockIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            return maxProfit_(prices);
        }


        /**
         * 动态规划：求最优解的一种思想，需要将过程中的状态记录下来
         * <p>
         * 状态：时间、购买状态
         *
         * @param prices
         * @return
         */
        public int maxProfit_(int[] prices) {
            int buy1 = prices[0], sell1 = 0;
            int buy2 = prices[0], sell2 = 0;
            for (int i = 1; i < prices.length; i++) {
                //购入点取最小值
                buy1 = Math.min(buy1, prices[i]);
                //售出点取最大值
                sell1 = Math.max(sell1, prices[i] - buy1);
                //二次购买时购买价格取最小值 若price[i]越小，sell1 - prices[i] 越大 也就是利润越大
                buy2 = Math.min(buy2, -(sell1 - prices[i]));
                //第二次卖出的利润 = price[sell1] + price[sell2] - price[buy1] - price[buy2]
                sell2 = Math.max(sell2, prices[i] - buy2);
            }
            return sell2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
