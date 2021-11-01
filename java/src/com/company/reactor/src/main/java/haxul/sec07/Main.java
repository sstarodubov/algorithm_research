package haxul.sec07;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        var ints = new ArrayList<Person>();
        for (int i = 0; i < 1000000000; i++) {
            Thread.sleep(10);
            ints.add(new Person(i));
        }
        System.out.println(ints);
    }

    public static void sort(List<Integer> arr) {
        var pq = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            pq.add(arr.get(i));
        }
        arr.clear();
        while (!pq.isEmpty()) {
            arr.add(pq.poll());
        }
    }
}

@RequiredArgsConstructor
class Person {
    final int a;
    int[] ints = new int[1000];
    Person[] person = new Person[100000];
}
