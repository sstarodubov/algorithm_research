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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    int majorityElement(vector<int> &nums) {
        unordered_map<int, int> m;

        for (auto & n : nums) {
            if (m.find(n) == m.end()) {
                m[n] = 1;
            } else m[n] += 1;
        }

        int ans = -1, mx_v = INT32_MIN;

        for(auto& [k,v] : m) {
            if (v > mx_v) {
                ans = k;
                mx_v = v;
            }
        }
        return ans;
    }
};

int main() {
    vi v = {3, 3, 4};
    cout << Solution().majorityElement(v);
    return 0;
}

