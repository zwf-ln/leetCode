package com.zl.list;

//合并两个有序链表
public class MergerTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        l4.next = l1;
        l1.next = l2;
        ListNode l22 = new ListNode(2);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(4);
        ListNode l25 = new ListNode(5);
        ListNode l26 = new ListNode(6);
        l22.next = l26;
        l26.next = l23;
        l23.next = l25;
        l25.next = l24;
        ListNode result = mergeTwoLists(l3, l22);
        System.out.println(result.val);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
            temp.next = null;
        }
        temp.next = l1 == null ? l2 : l1;
        return head.next;
    }
    //递归解法
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val > l2.val) {
            //如果l1的值大于l2的, 取l2的值.
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
