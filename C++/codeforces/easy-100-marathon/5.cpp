#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>
#include <unordered_set>
#include <unordered_map>
#include <cstring>
#include <algorithm>
#include <csignal>
#include "helper.h"
#include <tuple>
#include <queue>
#include <bitset>

using namespace std;

typedef vector<int> vi;

struct Pair {
    int ans;
    int l;
    int r;
};

class Solution {
public:
    string longestPalindrome(string s) {
        if (s.size() == 1) return s;
        int ans = 1,l, r;

        for (int i = 0; i < s.size(); ++i) {
            auto p1  = len_one(s, i);
            auto p2 = len_two(s, i);
            auto &mx = p1.ans > p2.ans ? p1 : p2;
            if (mx.ans > ans) {
                ans = mx.ans;
                l = mx.l;
                r = mx.r;
            }

        }

        string ss;
        if (l >= r) return ss + s[0];
        for (int i = l; i <=r; ++i) {
            ss += s[i];
        }

        return ss;
    }

    // ab c bd
    Pair len_one(string &s, int i) {
        if (i == 0) return {1, i, i};
        if (i == s.size() - 1) return {1, i, i};
        int l = i - 1, r = i + 1;
        int ans = 1;
        Pair p = {1, i, i};
        while (l >= 0 && r < s.size()) {
            if (s[l] == s[r]) {
                p.ans += 2;
                p.l = l;
                p.r = r;
            } else return p;
            l--;
            r++;
        }
        return p;
    }

    // dabbaa
    Pair len_two(string &s, int i) {
        if (i + 1 >= s.size()) return {1, i, i};
        if (s[i] != s[i + 1]) return {1, i, i};

        int l = i - 1, r = i + 2;
        Pair p = {2, i, i + 1};
        while (l >= 0 && r < s.size()) {
            if (s[l] == s[r]) {
                p.ans += 2;
                p.l = l;
                p.r = r;
            } else return p;
            l--;
            r++;
        }
        return p;
    }
};


int main() {

    cout << Solution().longestPalindrome("abcda");

    return 0;
}

