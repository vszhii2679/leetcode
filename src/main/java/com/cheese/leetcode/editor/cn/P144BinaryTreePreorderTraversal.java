package com.cheese.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
Java：二叉树的前序遍历
------------------------
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
// 示例 4： 
// 
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
// 
// 
//输入：root = [1,null,2]
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// 👍 979 👎 0

 */
public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> valList = new ArrayList<>();
            preorderTraversal_(root, valList);
            return valList;
        }

        /**
         * 前序遍历：先访问根节点，接着访问左树 最后访问右侧树
         *
         * 参考：P94
         * 前序遍历 递归简化
         * 1.先访问根节点: System.out.println(node.val)
         * 2.再访问左子树: recursion(node.left)
         * 3.最后访问右子树: recursion(node.right)
         *
         * @param root
         * @param valList
         * @return
         */
        public void preorderTraversal_(TreeNode root, List<Integer> valList) {
            if (root == null) {
                return;
            }
            valList.add(root.val);
            preorderTraversal_(root.left, valList);
            preorderTraversal_(root.right, valList);
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
