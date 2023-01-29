package com.cheese.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/*
Java：环形链表
------------------------
//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 👍 1725 👎 0

 */
public class P141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new P141LinkedListCycle().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            return hasCycle_(head);
        }

        /**
         * 指针 龟兔赛跑算法 快慢指针
         * 最优解
         * <p>
         * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达
         *
         * @param head
         * @return
         */
        public boolean hasCycle_(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            //定义起始位置
            ListNode turtle = head;
            ListNode rabbit = head.next;
            //如果存在环，那么一定存在一个时刻 两个指针同时指向同一个位置
            while (turtle != rabbit) {
                if (turtle.next == null || rabbit.next == null || rabbit.next.next == null) {
                    return false;
                }
                //每次乌龟进1 兔子进2
                turtle = turtle.next;
                rabbit = rabbit.next.next;
            }
            //一旦指针重合，即不满足循环条件 此时出现环形
            return true;
        }

        /**
         * 通过map进行判断
         * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达
         *
         * @param head
         * @return
         */
        public boolean hasCycle_map(ListNode head) {
            ListNode curr = head;
            Map<ListNode, Boolean> dict = new HashMap<>();
            while (curr != null) {
                if (dict.containsKey(curr)) {
                    return true;
                }
                dict.put(curr, true);
                curr = curr.next;
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
