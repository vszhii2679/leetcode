package com.cheese.leetcode.editor.cn;

/*
Java：删除排序链表中的重复元素
------------------------
//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// 👍 924 👎 0

 */
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        // TO TEST
//        solution.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2))));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //考察：链表
        public ListNode deleteDuplicates(ListNode head) {
            return deleteDuplicates_(head);
        }

        /**
         * 解题思路：链表节点的访问
         *
         * @param head
         * @return
         */
        public ListNode deleteDuplicates_(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode curr = head;
            //下一级与下下级进行比较
            while (curr.next != null) {
                if (curr.val == curr.next.val) {
                    //如果当前节点值与下个节点的值相同，将下个节点的下一级设为当前节点的下一级 继续循环
                    curr.next = curr.next.next;
                } else {
                    //如果当前节点值与下个节点的值不同，将当前节点向后顺移，继续向下循环
                    curr = curr.next;
                }
            }
            //
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


