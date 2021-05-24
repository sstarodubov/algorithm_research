package com.company;


public class RichestCustomerWealth {
    public static void main(String[] args) {

        var rw = new RichestCustomerWealth();
        assert 6 == rw.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}) : 0;
        assert 10 == rw.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}) : 1;

        System.out.println("tests passed");
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int customer = 0; customer < accounts.length; customer++) {
            int cur = 0;
            for (int bank = 0; bank < accounts[customer].length; bank++) {
                cur+= accounts[customer][bank];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
