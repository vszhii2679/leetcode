package com.cheese.leetcode.editor.cn;

/*
Java：反转字符串中的单词 III
------------------------
//给定一个字符串
// s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "God Ding"
//输出："doG gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 
// s 包含可打印的 ASCII 字符。 
// 
// s 不包含任何开头或结尾空格。 
// 
// s 里 至少 有一个词。 
// 
// s 中的所有单词都用一个空格隔开。 
// 
//
// 👍 522 👎 0

 */
public class P557ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
        // TO TEST
        String s = solution.reverseWords("Let's take LeetCode contest" );
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 双指针
         *
         * @param s
         * @return
         */
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            int pa = 0, pb = 0;
            while (pb < chars.length) {
                if (chars[pb] == ' ') {
                    for (int i = pb; i >= pa; i--) {
                        sb.append(chars[i]);
                    }
                    pb++;
                    pa = pb;
                } else if (pb == chars.length - 1) {
                    sb.append(' ');
                    for (int i = pb; i >= pa; i--) {
                        sb.append(chars[i]);
                    }
                    pb++;
                    pa = pb;
                } else {
                    pb++;
                }
            }
            return sb.toString().trim();
        }


        /**
         * split
         *
         * @param s
         * @return
         */
        public String reverseWords2(String s) {
            StringBuilder sb = new StringBuilder();
            String[] wordArr = s.split(" ");
            for (String word : wordArr) {
                char[] chars = word.toCharArray();
                int start = 0, end = chars.length - 1;
                while (start < end) {
                    chars[start] = (char) (chars[start] ^ chars[end]);
                    chars[end] = (char) (chars[start] ^ chars[end]);
                    chars[start] = (char) (chars[start] ^ chars[end]);
                    start++;
                    end--;
                }
                sb.append(chars).append(" ");
            }
            return sb.toString().trim();
        }


        /**
         * 问题简化：
         * 对一个字符串进行翻转
         *
         * @return
         */
        public String reverseWords_recursion(String s) {
            //读到空格的位置
            StringBuilder sb = new StringBuilder();
            int index = s.indexOf(' ');
            reverseWords_(index, s, sb);
            return sb.toString();
        }


        public void reverseWords_(int index, String word, StringBuilder sb) {
            if (word.length() == 0) {
                return;
            }
            //每次遍历子字符串
            char[] chars = index == -1 ? word.toCharArray() : word.substring(0, index).toCharArray();
            int start = 0, end = chars.length - 1;
            while (start < end) {
                chars[start] = (char) (chars[start] ^ chars[end]);
                chars[end] = (char) (chars[start] ^ chars[end]);
                chars[start] = (char) (chars[start] ^ chars[end]);
                start++;
                end--;
            }
            sb.append(chars);
            if (index == -1) {
                return;
            }
            sb.append(' ');
            String subString = word.substring(index + 1);
            reverseWords_(subString.indexOf(' '), subString, sb);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
