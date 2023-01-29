package com.cheese.leetcode.editor.cn;

/*
Java：x 的平方根 
------------------------
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// 👍 1240 👎 0

 */
public class P69Sqrtx_wow {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx_wow().new Solution();
        // TO TEST
        //数学的魅力！ 牛顿迭代公式：Xn+1 = Xn - f(Xn)/f'(Xn) 通过递归取得 Xn+1 = Xn时的数据
        int i = solution.mySqrt_(8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int mySqrt(int x) {
            return mySqrt_(x);
        }

        //考察：数学计算 平方根 牛顿迭代公式
        private int a;
        private int round;

        /**
         * 解题思路：算数平方根 牛顿迭代公式：Xn+1 = Xn - f(Xn)/f'(Xn) 经过对n轮的计算获取的方程的根的近似值
         * 数学中就是通过不断对f(x)做切线，取切线方程 y0= 0时 x0的值 代入到f(x0)中 微积分的过程就是一个取可以接受近似值的过程
         * <p>
         * 当前问题中 方程: f(x) = x2 - a，代入公式
         * Xn+1 = X - (X2 - a)/2X = X - X/2 + a/2X =  X/2 + a/2x = (X + a/X)/2
         * <p>
         * 任意取一个值x0 => 通过递归计算方程的根，迭代过程会产生迭代次数的近似值序列
         *
         * @param x
         * @return
         */
        public int mySqrt_(int x) {
            //a初始化
            a = x;
            if (x == 0) {
                return 0;
            }
            //将a作为X0传入,X0的值无所谓
            return (int) recursion(x);
        }

        //递归获取结果
        public double recursion(double x) {
            //通过round统计牛顿迭代轮次
            round++;
            //计算当前轮次的迭代近似值
            double r = (x + a / x) / 2;
            //此处的判断 使用可接受的误差范围更符合数学逻辑 例如 | r - x | <= q 其中 q为可接受的误差范围
            if (r - x <= 0.001f || x - r <= 0.001f) {
                //如果当前传入的r与x相等 则理解为 Xn+1 = Xn 已经通过递归找到方程的根
//            if (r == x) {
                return r;
            } else {
                //不相等时，需要继续进行牛顿迭代
                return recursion(r);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
