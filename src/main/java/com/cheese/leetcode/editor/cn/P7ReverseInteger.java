package com.cheese.leetcode.editor.cn;

/*
Java：整数反转
------------------------
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
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
// 👍 3736 👎 0

 */
public class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
        int reverse = solution.reverse(123);
//        System.out.println("reverse = " + reverse);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：数学逻辑 取余取模
        public int reverse(int x) {
            return reverse_2(x);
        }

        /**
         * 总体思想：循环取模，每次取最后一位数进行拼接
         * 但是要注意的是反转的数值有范围限制 -231 <= x <= 231 - 1
         * 最优解
         * @param x
         * @return
         */
        public int reverse_2(int x) {
            int res = 0;
            while (x != 0) {
                //每次取末尾数字
                int tmp = x % 10;
                //判断是否 大于 最大32位整数  2147483647是完整的数字  小于214748364必可以 等于214748364时候就需要判断后续的值不能超过7 大于214748364必定溢出
                if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                    return 0;
                }
                //判断是否 小于 最小32位整数
                if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                    return 0;
                }
                res = res * 10 + tmp;
                x /= 10;
            }
            return res;
        }


        /**
         * 数字翻转 使用字符串拼接的方式
         *
         * @param x
         * @return
         */
        public int reverse_1(int x) {
            int result = 0;
            //判断数值正负数，如果为小于0，则记录一个标记，标识为负数
            boolean sign = true;
            if (x < 0) {
                sign = false;
                x = -x;
            }
            //如果为0直接返回0
            if (x == 0) {
                return 0;
            }
            //去除末尾的所有0
            while (x % 10 == 0) {
                x /= 10;
            }
            //使用stringBuilder完成字符串的翻转
            StringBuilder sb = new StringBuilder();
            //当x不为0时，持续切割数字拼接
            while (x > 0) {
                sb.append(x % 10);
                x /= 10;
            }
            try {
                result = Integer.parseInt(sb.toString());
            } catch (Exception e) {
                return result;
            }
            if (sign) {
                return result;
            } else {
                return -result;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
