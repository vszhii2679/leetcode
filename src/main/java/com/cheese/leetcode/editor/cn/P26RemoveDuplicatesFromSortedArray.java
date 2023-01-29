package com.cheese.leetcode.editor.cn;

/*
Java：删除有序数组中的重复项
------------------------
//给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 
//。 
//
// 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个
//元素应该保存最终结果。 
//
// 将最终结果插入 nums 的前 k 个位置后返回 k 。 
//
// 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 判题标准: 
//
// 系统会用下面的代码来测试你的题解: 
//
// 
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//
//int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//} 
//
// 如果所有断言都通过，那么您的题解将被 通过。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2,_]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 升序 排列 
// 
//
// 👍 2988 👎 0

 */
public class P26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();
        // TO TEST
        int count = solution.removeDuplicates(new int[]{1, 1, 2, 3, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：指针
        public int removeDuplicates(int[] nums) {
            return removeDuplicates_(nums);
        }

        /**
         * 偏移量！
         * 指针1用来定位被比较元素，提供两个功能：1.被比较元素的值；2.被比较元素的下一个元素的角标
         * 指针2用来进行遍历及判断
         *
         * @param nums
         * @return
         */
        public int removeDuplicates_(int[] nums) {
            if (nums.length == 0) return 0;
            int x = 0;
            int y = 1;
            while (y < nums.length) {
                //如果两个指针上的值不相等 则-左侧指针下一位赋值为右侧指针上的值，左右侧指针均向右偏移一位，否则右指针向右偏移一位
                if (nums[x] != nums[y]) {
                    //优化 相邻位置不进行交换  y != x + 1
                    if (y > x + 1) {
                        nums[x + 1] = nums[y];
                    }
                    //最终x + 1就是排序后不相同元素的个数
                    x++;
                }
                y++;
            }
            return x + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
