package com.cheese.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Java：多数元素
------------------------
//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// 👍 1675 👎 0

 */
public class P169MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
        // TO TEST
        int i = solution.majorityElement(new int[]{1, 2, 3});
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            return majorityElement_(nums);
        }

        /**
         * 解题思路：摩尔投票算法/多数投票算法
         * 用于解决一组元素中占多数元素的常数空间级时间复杂度的算法
         * 分为两个阶段：
         * 1.投票阶段：投票人之间票数进行抵消
         * 2.计数阶段：计算对抗结果产生的候选人票数是否有效
         * <p>
         * 当前题目中已经确认给定的数组总是存在多数元素，所以解答中省略了判断投票阶段产生结果是否是众数的判断
         *
         * @param nums
         * @return
         */
        public int majorityElement_(int[] nums) {
            //1.投票阶段
            int major = 0;
            int count = 0;
            for (int num : nums) {
                if (count == 0) {
                    major = num;
                }
                count += major == num ? 1 : -1;
            }
            //2.计数阶段，判断当前major是否是众数 当前题目中可省略
            count = 0;
            for (int num : nums) {
                count += num == major ? 1 : 0;
            }
            return count > nums.length >>> 1 ? major : -1;
        }

        /**
         * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
         * 排序之后取 角标为 n/2 的元素
         *
         * @param nums
         * @return
         */
        public int majorityElement_sort(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length >>> 1];
        }

        /**
         * 使用map进行统计
         *
         * @param nums
         * @return
         */
        public int majorityElement_map(int[] nums) {
            Map<Integer, Integer> eleMap = new HashMap<>();
            for (int num : nums) {
                eleMap.put(num, eleMap.getOrDefault(num, 0) + 1);
                if (eleMap.get(num) > nums.length >>> 1) {
                    return num;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
