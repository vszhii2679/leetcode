package com.cheese.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/*
Java：二叉树的最小深度
------------------------
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// 👍 905 👎 0

 */
public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
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

        //考察：叶子节点 深度优先搜索 广度优先搜索
        public int minDepth(TreeNode root) {
            return minDepth_BFS(root);
        }

        class QueueNode {
            int depth;
            TreeNode node;

            public QueueNode(TreeNode node, int depth) {
                this.depth = depth;
                this.node = node;
            }
        }


        /**
         * 解题思路：通过广度优先搜索的方式遍历二叉树 通过首个访问到的叶子节点 来计算最小深度
         *
         * 广度优先搜索：层序遍历，需要借助队列来实现
         * 最优解
         * 参考：https://blog.csdn.net/qq_39825705/article/details/124953376
         *
         * @param root
         * @return
         */
        public int minDepth_BFS(TreeNode root) {
            //当前节点为num时返回0
            if (null == root) {
                return 0;
            }
            //创建队列来实现广度优先搜索
            Queue<QueueNode> queue = new LinkedList<>();
            queue.add(new QueueNode(root, 1));
            //队列循环
            while (!queue.isEmpty()) {
                //队列中删除一个元素
                QueueNode queueNode = queue.poll();
                //获取到这个节点
                TreeNode node = queueNode.node;
                int depth = queueNode.depth;
                //若当前节点为叶子节点，直接返回
                if (null == node.left && null == node.right) {
                    return depth;
                }
                //经过叶子节点的判断后，若右子树为空 则将左子树添加到队列中
                if (null != node.left) {
                    queue.add(new QueueNode(node.left, depth + 1));
                }
                if (null != node.right) {
                    queue.add(new QueueNode(node.right, depth + 1));
                }

            }
            return 0;
        }


        /**
         * 解题思路: 将二叉树的最小深度问题分解为求每一个非叶子节点的最小深度 (递归的终点：叶子节点的深度为1)
         * 深度优先搜索
         *
         * @param root
         * @return
         */
        public int minDepth_DBS(TreeNode root) {
            //当前节点为num时返回0
            if (null == root) {
                return 0;
            }
            //左节点深度
            int left = minDepth_DBS(root.left);
            //右节点深度
            int right = minDepth_DBS(root.right);
            if (null == root.left || null == root.right) {
                //左右侧节点有一个为null，left 和 right 有一个为 0  当前节点为非叶子节点
                return left + right + 1;
            }
            //余下的为两侧节点都不为null的情况，取最小值 当前节点为非叶子节点
            return Math.min(left, right) + 1;
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
