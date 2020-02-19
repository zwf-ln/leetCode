package com.zl.addTwoNumbers;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        l2.setNext(l3).setNext(l6);
        l9.setNext(l5);
        ListNode listNode = addTwoNumbers(l2, l9);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    //给出两个 非空 的链表用来表示两个非负的整数。
    // 其中，它们各自的位数是按照 逆序 的方式存储的，
    // 并且它们的每个节点只能存储 一位 数字。
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        int val = 0;
        while (l1 != null && l2 != null) {
            val = l1.getVal() + l2.getVal() + val / 10;
            ListNode node = new ListNode(val % 10);
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            val = l1.getVal() + val / 10;
            ListNode node = new ListNode(val % 10);
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            val = l2.getVal() + val / 10;
            ListNode node = new ListNode(val % 10);
            temp.next = node;
            temp = temp.next;
            l2 = l2.next;
        }
        if (val / 10 > 0) {
            ListNode node = new ListNode(val / 10);
            temp.next = node;
        }
        return head.next;
    }

    static class ListNode {
        private int val;
        private ListNode next;
        public ListNode() {
        }
        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public ListNode setVal(int val) {
            this.val = val;
            return this;
        }

        public ListNode getNext() {
            return next;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this.next;
        }
    }
}
