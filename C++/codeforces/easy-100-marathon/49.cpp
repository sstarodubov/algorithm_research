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
    vector<vector<string>> groupAnagrams(vector<string> &strs) {
        vector<vector<string>> ans;
        unordered_map<string, vector<string >> m;

        for (auto &str: strs) {
            string key = str;
            std::sort(key.begin(), key.end());
            m[key].emplace_back(str);
        }

        for (auto&[key, val]: m) {
            ans.emplace_back(val);
        }

        return ans;
    }
};

int main() {
    vector<string> v = {"eat", "tea", "tan", "ate", "nat", "bat"};
    auto ans = Solution().groupAnagrams(v);
    return 0;
}

