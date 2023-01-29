package com.cheese.leetcode.editor.cn;

/*
Java：将有序数组转换为二叉搜索树
------------------------
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// 👍 1217 👎 0

 */
public class P108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        //考察：二叉查找树的中序遍历是一个升序数组
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST_(nums);
        }


        /**
         * 解题思路：二叉搜索树的中序遍历是一个升序数组
         * 问题简化：取数组的中间点的值创建根节点，左右侧节点通过中间节点拆分的两个新数组进行创建(递归简化) -> 二分法递归
         *
         *
         * 创建一颗平衡的二叉搜索树
         * 1.找到根节点：二分找到中间点作为根节点s
         * 2.创建左子树：递归子数组(数组范围为根据中间点为右边界进行向下不断拆分，直到不可拆分为止)
         * 3.创建右子树：递归子数组(数组范围为根据中间点为左边界进行向下不断拆分，直到不可拆分为止)
         *
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST_(int[] nums) {
            return sortedArrayToBST_(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayToBST_(int[] nums, int left, int right) {
            //递归的终点
            if (left > right) {
                return null;
            }
            //计算出二分点
            int mid = ((right - left) >> 1) + left;
            //创建根节点
            TreeNode root = new TreeNode(nums[mid]);
            //递归左子树
            root.left = sortedArrayToBST_(nums, left, mid - 1);
            //递归右子树
            root.right = sortedArrayToBST_(nums, mid + 1, right);
            return root;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
