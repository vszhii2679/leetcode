package com.cheese.leetcode.editor.cn;

/*
Java：Excel 表列序号
------------------------
//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//... 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
//
// 👍 366 👎 0

 */
public class P171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new P171ExcelSheetColumnNumber().new Solution();
        // TO TEST
        int ab = solution.titleToNumber("AB");
        System.out.println("ab = " + ab);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            return titleToNumber_(columnTitle);
        }

        /**
         * 参考P168 Excel表列名称 反向求和
         * 假设columnTitle为n项
         * sum = X0 * 26 ^ 0 + X1 * 26 ^ 1 + ... + Xn * 26 ^ n
         * 求幂通过在循环步进区定义了rank 也可以使用了Math的pow函数
         *
         * @param columnTitle
         * @return
         */
        public int titleToNumber_(String columnTitle) {
            //获取字符数组
            int sum = 0;
            char[] chars = columnTitle.toCharArray();
            //扣一下细节 - 'A'
            for (int i = chars.length - 1, rank = 1; i >= 0; i--, rank*=26) {
                // 1 -> A  而不是 0 -> A，此处和应该加上1
                int value = chars[i] - 'A' + 1;
                sum += value * rank;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
