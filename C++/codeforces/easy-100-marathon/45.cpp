#pragma clang diagnostic push
#pragma ide diagnostic ignored "readability-convert-member-functions-to-static"

#include <iostream>
#include <vector>
#include <algorithm>
#include "helper.h"

using namespace std;
typedef vector<int> vi;
typedef vector<vector<int>> vvi;


class Solution {
public:
    int jump(vector<int> &nums) {
        int cur = 0, mx = 0, N = nums.size();
        int dp[N];

        for (int i = 0; i < N; ++i) {
            dp[i] = INT32_MAX;
        }

        dp[0] = 0;

        while (cur < nums.size() && cur <= mx) {
            mx = max(mx, nums[cur] + cur);
            for (int i = cur + 1; i < N && i <= mx; ++i) {
                dp[i] = min(dp[i], dp[cur] + 1);
            }
            cur++;
        }

        return dp[N - 1];
    }
};

int main() {
    vi v = {2, 3, 1, 1, 4};
    cout << Solution().jump(v);
    return 0;
}