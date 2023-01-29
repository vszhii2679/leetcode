package com.cheese.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
Java：有效的括号
------------------------
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// 👍 3672 👎 0

 */
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        solution.isValid("()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：先进先出-栈
        public boolean isValid(String s) {
            return isValid_(s);
        }


        /**
         * 栈
         *
         * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
         * <p>
         * 有效字符串需满足：
         * <p>
         * 左括号必须用相同类型的右括号闭合。
         * 左括号必须以正确的顺序闭合。
         * 每个右括号都有一个对应的相同类型的左括号。
         */
        public boolean isValid_(String s) {
            //字典
            Map<Character, Character> dic = new HashMap<Character, Character>() {{
                put('{', '}');
                put('(', ')');
                put('[', ']');
            }};
            //一道先进后出的题目 可以用栈的数据结构来处理，如果元素是 {([ 则进行入栈操作， 如过元素是 })] 则进行出栈操作
            //使用LinkedList 或者 stack
            LinkedList<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (dic.containsKey(c)) {
                    stack.push(c);
                } else {
                    //如果栈中为空或者 弹出的这个元素如果与当前元素不是一对 则返回false
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (dic.get(pop) != c) {
                        return false;
                    }
                }
            }
            //判断当前栈中是否有剩余元素，如果有返回false
            if (stack.isEmpty()) {
                return true;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
