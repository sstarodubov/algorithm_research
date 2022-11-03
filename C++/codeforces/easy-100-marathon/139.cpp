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
    unordered_set<string> set;
    unordered_map<string, int> dp;

    bool ans = false;

    bool wordBreak(string s, vector<string> &wordDict) {
        for (string &w: wordDict) {
            set.insert(w);
        }
        dfs(s);

        return ans;

    }

    void dfs(const string &s) {
        if (dp[s] == -1) return;

        if (ans) return;
        if (s == "") {
            ans = true;
            return;
        }

        for (int i = 0; i <= s.length(); ++i) {
            string l = s.substr(0, i);
            if (set.find(l) != set.end()) {
                string r = s.substr(i, s.length());
                dfs(r);
            } else {
                if (l != "") dp[l] = -1;
            }
        }
    }
};

int main() {
    vector<string> v5 = {"apple", "pen"};
    cout << Solution().wordBreak("applepenapple", v5);

    vector<string> v4 = {"a", "abc", "b", "cd"};
    cout << Solution().wordBreak("abcd", v4);

    vector<string> v2 = {"a", "b", "bbb", "bbbb"};
    cout << Solution().wordBreak("bb", v2) << endl;

    vector<string> v = {"leet", "code"};
    cout << Solution().wordBreak("leetcodeleet", v) << endl;

    vector<string> v1 = {"aaaa", "aaa"};
    cout << Solution().wordBreak("aaaaaaa", v1) << endl;

    return 0;
}

