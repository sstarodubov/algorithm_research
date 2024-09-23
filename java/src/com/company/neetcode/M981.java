package com.company.neetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class M981 {

    public static void main(String[] args) {
        var tm = new TimeMap();
        tm.set("h", "1", 1);
        tm.set("h", "2", 3);
        tm.set("h", "3", 6);

        System.out.println(tm.get("h", 0));
    }
    static class TimeMap {

        record Pair(String val, int t) {}
        HashMap<String, List<Pair>> map;

        public TimeMap() {
           map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            var list = map.getOrDefault(key, new ArrayList<>());
            list.add(new Pair(value, timestamp));
            map.putIfAbsent(key, list);
        }

        public String get(String key, int timestamp) {
            var list = map.get(key);
            if (null == list) {
                return "";
            }

            int l = 0, r = list.size() - 1;

            while (l <= r) {
               int m = (l + r) / 2;
               var cur_p = list.get(m);
               if (cur_p.t == timestamp) {
                   return cur_p.val;
               }

               if (cur_p.t < timestamp) {
                   l = m + 1;
               } else {
                   r = m - 1;
               }

            }
            if (l == 0 && r == -1)  {
                return "";
            }
            return list.get(l - 1).val;
        }
    }
}
