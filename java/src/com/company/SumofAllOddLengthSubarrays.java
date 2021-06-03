package com.company;

public class SumofAllOddLengthSubarrays {


    public static void main(String[] args) {

        assert 3 == sumOddLengthSubarrays(new int[]{1, 2}) : 0;
        assert 58 == sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}) : 2;
        assert 12 == sumOddLengthSubarrays(new int[]{1, 2, 3}) : 1;
        assert 25 == sumOddLengthSubarrays(new int[]{1, 2, 3, 4}) : 0;
        System.out.println("tests passed");
    }

    // Time O(n^2) and Space O(1)
    public static int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        int size = 1;
        int ptr = 0;
        while (size < arr.length) {
            if (ptr + size > arr.length) {
                size += 2;
                ptr = 0;
                if (size > arr.length) return ans;
            }
            for (int i = ptr; i < ptr + size; i++) {
                ans += arr[i];
            }
            ptr++;
        }
        return ans;
    }
}
