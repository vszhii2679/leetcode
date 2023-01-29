package com.cheese.leetcode.editor.cn;

/*
Java：搜索插入位置
------------------------
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// 👍 1846 👎 0

 */
public class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        // TO TEST
        int index = solution.searchInsert(new int[]{1, 2, 3, 5, 6}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：指针 二分查找
        public int searchInsert(int[] nums, int target) {
            return searchInsert_(nums, target);
        }

        /**
         * 二分查找
         *
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert_(int[] nums, int target) {
            int x = 0;
            int y = nums.length - 1;
            int index = nums.length;
            //二分查找获取target在nums中的位置
            while (x <= y) {
                //防止 x + y 越界
                int mid = ((y - x) >> 1) + x;
                //当且仅当target <= mid索引所在的元素时，将index归于此处，最后退出循环时的index就是target可以插入数据的位置
                if (target <= nums[mid]) {
                    y = mid - 1;
                    index = mid;
                } else {
                    x = mid + 1;
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
