package com.cheese.leetcode.editor.cn;

/*
Java：最后一个单词的长度
------------------------
//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为5。
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为4。
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为6的“joyboy”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
//
// 👍 534 👎 0

 */
public class P58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：指针 计数器
        public int lengthOfLastWord(String s) {
            return lengthOfLastWord_(s);
        }


        /**
         * 从右往左
         *
         * @param s
         * @return
         */
        public int lengthOfLastWord_(String s) {
            // 空字符串时
            if (s.equals(" ")) {
                return 0;
            }
            // 去掉首尾空格
            s = s.trim();
            // 只有一个字符时
            if (s.length() == 1) {
                return 1;
            }
            int count = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                // 从后往前找遇到第一个空格结束 或者只有一个单词时到i=0结束
                if (s.charAt(i) == ' ') break;
                else {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
