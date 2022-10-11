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
    unordered_map<char, int> mp;

    bool isLess(string& a, string& b) {
        int pa = 0 , pb = 0;

        while (pa < a.size() && pb < b.size()) {
            if (mp[a[pa]] == mp[b[pb]]) {
                pa++;
                pb++;
            } else if (mp[a[pa]] < mp[b[pb]]) return true;
            else return false;
        }

        return a.size() <= b.size();
    }
    bool isAlienSorted(vector<string>& words, string order) {
        for (int i = 0; i < order.size(); ++i) {
            mp[order[i]] = i;
        }

        for (int i = 1; i < words.size(); ++i) {
            if (!isLess(words[i - 1], words[i])) return false;
        }

        return true;
    }
};

int main() {
    vector<string>v = {"hello","leetcode"};
    auto ans = Solution().isAlienSorted(v, "hlabcdefgijkmnopqrstuvwxyz");
    cout << ans;
    return 0;
}

