package com.cheese.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/*
Java：路径总和
------------------------
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 👍 1082 👎 0

 */
public class P112PathSum {
    public static void main(String[] args) {
        Solution solution = new P112PathSum().new Solution();
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return hasPathSum_2(root, targetSum);
        }

        /**
         * 解题思路：递归实现
         * 问题简化：当前节点的左右侧节点是否有一个满足目标值(递归简化)
         *
         * 问题分解为：当前节点到叶子节点路径的和是否满足给定值
         *
         * @param root
         * @param targetSum
         * @return
         */
        public boolean hasPathSum_2(TreeNode root, int targetSum) {
            if (null == root) {
                return false;
            }
            //若当前节点是叶子节点，判断是否满足浮标值
            if (root.left == null && root.right == null) {
                return root.val == targetSum;
            }
            //非叶子节点 向下递归，任意左节点或右节点满足均符合要求使用或判断
            return hasPathSum_2(root.left, targetSum - root.val) || hasPathSum_2(root.right, targetSum - root.val);
        }


        class QueueNode {
            int sum;
            private TreeNode node;

            public QueueNode(TreeNode node, int sum) {
                this.node = node;
                this.sum = sum;
            }

        }

        /**
         * 解题思路：广度优先搜索
         * 找到叶子节点，并对路径上的结果求和
         *
         * @param root
         * @param targetSum
         * @return
         */
        public boolean hasPathSum_1(TreeNode root, int targetSum) {
            //根节点不存在
            if (root == null) {
                return false;
            }
            //创建节点 每个层级保存自己与上一级的sum
            Queue<QueueNode> queue = new LinkedList<>();
            queue.offer(new QueueNode(root, root.val));
            TreeNode left;
            TreeNode right;
            while (!queue.isEmpty()) {
                QueueNode queueNode = queue.poll();
                TreeNode node = queueNode.node;
                left = node.left;
                right = node.right;
                // 如果是叶子节点，当前队列节点保存的sum是否等于目标值
                if (left == null && right == null && queueNode.sum == targetSum) {
                    return true;
                }
                if (null != left) {
                    queue.offer(new QueueNode(left, left.val + queueNode.sum));
                }
                if (null != right) {
                    queue.offer(new QueueNode(right, right.val + queueNode.sum));
                }
            }
            return false;
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
