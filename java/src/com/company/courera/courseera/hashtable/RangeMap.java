package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class RangeMap<K extends Comparable<K>, V> extends TreeMap<K, V> {
    public List<K> range(K k1, K k2) {
        var list = new ArrayList<K>();
        var cur = ceilingKey(k1);
        if (cur == null) return list;

        while (cur.compareTo(k2) <= 0) {
            list.add(cur);
            cur = higherKey(cur);
            if (cur == null) return list;
        }

        return list;
    }

    public static void main(String[] args) {
        var rg = new RangeMap<Integer, String>();
        rg.put(11, "11");
        rg.put(12, "12");
        rg.put(13, "13");
        rg.put(14, "14");
        rg.put(15, "15");
        rg.put(16, "16");

        System.out.println(rg.range(9, 20));
    }
}
