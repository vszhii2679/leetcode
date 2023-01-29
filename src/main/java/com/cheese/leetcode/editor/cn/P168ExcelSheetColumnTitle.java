package com.cheese.leetcode.editor.cn;

/*
Java：Excel表列名称
------------------------
//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
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
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// 👍 591 👎 0

 */
public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {


        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        // TO TEST
        String s = solution.convertToTitle(701);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            return convertToTitle_(columnNumber);
        }

        /**
         * 将十进制转换为26进制，需要作出以下映射 需要注意的是实际在26时并没有进位
         * 1 -> A
         * 2 -> B
         * ...
         * 26 -> Z
         * <p>
         * 取模运算时候结果为0，需要将数字减去1
         * 1: 1-1 = 0 --- 0 % 26 = 0 --- 0 = 'A' --- 0/26 = 0 --- title = A
         * 26: 26-1 = 25 --- 25 % 26 = 25 --- 25 = 'Z' --- 25/26 = 0 --- title = Z
         * 27: 27-1 = 26 --- 26 % 26 = 0 --- 0 = 'A' --- 26/26 = 1 --- 1 % 26 = 1 --- 0 = 'A' --- 1/26 = 0 --- title = AA
         * 28: 28-1 = 27 --- 27 % 26 = 1 --- 1 = 'B' --- 27/26 = 1 --- 1 % 26 = 1 --- 0 = 'A' --- 1/26 = 0 --- title = AB
         *
         * @param columnNumber
         * @return
         */
        public String convertToTitle_(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while (columnNumber != 0) {
                // excel表中 1 -> A 但取模时 0 -> A
                columnNumber--;
                // mod 26 = 0 时候为A
                char mod = (char) (columnNumber % 26 + 'A');
                sb.append(mod);
                // 下个循环数取除尽26的部分
                columnNumber /= 26;
            }
            return sb.reverse().toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
