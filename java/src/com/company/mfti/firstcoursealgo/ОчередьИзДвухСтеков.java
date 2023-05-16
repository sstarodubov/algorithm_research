package com.company.mfti.firstcoursealgo;

import java.util.ArrayDeque;

public class ОчередьИзДвухСтеков {
    public static void main(String[] args) {
        var queue = new QueueFromTwoStack();
        queue.add(10);
        queue.add(11);
        queue.add(12);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}


class QueueFromTwoStack {
    /*
     -----------
  -----> push   | stack1
     -----------
|        shift
 -----------------
                 |
                 \/
     -----------
    |  stack2  -------> pop
     -----------

     */
    private final ArrayDeque<Integer> left = new ArrayDeque<>();
    private final ArrayDeque<Integer> right = new ArrayDeque<>();

    private void shift() {
        while (left.size() > 0) {
            right.push(left.pop());
        }
    }

    public void add(int v) {
        left.push(v);
    }

    public int remove() {
        if (right.size() == 0) {
            shift();
        }

        return right.pop();
    }
}
