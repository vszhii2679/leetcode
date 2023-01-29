package com.cheese.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
Java：二叉树的中序遍历
------------------------
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// 👍 1658 👎 0

 */
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
        // 考察：栈 二叉树 遍历 递归
        public List<Integer> inorderTraversal(TreeNode root) {
            return inorderTraversal_(root);
        }

        /**
         * 解题思路：中序遍历
         * 中序遍历：先遍历根节点下的左子树，然后访问根节点，最后访问根节点下的右子树，根据深度优先搜索(DBS)实现
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal_(TreeNode root) {
            List<Integer> answer = new ArrayList<>();
            recursion(answer, root);
            return answer;
        }

        /**
         * 递归:参考二叉树中序遍历通用方法 进行改造
         * <p>
         * <p>
         * 先序遍历、中序遍历、后续遍历 仅需要调整else中递归执行顺序
         * 先序遍历：
         * 1.先访问根节点: System.out.println(node.val)
         * 2.再访问左子树: recursion(node.left)
         * 3.最后访问右子树: recursion(node.right)
         * 中序遍历：
         * 1.先访问左子树: recursion(node.left)
         * 2.再访问根节点: System.out.println(node.val)
         * 3.最后访问右子树：recursion(node.right)
         * 后序遍历：
         * 1.先访问左子树: recursion(node.left)
         * 2.再访问右子树：recursion(node.right)
         * 3.最后访问根节点: System.out.println(node.val)
         *
         * @param answer
         * @param node
         */
        public void recursion(List<Integer> answer, TreeNode node) {
            //深度优先搜索
            if (node == null) {
                //遍历到空节点时返回
                return;
            } else {
                //根节点
                //System.out.println(node.val);
                //找到最左节点
                recursion(answer, node.left);
                //递归的出口是node == null 第一次递归向下执行时候是最左节点,第二次递归向下执行的是最左节点的第一级父节点...第n次递归向下执行的是最左节点的(n-1)级父节点，顺序添加
                answer.add(node.val);
                //左侧递归完成之后递归当前节点的右侧节点
                //继续向下执行时 第一次是最左节点，node.right == null
                recursion(answer, node.right);
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
