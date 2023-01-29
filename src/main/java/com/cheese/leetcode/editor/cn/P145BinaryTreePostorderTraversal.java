package com.cheese.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
Java：二叉树的后序遍历
------------------------
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// 👍 972 👎 0

 */
public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> valList = new ArrayList<>();
            postorderTraversal_(root, valList);
            return valList;
        }

        /**
         * 后序遍历：先访问左子树，在访问右子树，最后访问根节点
         * <p>
         * 参考：P94
         * 后序遍历：递归简化
         * 1.先访问左子树: recursion(node.left)
         * 2.再访问右子树：recursion(node.right)
         * 3.最后访问根节点: System.out.println(node.val)
         *
         * @param root
         */
        public void postorderTraversal_(TreeNode root, List<Integer> valList) {
            if (root == null) {
                return;
            }
            postorderTraversal_(root.left, valList);
            postorderTraversal_(root.right, valList);
            valList.add(root.val);
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
