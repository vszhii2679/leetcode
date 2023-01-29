package com.cheese.leetcode.editor.cn;

/*
Java：二进制求和
------------------------
//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// 👍 941 👎 0

 */
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
        String binaryStr = solution.addBinary("10010", "111");
        // "10010", "111" 期望值 11001
//        System.out.println("binaryStr = " + binaryStr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：循环 数学计算
        public String addBinary(String a, String b) {
            return addBinary_(a, b);
        }

        /**
         * 思路：
         * 1.以末尾相同索引遍历二进制串a和b
         * 2.如果在a中索引不存在，则读0，若存在则读取读取字符与'0'的差值(通过asciii码来计算实际的值，减少判断)；b同理
         * 3.对a和b中读取的位置数据求和，判断数据是否大于1，若大于1则代表需要进位，进位值 = 1，当前和 = 求和 % 2 (或-2，因为是2进制)，新字符串中添加当前和
         *
         * @param a
         * @param b
         * @return
         */
        public String addBinary_(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int raise = 0;
            //当i j 大于等于0 代表循环未完成；进制位不为0代表需要提阶
            while (i >= 0 || j >= 0 || raise != 0) {
                //获取元素数值 通过asciii求差的方式巧妙获取当前位的数值
                int va = i >= 0 ? a.charAt(i) - '0' : 0;
                int vb = j >= 0 ? b.charAt(j) - '0' : 0;
                //求和，若和大于1则需要进位 注意求和时候需要计算上一循环中获取的raise!
                int sum = va + vb + raise; //进位核心
                //当前循环重新设置进制数，待下个循环使用!!
                raise = sum > 1 ? 1 : 0; //进位核心
                sum = sum > 1 ? sum % 2 : sum;
                //顺序拼接
                sb.append(sum);
                i--;
                j--;
            }
            //因为遍历时是从右往左遍历，拼接字符串时是顺序拼接，所以最终的字符串需要翻转
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
