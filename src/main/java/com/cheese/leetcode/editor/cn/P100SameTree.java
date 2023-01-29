package com.cheese.leetcode.editor.cn;

/*
Java：相同的树
------------------------
//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
// 
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// 👍 951 👎 0

 */
public class P100SameTree {
    public static void main(String[] args) {
        Solution solution = new P100SameTree().new Solution();
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return isSameTree_(p, q);
        }

        /**
         * 解题思路：树的遍历 深度优先搜索
         * 问题简化：判断两个节点当前值、左侧节点、右侧节点是否同时相同 (递归简化)
         *
         * @param p
         * @param q
         * @return
         */
        public boolean isSameTree_(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                //当前两个节点都为空时认为是空的
                return true;
            } else if (p == null || q == null) {
                //在经过第一层判断后，只要有一个节点为空则认为两个树不等
                return false;
            } else if (p.val != q.val) {
                //当前节点上的值不等的时候，认为两个树不等
                return false;
            } else {
                //当前两个节点的值也相等，则递归向同侧进行判断
                return isSameTree_(p.left, q.left) && isSameTree(p.right, q.right);
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
