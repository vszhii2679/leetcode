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
        // TO TEST arr[0][2] arr[1][3]
        solution.longestPalindrome("aacabdkacaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return longestPalindrome_2(s);
        }

        /**
         * 动态规划
         * 重点： indexSegment[l + 1][r - 1]
         * 过程中将符合条件回文角标一步步向上叠起
         *
         * @param s
         * @return
         */
        public String longestPalindrome_2(String s) {
            if (s.length() == 1) {
                return s;
            }
            //定义一个二维数组，两个角标位置确定从角标i到角标j的数据是否为符合要求
            char[] chars = s.toCharArray();
            boolean[][] indexSegment = new boolean[chars.length][chars.length];
            int start = 0;
            int end = 0;
            int maxLen = 0;
            for (int r = 0; r < chars.length; r++) {
                for (int l = 0; l < r; l++) {
                    //两个角标指向的值相等 + 比较回文 当角标之间只有一个数据或者两个数据一定为回文；角标大于2时，向内判断是否有回文 判断 chars[l + 1] == chars[r - 1]
                    if (chars[l] == chars[r] && (r - l <= 2 || indexSegment[l + 1][r - 1])) {
                        //将符合回文的标记存入空间中，可用于下一次外围数据向内的判断
                        indexSegment[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            //记录最大长度
                            maxLen = r - l + 1;
                            //记录最大长度时开始和结束角标的位置
                            start = l;
                            end = r;
                        }
                    }
                }
            }
            //循环结束时，使用起点和终点截取的字符串就是符合条件的回文串
            return s.substring(start, end + 1);
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
