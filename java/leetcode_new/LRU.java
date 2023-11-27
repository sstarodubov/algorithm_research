import java.util.LinkedHashMap;

public class LRU {
    public static void main(String[] args) {
        var c2 = new LRUCache(2);
        c2.put(2, 1);
        c2.put(1, 1);
        c2.put(2, 3);
        c2.put(4, 1);
        assert -1 == c2.get(1);
        assert 3 == c2.get(2);


        var cache = new LRUCache(2);
        assert -1 == cache.get(-2);
        cache.put(2, 6);
        assert -1 == cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        assert 2 == cache.get(1);
        assert 6 == cache.get(2);

        var c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        assert 1 == c.get(1);
        c.put(3, 3);
        assert -1 == c.get(2);
        c.put(4, 4);
        assert -1 == c.get(1);
        assert 3 == c.get(3);
        assert 4 == c.get(4);
    }
}


class LRUCache {
    final int cap;
    final LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    private void doLRU() {
        if (m.size() < cap) return;
        var lru = m.entrySet().iterator().next();
        m.remove(lru.getKey());
    }

    public int get(int key) {
        if (!m.containsKey(key)) {
            return -1;
        }
        var v = m.get(key);
        m.remove(key);
        m.put(key, v);
        return v;
    }

    public void put(int key, int value) {
        if (!m.containsKey(key)) {
            doLRU();
        }
        m.remove(key);
        m.put(key, value);
    }
}
