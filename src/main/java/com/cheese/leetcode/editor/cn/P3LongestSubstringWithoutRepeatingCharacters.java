package com.cheese.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/*
Java：无重复字符的最长子串
------------------------
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// 👍 8682 👎 0

 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            return lengthOfLongestSubstring_(s);
        }

        /**
         * 滑动窗口：
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring_(String s) {
            Map<Character, Integer> window = new HashMap<>();
            char[] chars = s.toCharArray();
            //长度
            int ans = 0;
            for (int start = 0, end = 0; end < chars.length; end++) {
                //判断当前字符是否存在
                if (window.containsKey(chars[end])) {
                    //若存在，重置起始点
                    start = Math.max(window.get(chars[end]), start);
                }
                //字符串的最大长度通过上一轮循环确认的长度 与 当前终止指针 - 起始指针 + 1 进行判断 所以始终是最大的长度
                ans = Math.max(end - start + 1, ans);
                //将当前窗格的角标存入map中，为后续起始指针赋值
                window.put(chars[end], end + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
