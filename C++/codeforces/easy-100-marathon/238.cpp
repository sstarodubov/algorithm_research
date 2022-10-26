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
    vector<int> productExceptSelf(vector<int> &nums) {
        int L = nums.size();
        int f[L];
        int b[L];

        f[0] = nums[0];
        for (int i = 1; i < L; ++i) {
            f[i] = f[i - 1] * nums[i];
        }

        b[L - 1] = nums[L - 1];

        for (int i = L - 2; i >= 0; --i) {
            b[i] = b[i + 1] * nums[i];
        }

        vector<int> ans(L);

        ans[0] = b[1];
        ans[L - 1] = f[L - 2];
        for (int i = 1; i < L - 1 ; ++i) {
            ans[i] = f[i - 1] * b[i + 1];
        }

        return ans;
    }
};

int main() {
    vi v = {1, 2, 3, 4};
    auto ans = Solution().productExceptSelf(v);
    // [1 , 2 , 3, 4] nums
    // [24, 12, 8, 6] ans

    // [1,  2,  6, 24] f
    // [24, 24, 12, 4] b
    return 0;
}

