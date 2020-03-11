package com.hoopluz.WeiXinRedPackage1.LeetCode;

/**
 * Author : lihuiming
 * Description :
 * Date : 2020/3/10 0010
 * Time : 17:30
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
    // Memory Usage: 38.5 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
    //Memory Usage: 38.8 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l2 == null ? l1 : l2;
        ListNode first = (l2.val < l1.val) ? l2 : l1;
        first.next = mergeTwoLists2(first.next, first == l1 ? l2 : l1);
        return first;
    }


}
