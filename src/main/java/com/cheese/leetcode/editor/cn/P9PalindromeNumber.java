package com.cheese.leetcode.editor.cn;

/*
Java：回文数
------------------------
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2368 👎 0

 */
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
        boolean palindrome = solution.isPalindrome(123);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：取余取模
        public boolean isPalindrome(int x) {
            return isPalindrome_3(x);
        }

        /**
         * 数字翻转，数学方法
         * 效率最高
         * 最优解
         *
         * @param x
         * @return
         */
        public boolean isPalindrome_3(int x) {
            //8ms 37.9MV
            int backup = x;

            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            if (x % 10 == 0) {
                return false;
            }
            int revertX = 0;
            while (x > 0) {
                //每次获取末尾，下次进制10+末尾，得到翻转结果
                revertX = revertX * 10 + x % 10;
                x /= 10;
            }
            if (revertX != backup) {
                return false;
            }
            return true;
        }

        /**
         * stringBuilder翻转比较，全等才判断对称
         *
         * @param x
         * @return
         */
        public boolean isPalindrome_1(int x) {
            //11ms 38.3MB
            //回文：如果为负数一定不对称
            if (x < 0) {
                return false;
            }
            if (10 > x) {
                return true;
            }
            if (x % 10 == 0) {
                return false;
            }
            String origin = String.valueOf(x);
            //使用stringBuilder的reverse判断是否与原数字相等，如果相等则是回文
            StringBuilder sb = new StringBuilder(origin);
            if (origin.equals(sb.reverse().toString())) {
                return true;
            }
            return false;
        }

        /**
         * 对应字符位比对
         *
         * @param x
         * @return
         */
        public boolean isPalindrome_2(int x) {
            //10ms 37.8MV
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            if (x % 10 == 0) {
                return false;
            }
            //将数组转换为数组处理，判断
            String origin = String.valueOf(x);
            int i = 0;
            while (i <= (origin.length() / 2)) {
                char fir = origin.charAt(i);
                char las = origin.charAt(origin.length() - i - 1);
                if (fir != las) {
                    return false;
                }
                i += 1;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
