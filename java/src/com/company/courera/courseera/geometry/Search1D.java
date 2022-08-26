package geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

class RangeSet<K extends Comparable<K>> extends TreeSet<K> {
    public List<K> range(K k1, K k2) {
        var list = new ArrayList<K>();
        var cur = ceiling(k1);
        if (cur == null) return list;

        while (cur.compareTo(k2) <= 0) {
            list.add(cur);
            cur = higher(cur);
            if (cur == null) return list;
        }

        return list;
    }

    public int rangeCount(K k1, K k2) {
        return range(k1, k2).size();
    }
}

public class Search1D {
    public static void main(String[] args) {
        var rs = new RangeSet<Integer>();
        rs.add(10);
        rs.add(12);
        rs.add(14);
        rs.add(16);

        System.out.println(rs.range(11, 15));
        System.out.println(rs.rangeCount(11, 15));
    }
}

