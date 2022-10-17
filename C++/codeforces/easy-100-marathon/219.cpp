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
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        if (k == 0) return false;

        unordered_set<int> set;

        for (int i = 0; i <= k && i < nums.size(); ++i) {
            if (set.find(nums[i]) == set.end()) {
                set.insert(nums[i]);
            } else {
                return true;
            }
        }
        int begin = 0;
        int end = k + 1;
        while (end < nums.size()) {
            set.erase(nums[begin]);
            if (set.find(nums[end]) == set.end()) {
                set.insert(nums[end]);
            } else {
                return true;
            }

            begin++;
            end++;
        }

        return false;
    }
};

int main() {

    vi v1 = {1};

    auto a = Solution().containsNearbyDuplicate(v1, 1);
    cout << a;
    return 0;
}

