package com.cheese.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
Java：杨辉三角 II
------------------------
//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// 👍 450 👎 0

 */
public class P119PascalsTriangleIi_wow {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi_wow().new Solution();
        // TO TEST
        solution.getRow(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
//            return getRow_recursion(rowIndex);
//            return getRow_math(rowIndex + 1);
//            return getRow_math2(rowIndex + 1);
            return getRow_(rowIndex + 1);
        }

        /**
         * 解题思路：线性递推公式 : f(m + 1) = f(m) * ( n - m) / m
         * 其中n为第n行，m是第m个数
         * 杨辉三角线性递推公式：计算第n项中1-m的值
         * 最优解
         *
         * 栗子：
         *  已知第六行第一个元素为1，
         *  第二个元素 = 1 * (6 - 1) / 1 = 5
         *  第三个元素 = 5 * (6 - 2) / 2 = 10
         *  第四个元素 = 10 * (6 -3) / 3 = 10
         *
         *
         *  已知第十行第一个元素为1，
         *  第二个元素 = 1 * (10 - 1) / 1 = 9
         *  第二个元素 = 9 * (10 - 2) / 2 = 36
         *  第三个元素 = 36 * (10 - 3) / 3 = 84
         *  ...
         *
         * @param n
         * @return
         */
        public List<Integer> getRow_(int n) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            //第n项有n个元素，首位为1，从第二位开始循环
            for (int m = 1; m <= n - 1; ++m) {
                //第n项上第m + 1个元素的值 f(m + 1) = f(m) * ( n - m) / m
                row.add((int) ((long) row.get(m - 1) * (n - m) / m));
            }
            return row;
        }

        /**
         * 解题思路：
         * 1.外循环循环行树，对行内元素进行推衍
         * 2.外循环中先于行末添加0用于内循环首轮计算行尾值
         * 3.内循环从行最右往左依次赋值(首位除外)，内循环每一次循环其实就进行了杨辉三角累加的计算过程(仅首位为1不进行变动)
         *
         * @param rowIndex
         * @return
         */
        public List<Integer> getRow_math2(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            //外循环循环行树，对行内元素进行推衍
            for (int i = 1; i < rowIndex; i++) {
                //行数++ 时，行末填充一个0用于计算
                row.add(0);
//                System.out.println(row);
                //内循环从最右向左依次赋值(首位除外)
                for (int j = i; j > 0; j--) {
                    //首轮 row.get(j) 获得的是占位的0
                    row.set(j, row.get(j) + row.get(j - 1));
//                    System.out.println(row);
                }
            }
            return row;
        }

        /**
         * 解题思路：根据p118双循环创建杨辉三角进行优化，通过两个列表的滚动迭代优化空间复杂度
         *
         * @param rowIndex
         * @return
         */
        public List<Integer> getRow_math(int rowIndex) {
            //past用于保存上一轮的current产生的数据
            List<Integer> past = new ArrayList<>();
            //外循环 循环每一行
            for (int i = 0; i < rowIndex; i++) {
                List<Integer> current = new ArrayList<>();
                //内循环循环一行内的每一个元素
                for (int j = 0; j <= i; j++) {
                    //首尾都是1
                    if (j == 0 || j == i) {
                        current.add(1);
                    } else {
                        current.add(past.get(j - 1) + past.get(j));
                    }
                }
                past = current;
            }
            return past;
        }


        /**
         * 解题思路
         * 1.先创建杨辉三角 p118 递归
         * 2.再获取对应索引的行
         *
         * @param rowIndex
         * @return
         */
        public List<Integer> getRow_recursion(int rowIndex) {
            List<List<Integer>> lists = generate_(rowIndex + 1);
            return lists.get(rowIndex);
        }

        //创建杨辉三角
        public List<List<Integer>> generate_(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();
            //启动行
            List<Integer> row = new ArrayList<>();
            row.add(1);
            triangle.add(row);
            generate_recursion(triangle, row, --numRows);
            return triangle;
        }

        //递归处理非首行的每一行的逻辑
        public void generate_recursion(List<List<Integer>> triangle, List<Integer> lastRow, int numRows) {
            if (numRows == 0) {
                return;
            }
            List<Integer> row = new ArrayList<>(lastRow.size() + 1);
            //每行首个元素
            row.add(1);
            for (int i = 0; i < lastRow.size() - 1; i++) {
                //中间元素是左上方和右上方的数的和
                row.add(lastRow.get(i) + lastRow.get(i + 1));
            }
            //每行末尾元素
            row.add(1);
            //处理完的每一行添加至三角中
            triangle.add(row);
            generate_recursion(triangle, row, --numRows);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
