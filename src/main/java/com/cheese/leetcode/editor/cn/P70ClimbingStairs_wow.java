package com.cheese.leetcode.editor.cn;

/*
Java：爬楼梯
------------------------
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// 👍 2811 👎 0

 */
public class P70ClimbingStairs_wow {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs_wow().new Solution();
        // TO TEST
        solution.climbStairs(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //考察：数学计算 斐波拉切数列
        public int climbStairs(int n) {
            return climbStairs_2(n);
        }


        /**
         * 解题思路：斐波拉切数列
         * 1、1、2、3、5、8、13、21、34、...
         * <p>
         * 爬楼梯问题就是一个典型的斐波拉切数列实现，楼梯阶数就是第n项 需要获取第n项上的数
         * 当前项 = 前两项之和
         * 将应用问题转化为数学问题，获取斐波拉切数列第n项上的数
         *
         * @param n
         * @return
         */
        public int climbStairs_2(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int fxn_1 = 1;
            int fxn_2 = 2;
            int fx = 3;
            for (int i = 3; i <= n; i++) {
                //当前项数 = 前两项之和 f(Xn) = f(Xn-1) + f(Xn-2)
                fx = fxn_1 + fxn_2;
                //将数值向前轮转
                fxn_1 = fxn_2;
                fxn_2 = fx;
            }
            return fx;
        }

        /**
         * 斐波拉切数列
         * f(X) = f(Xn-1) + f(Xn-2)
         * 递归超时了...
         *
         * @param n
         * @return
         */
        public int climbStairs_1(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return climbStairs_1(n - 1) + climbStairs_1(n - 2);
        }


        /**
         * 求路径数目：矩阵 快速幂
         * todo 不太懂
         * <p>
         * https://zhuanlan.zhihu.com/p/42639682
         *
         * @param n
         * @return
         */
        public int climbStairs_0(int n) {
            int[][] q = {{1, 1}, {1, 0}};
            int[][] res = pow(q, n);
            return res[0][0];
        }

        public int[][] pow(int[][] a, int n) {
            int[][] ret = {{1, 0}, {0, 1}};
            while (n > 0) {
                //位与运算 n&1 == 1 判断n二进制最后一位是否为1
                if ((n & 1) == 1) {
                    ret = multiply(ret, a);
                }
                //n进行向右位运算并赋值n
                n >>= 1;
                a = multiply(a, a);
            }
            return ret;
        }

        public int[][] multiply(int[][] a, int[][] b) {
            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
                }
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}




