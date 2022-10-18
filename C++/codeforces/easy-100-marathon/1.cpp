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
    vector<int> twoSum(vector<int> &nums, int target) {
        unordered_map<int, int> s;
        int d;

        for (int i = 0; i < nums.size(); ++i) {
            d = target - nums[i];
            if (s.find(d) != s.end()) {
                return {s[d], i};
            }
            s.insert({nums[i], i});
        }
        return {-1, -1};
    }
};

int main() {
    vector<string> v = {"flower", "flow", "e"};
    auto a = Solution().longestCommonPrefix(v);
    cout << a;
    return 0;
}

