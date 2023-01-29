package com.cheese.leetcode.editor.cn;

/*
Java：平衡二叉树
------------------------
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// 👍 1225 👎 0

 */
public class P110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110BalancedBinaryTree().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return isBalanced_2(root);
        }

        /**
         * 解题思路：左右子树的高度差是否大于1，递归的出口需要设置一个特殊值进行判断
         * 问题简化：当前节点的左节点和右节点中是否有高度差大于1的情况，如果有则返回一个特殊值(递归简化)
         *
         * 关键点：一旦有左右子树的高度差大于1的情况，需要逐层向上传递，将结果返回
         * 最优解
         *
         * @param root
         * @return
         */
        public boolean isBalanced_2(TreeNode root) {
            return height(root) >= 0;
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //每一个节点都经过一次判断，过程中只要有一次满足不符合高度差的情况 整个函数返回 -1
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            //这个判断中Math.abs(leftHeight - rightHeight) > 1是单次判断的核心，leftHeight == -1 和 rightHeight == -1 是递归向上传递的核心
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }

        /**
         * 解题思路：从根节点向下 每个节点都要经过如下判断
         * 1.根节点左右两树，值判断当前节点的左子树和右子树的最大深度是否相同
         * 2.每一个节点左右两树是否相同 - 递归当前节点的左节点和右节点  递归的出口为null
         *
         * @param root
         * @return
         */
        public boolean isBalanced_1(TreeNode root) {
            if (root == null) {
                return true;
            }
            //左子树和右子树高必须不超过1，递归向下
            return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced_1(root.left) && isBalanced_1(root.right);
        }

        /**
         * 使用p104中二叉树最大深度的计算方法
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            //当前节点为num时返回0
            if (null == root) {
                return 0;
            }
            //找到最深的节点
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            //等差数列的前n项和，从栗子中的15下的null开始递归完成往上出栈，每次返回的值加1
            return Math.max(left, right) + 1;
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
