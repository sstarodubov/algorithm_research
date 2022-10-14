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
    int longestPalindrome(string s) {
        unordered_map<char, int> mp;

        for (int i = 0; i < s.length(); ++i) {
            mp[s[i]] += 1;
        }

        if (mp.size() == 1) {
            return mp.size();
        }
        int ans = 0;
        bool once = false;
        for (auto &[ch, n]: mp) {
            if ((n & 1) == 0) {
                ans += n;
            } else {
                if (!once) {
                    once = true;
                    ans++;
                }
                ans += (n - 1);
            }
        }

        return ans;
    }
};

int main() {
    cout << Solution().longestPalindrome("bananas");
    return 0;
}

