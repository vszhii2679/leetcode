package com.cheese.leetcode.editor.cn;

/*
Java：对称二叉树
------------------------
//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// 👍 2238 👎 0

 */
public class P101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric_(root);
        }

        /**
         * 解题思路：深度优先搜索
         * 问题简化：判断两个节点 左侧和右侧值是否相等(递归简化) left == right && left.left == right.right && left.right == right.left
         *
         * 参考p100相同的树，这次相同只要是对称的位置即可
         * 依次比较
         * root.left == root.right
         * root.left.left == root.right.right
         * root.left.right == root.right.left
         *
         * @param root
         * @return
         */
        public boolean isSymmetric_(TreeNode root) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            return isSymmetric_(left, right);
        }

        public boolean isSymmetric_(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left == null || right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            } else {
                return isSymmetric_(left.left, right.right) && isSymmetric_(left.right, right.left);
            }
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
