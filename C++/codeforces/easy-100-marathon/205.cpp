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


class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> m;
        unordered_map<char, char> p;
        int L = t.size();

        for (int i = 0; i < L; ++i) {
            m[s[i]] = t[i];
            p[t[i]] = s[i];
        }

        for (int i = 0; i < L; ++i) {
            if (m[s[i]] != t[i]) return false;
            if (p[t[i]] != s[i]) return false;
        }
        return true;
    }
};

int main() {

    auto s = "paper";
    auto t = "title";
    auto a = Solution().isIsomorphic(s, t);
    cout << a << endl;
    return 0;
}

