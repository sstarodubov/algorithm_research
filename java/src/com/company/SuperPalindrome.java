package com.company;


public class SuperPalindrome {

    public static void main(String[] args) {
        var e = new SuperPalindrome();
        assert 2 == e.superPalindrome("40000000000000000", "50000000000000000") : "4";
        System.out.println("tests passed");
    }

    public int superPalindrome(String sL, String sR) {
        long L = Long.parseLong(sL);
        long R = Long.parseLong(sR);
        int MAGIC = 100000;
        int ans = 0;

        // count odd length;
        for (int k = 1; k < MAGIC; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 2; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v)) ans++;
        }

        // count even length;
        for (int k = 1; k < MAGIC; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v)) ans++;
        }

        return ans;
    }

    // RAM O(1) and CPU O(n)
    private boolean isPalindrome(String v) {
        int l = 0;
        int r = v.length() - 1;
        while (l <= r) {
          if (v.charAt(l) == v.charAt(r)) {
              r--;
              l++;
          } else return false;
        }
        return true;
    }

    public boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    public long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }

        return ans;
    }
}











