package com.company.neetcode;

import com.company.ListNode;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}

public class M138 {

    public static void main(String[] args) {
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        var n10 = new Node(10);
        var n1 = new Node(1);

        n7.next = n13;
        n7.random = null;

        n13.next = n11;
        n13.random = n7;

        n11.next = n10;
        n11.random = n1;

        n10.next = n1;
        n10.random = n11;

        n1.random = n7;

        Node node = new M138().copyRandomList(n7);
        System.out.println(node);
    }
    public Node copyRandomList(Node head) {
        var hm  = new HashMap<Node, Node>();
        var dummy = new Node(-1);
        Node curOld = head;
        Node curNew = dummy;

        while (null != curOld) {
            curNew.next = new Node(curOld.val);
            curNew = curNew.next;
            hm.put(curOld, curNew);
            curOld = curOld.next;

        }

        curOld = head;
        curNew = dummy.next;

        while (null != curNew) {
            curNew.random = hm.get(curOld.random);
            curNew = curNew.next;
            curOld = curOld.next;
        }

        return dummy.next;
    }
}
