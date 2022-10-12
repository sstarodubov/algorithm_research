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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    int findContentChildren(vector<int> &g, vector<int> &s) {
        std::sort(g.begin(), g.end());
        std::sort(s.begin(), s.end());

        int ans = 0, pg = 0, ps = 0;

        while (pg < g.size() && ps < s.size()) {
            if (s[ps] >= g[pg]) {
                ans++;
                pg++;
                ps++;
            } else {
                ps++;
            }
        }

        return ans;
    }
};

int main() {
    vi v = {10, 9, 8, 7};
    vi v2 = {5, 6, 7, 8};
    cout << Solution().findContentChildren(v, v2);
    return 0;
}

