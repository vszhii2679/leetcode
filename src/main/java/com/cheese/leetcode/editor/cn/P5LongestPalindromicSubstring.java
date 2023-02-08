package com.cheese.leetcode.editor.cn;

/*
Java：最长回文子串
------------------------
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// 👍 6116 👎 0

 */
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return longestPalindrome_(s);
        }

        /**
         * 中心扩散
         *
         * @param s
         * @return
         */
        public String longestPalindrome_(String s) {
            //特殊情况，若长度为1 即是最长回文字串
            if (s.length() == 1) {
                return s;
            }
            int left = 0;
            int right = 0;
            int len = 1;
            int minStart = 0;
            int maxLen = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                left = i - 1;
                right = i + 1;
                //向左侧扩散，先判断是否左扩散相等,直到找到不相等的数据为止
                while (left >= 0 && chars[left] == chars[i]) {
                    len++;
                    left--;
                }
                //向右侧扩散，先判断是否右扩散相等，直到找到不相等的数据为止
                while (right < chars.length && chars[right] == chars[i]) {
                    len++;
                    right++;
                }
                //以上两次循环完成时候，后续处理，左和右侧扩散是否相等
                while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                    len = len + 2;
                    left--;
                    right++;
                }
                //最后判断当前的长度与最大长度的关系
                if (len > maxLen) {
                    maxLen = len;
                    minStart = left;
                }
                //每次循环结束时，重置下次循环中的长度
                len = 1;
            }
            //退出循环时，最终通过minStart和maxEnd来确定最大字串, 注意subString左闭右开
            return s.substring(minStart + 1, minStart + maxLen + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
