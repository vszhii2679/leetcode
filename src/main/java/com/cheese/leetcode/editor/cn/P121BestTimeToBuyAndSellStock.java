package com.cheese.leetcode.editor.cn;

/*
Java：买卖股票的最佳时机
------------------------
//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// 👍 2758 👎 0

 */
public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
        solution.maxProfit(new int[]{1,2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            return maxProfit_(prices);
        }

        /**
         * 一次循环：loop once
         * 假定当前价格是最低价格，计算利润，保留最大值
         * 最优解
         *
         *
         * @param prices
         * @return
         */
        public int maxProfit_(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                int price = prices[i];
                //更新最低价
                if (price < minPrice) {
                    minPrice = price;
                }
                //更新最大利润
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
            return maxProfit;
        }

        /**
         * 指针 暴力解法 双循环
         * n代表最低价时候的角标
         * m代表最高价时候的角标
         * 条件 n < m
         * 返回 prices[m] - prices[n] > 0 ? prices[m] - prices[n] : 0
         * 同时找出最大值和最小值对应的角标
         *
         *
         * @param prices
         * @return
         */
        public int maxProfit_simple(int[] prices) {
            int maxProfit = 0;
            for (int n = 0; n < prices.length; n++) {
                compareLoop:
                for (int m = n + 1; m < prices.length; m++) {
                    int profit = prices[m] - prices[n];
                    if (profit < 0) {
                        continue compareLoop;
                    } else if (maxProfit < profit){
                        maxProfit = profit;
                    }
                }
            }
            return maxProfit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
