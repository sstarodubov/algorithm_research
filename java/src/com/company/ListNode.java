package com.company;


public class ListNode {

    public int val;
    public ListNode next;


    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildLinkedList(int[] values) {
        if (values.length == 0) return new ListNode(0);
        var root = new ListNode(values[0]);
        ListNode cur = root;
        int i = 1;
        while (i < values.length) {
            var nn = new ListNode(values[i]);
            cur.next = nn;
            cur = nn;
            i++;
        }
        return root;
    }

    @Override
    public String toString() {
        return "Node(" + val + ")";
    }
}
