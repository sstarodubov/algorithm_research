package com.company;

public class FirstBadVersion {
    public static void main(String[] args) {
        var m = new FirstBadVersion();
        assert 1702766719 == m.firstBadVersion(2126753390);
        System.out.println("tests passed");
    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int v = l + (r - l) / 2;
        while (l + 1 != r && l != r) {
            if (isBadVersion(v)) r = v;
            else l = v;
            v = l + (r - l) / 2;
        }
        if (isBadVersion(l)) return l;
        return r;
    }

    boolean isBadVersion(int version) {
        if (version >= 1702766719) return true;
        return false;
    }
}
