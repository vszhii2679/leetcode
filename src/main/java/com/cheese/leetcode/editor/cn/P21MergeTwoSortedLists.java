package com.cheese.leetcode.editor.cn;

/*
Java：合并两个有序链表
------------------------
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// 👍 2860 👎 0

 */
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode node2 = new ListNode(2, new ListNode(3, new ListNode(4)));
        //合并两个有序链表
        ListNode listNode = solution.mergeTwoLists(node1, node2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //考察：链表 递归
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            return mergeTwoLists_(list1, list2);
        }

        /**
         * 递归处理 获取两个连标获取下一个节点中最小值的节点拼接到新链表中
         *
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists_(ListNode list1, ListNode list2) {
            //针对空链的处理 递归的终点
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            // 确认当前一级两个数据的位置
            if (list1.val < list2.val) {
                //头部为list1
                list1.next = mergeTwoLists_(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists_(list1, list2.next);
                return list2;
            }
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
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
