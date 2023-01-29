package com.cheese.leetcode.editor.cn;

/*
Java：加一
------------------------
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
//
// 👍 1154 👎 0

 */
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        // TO TEST
        int[] ints = solution.plusOne(new int[]{9, 9, 9, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：数组 指针
        public int[] plusOne(int[] digits) {
            return plusOne_(digits);
        }

        /**
         * 指针
         * 解题思路:找到所有连续的为9的位置
         *
         * @param digits
         * @return
         */
        public int[] plusOne_(int[] digits) {
            int n = digits.length;
            //从右往左 找出数据中不为9的元素 + 1 且将当前索引右侧的数据全部赋为0
            for (int i = n - 1; i >= 0; i--) {
                //当元素位不为9时 +1并返回数组
                if (digits[i] != 9) {
                    //自增并返回
                    digits[i] = digits[i] + 1;
                    //返回前需要将数组中当前i - n 位置的元素置为0(不包括i)
                    for (int j = i + 1; j < n; j++) {
                        digits[j] = 0;
                    }
                    //经历过一次外循环return
                    return digits;
                }
            }
            //如果在循环内未返回 则说明数组中的数值全是9，则构建一个长度为当前数组 + 1长度的新数组 将首位设为1 其余设置为0
            int[] newDigits = new int[n + 1];
            //基本类型int默认值为0 不用循环设置0 只设置首位即可
            newDigits[0] = 1;
            return newDigits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
