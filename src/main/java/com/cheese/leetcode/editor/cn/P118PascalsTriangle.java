package com.cheese.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
Java：杨辉三角
------------------------
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// 👍 901 👎 0

 */
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            return generate_(numRows);
        }


        /**
         * 解题思路：递归处理
         * 问题简化：根据上一行的数列计算出当前行的数列(递归简化)
         *
         * 问题分解为：根据上一行的元素列表计算出下一行的列表
         *
         * @param numRows
         * @return
         */
        public List<List<Integer>> generate_(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();
            //启动行
            List<Integer> row = new ArrayList<>();
            row.add(1);
            triangle.add(row);
            generate_recursion(triangle, row, --numRows);
            return triangle;
        }

        /**
         * 需要处理的问题结果本身为参数时，递归函数返回void效率更高
         * 例如一些场景：构建树形结构(字典、组织部门等)
         *
         * @param triangle
         * @param lastRow
         * @param numRows
         */
        public void generate_recursion(List<List<Integer>> triangle, List<Integer> lastRow, int numRows) {
            //递归的出口
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


        /**
         * 解题思路：杨辉三角的定义
         * 每行首个元素是1，行末也是1
         * 每个数是它左上方和右上方的数的和
         *
         * @param numRows
         * @return
         */
        public List<List<Integer>> generate_math(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();
            //外循环 循环每一行
            for (int i = 0; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                //内循环循环一行内的每一个元素
                for (int j = 0; j <= i; j++) {
                    //首尾都是1
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        //中间的数为左上和右上的和 i - 1, j - 1 和 i - 1 ,j
                        row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                    }
                }
                triangle.add(row);
            }
            return triangle;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
