package com.cheese.leetcode.editor.cn;

/*
Java：验证回文串
------------------------
//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// 👍 605 👎 0

 */
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            return isPalindrome_(s);
        }

        /**
         * 字符串操作相关api
         * Character包装类的静态方法
         * isLetter：是否是字母
         * isDigit：是否是数字
         * isLowerCase：是否是小写字符
         * isUpperCase：是否是大写字符
         * isWhitespace：是否是空格
         * isLetterOrDigit：是否是字母或数字
         * <p>
         * <p>
         * 参考：https://www.runoob.com/manual/jdk11api/java.base/java/lang/Character.html
         *
         * @param s
         * @return
         */
        public boolean isPalindrome_(String s) {
            StringBuilder sb = new StringBuilder();
            //筛选出符合条件的字符
            for (char c : s.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    sb.append(c);
                }
            }
            //判断是否是回文
            int left = 0;
            int right = sb.length() - 1;
            while (left < right) {
                // 回文是一个对称的数字 一旦不匹配就不是一个回文
                if (Character.toLowerCase(sb.charAt(left)) != Character.toLowerCase(sb.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
            //退出循环未返回代表是回文字符
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
