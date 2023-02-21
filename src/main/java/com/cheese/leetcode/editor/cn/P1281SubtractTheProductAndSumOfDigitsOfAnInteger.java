package com.cheese.leetcode.editor.cn;

/*
Java：整数的各位积和之差
------------------------
//给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。 
//
// 
//
// 示例 1： 
//
// 输入：n = 234
//输出：15 
//解释：
//各位数之积 = 2 * 3 * 4 = 24 
//各位数之和 = 2 + 3 + 4 = 9 
//结果 = 24 - 9 = 15
// 
//
// 示例 2： 
//
// 输入：n = 4421
//输出：21
//解释： 
//各位数之积 = 4 * 4 * 2 * 1 = 32 
//各位数之和 = 4 + 4 + 2 + 1 = 11 
//结果 = 32 - 11 = 21
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 
//
// 👍 101 👎 0

 */
public class P1281SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        Solution solution = new P1281SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subtractProductAndSum(int n) {
            return subtractProductAndSum_(n);
        }

        /**
         * 简单做法
         *
         * @param n
         * @return
         */
        public int subtractProductAndSum_(int n) {
            //定义积、和
            int mul = 1, sum = 0;
            //获取每一位的值
            int rank = 0;
            while (n > 0) {
                //余数
                int r = n % 10;
                mul *= r;
                sum += r;
                n /= 10;
                rank++;
            }

            return mul - sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
