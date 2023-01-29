package com.cheese.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/*
Java：两数之和
------------------------
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 16091 👎 0

 */
public class P1TwoSum {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST
        int[] nums = {3, 2, 4};
        int[] ints = solution.twoSum(nums, 6);
//        System.out.println("ints = " + ints[0] + "," + ints[1]);
//        long end = System.currentTimeMillis();
//        System.out.println("程序耗时 = " + (end - start) + "ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：HashMap的使用
        public int[] twoSum(int[] nums, int target) {
            return twoSum_hashMap2(nums, target);
        }

        /**
         * 一次循环，使用map存储符合条件的值，空间换时间
         * 最优解
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum_hashMap2(int[] nums, int target) {
            // map中建立 target - nums[i] 与 i 的关系 因为循环处理顺序从小到大 故返回数组时需要将 map中获取的index在0 符合条件的index在1
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            //map中存储：key->当前角标值满足条件的值，value->当前角标值
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    //当map中满足条件的值为当前元素时，返回当前元素角标以及原条件角标的数组
                    return new int[]{map.get(nums[i]), i};
                }
                //当map中不包含满足条件的值的时候，将此值与条件存入
                map.put(target - nums[i], i);
            }
            return null;
        }

        /**
         * 暴力遍历：2次循环
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum2(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (target == nums[i] + nums[j]) {
//                        System.out.println("i = " + i + "j = " + j);
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }

        /**
         * 两次循环，使用map的key唯一
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum_hashMap(int[] nums, int target) {
            //返回值
            int[] result = new int[2];
            //因为同一个元素不能重复出现，将所有数据存放到map中,并将值作为key
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            //遍历数组，通过key索引获取结果
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                    Integer j = map.get(target - nums[i]);
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
