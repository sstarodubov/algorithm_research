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
    bool isMonotonic(vector<int> &nums) {
        bool acs = true, desc = true;

        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] < nums[i - 1]) {
                acs = false;
                break;
            }
        }

        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] > nums[i - 1]) {
                desc = false;
                break;
            }
        }

        return desc || acs;
    }
};

int main() {
    vi v = {3, 1, 2, 4};
    Solution().isMonotonic();
    return 0;
}

