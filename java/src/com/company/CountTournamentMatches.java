package com.company;

public class CountTournamentMatches {
    public static void main(String[] args) {

        assert 6 == numberOfMatches(7);
        assert 13 == numberOfMatches(14);
        System.out.println("tests passed");
    }

    public static int numberOfMatches(int n) {
        return numberOfMatchesHelper(n, 0);
    }
    public static int numberOfMatchesHelper(int n, int out) {
        if (n == 1) return out;
        if ((n & 1) == 1) {
            int played = (n - 1) / 2;
            int commands = (n - 1) / 2 + 1;
            return numberOfMatchesHelper(commands, played + out);
        }
        int p = n / 2;
        return numberOfMatchesHelper(p, p + out);
    }
}
