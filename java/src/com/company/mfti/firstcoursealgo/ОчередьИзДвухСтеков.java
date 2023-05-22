package com.company.mfti.firstcoursealgo;

import java.util.ArrayDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class ОчередьИзДвухСтеков {


    public static Function<Integer, Integer> closure() {
        final var atom = new AtomicInteger(10);
        return atom::addAndGet;
    }

    public static void main(String[] args) {
        
        System.out.println(closure().apply(10)
        );

    }
}

class StackMin {
    private final ArrayDeque<Integer> stack = new ArrayDeque<>();
    private final ArrayDeque<Integer> mins = new ArrayDeque<>();

    public void push(int v) {
        stack.push(v);

        if (mins.size() > 0) {
            mins.push(Math.min(v, mins.peek()));
        } else {
            mins.push(v);
        }
    }

    public int pop() {
        mins.pop();
        return stack.pop();
    }


    public int min() {
        if (mins.isEmpty()) return -1;

        return mins.peek();
    }

    public int size() {
        return stack.size();
    }
}

class QueueMin {
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
    private final StackMin left = new StackMin();
    private final StackMin right = new StackMin();

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

    public int min() {
        if (left.min() == -1) return right.min();
        if (right.min() == -1) return left.min();
        return Math.min(left.min(), right.min());
    }
}
