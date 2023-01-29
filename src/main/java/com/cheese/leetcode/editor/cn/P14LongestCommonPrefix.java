package com.cheese.leetcode.editor.cn;

/*
Java：最长公共前缀
------------------------
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// 👍 2596 👎 0

 */
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
        String[] strs = {"flower", "flow", "flight"};
        solution.longestCommonPrefix(strs);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：指针
        public String longestCommonPrefix(String[] strs) {
            return longestCommonPrefix_(strs);
        }


        /**
         * 从左至右 根据角标判断每一个字符串对应位置的字符是否相等
         *
         * @param strs
         * @return
         */
        public String longestCommonPrefix_(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            //假定首个字符串是完整前缀
            String ans = strs[0];
            //外循环将每次循环的结果与下一个字符串进一步取交集
            for (int i = 1; i < strs.length; i++) {
                //内循环循环字符串进行匹配
                int j = 0; //循环角标
                strLoop:
                for (; j < ans.length() && j < strs[i].length(); j++) {
                    if (ans.charAt(j) != strs[i].charAt(j)) {
                        //只要有一个字符串不匹配则退出循环 退出循环时候通过j就可以得到最长相同前缀的角标
                        break strLoop;
                    }
                }
                //单次循环获取的是当次循环中的最长相同的前缀字符串
                ans = ans.substring(0, j);
//                System.out.println("循环第" + i + "次，ans = " + ans);
                if ("".equals(ans)) return "";
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
