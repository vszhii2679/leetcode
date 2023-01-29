package com.cheese.leetcode.editor.cn;

/*
Java：只出现一次的数字
------------------------
//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 
//
// 
// 
// 
// 
// 
//
// 示例 1 ： 
//
// 
//输入：nums = [2,2,1]
//输出：1
// 
//
// 示例 2 ： 
//
// 
//输入：nums = [4,1,2,1,2]
//输出：4
// 
//
// 示例 3 ： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 除了某个元素只出现一次以外，其余每个元素均出现两次。 
// 
//
// 👍 2720 👎 0

 */
public class P136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        // TO TEST
        solution.singleNumber(new int[]{2, 2, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察 位运算 异或
        public int singleNumber(int[] nums) {
            return singleNumber_(nums);
        }


        /**
         * 异或：如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0
         * 基本等式：
         * a^b^b = a
         * a^a = 0
         * a^0 = a
         * <p>
         * 除了某个元素只出现一次以外，其余每个元素均出现两次 只能使用常量的额外空间
         * 既然除某个数出现一次外其余数都出现两次，将这些数连续异或 得出的最终结果就是那个只出现过一次的数
         *
         * @param nums
         * @return
         */
        public int singleNumber_(int[] nums) {
            if (null == nums) {
                return 0;
            }
            int singleNum = 0;
            for (int num : nums) {
                singleNum = singleNum ^ num;
            }
            return singleNum;
        }


        /**
         * 暴力循环
         *
         * @param nums
         * @return
         */
        public int singleNumber_loop(int[] nums) {
            pointLoop:
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == x && j != i) {
                        continue pointLoop;
                    }
                }
                return x;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
