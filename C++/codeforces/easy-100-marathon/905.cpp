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
    vector<int> sortArrayByParity(vector<int> &nums) {
        if (nums.size() == 1) return nums;
        int t;
        int odd = nums.size() - 1, even = 0;

        while (even < odd) {
            while (even < odd && (nums[even] & 1) == 0) {
                even++;
            }

            while (odd > even && (nums[odd] & 1) == 1) {
                odd--;
            }
            t = nums[even];
            nums[even] = nums[odd];
            nums[odd] = t;

            even++;
            odd--;
        }

        return nums;
    }
};

int main() {
    vi v = {3, 1, 2, 4};
    Solution().sortArrayByParity(v);
    return 0;
}

