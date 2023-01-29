package com.cheese.leetcode.editor.cn;

/*
Java：二叉树的最大深度
------------------------
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]，
// 15 = 1; 7 =1  => 15 == 7
// 20 = 1 + 1; 9 = 1 ==> 20 > 9
// 3 = 1 + 1 + 1  = 3



//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 👍 1467 👎 0

 */
public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
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
        public int maxDepth(TreeNode root) {
            return maxDepth_(root);
        }

        /**
         * 解题思路：深度优先搜索
         * 问题简化：找出一个节点的最大深度(递归简化)
         *
         * 获取两个'叉'中较大的深度，通过等差数列的前n项和公式计算出树深
         *
         * @param root
         * @return
         */
        public int maxDepth_(TreeNode root) {
            //当前节点为num时返回0
            if (null == root) {
                return 0;
            }
            //找到最深的节点
            int left = maxDepth_(root.left);
            int right = maxDepth_(root.right);
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
