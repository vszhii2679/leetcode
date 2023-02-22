package com.cheese.leetcode.editor.cn;

/*
Java：删除链表的倒数第 N 个结点
------------------------
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 👍 2413 👎 0

 */
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //
            return removeNthFromEnd_(head, n);
        }

        /**
         * 删除倒数第n个节点
         * 双指针
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd_(ListNode head, int n) {
            //定位两个指针的初始位置
            ListNode pa = head;
            ListNode pb = pa;
            for (int i = 1; i <= n; i++) {
                pb = pb.next;
                //1 <= n <= sz，需要截断头节点的情况
                if (pb == null) {
                    return head.next;
                }
            }
            //开始循环
            while (pb.next != null) {
                pa = pa.next;
                pb = pb.next;
            }
            // 出循环时 pb指向的是最末一个节点，pa指向的是需要截断的节点
            pa.next = pa.next.next;
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
