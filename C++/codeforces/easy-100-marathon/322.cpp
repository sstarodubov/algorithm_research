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
    int coinChange(vector<int> &coins, int amount) {
        int ans = 0, N = amount + 1;
        int dp[N];
        fill_n(dp, N, INT32_MAX);
        dp[0] = 0;

        for (int &coin: coins) {
            for (int n = 1; n < N; ++n) {
                int r = n - coin;
                if (r < 0) continue;
                if (dp[r] != INT32_MAX) {
                    dp[n] = min(dp[n], dp[r] + 1);
                }
            }
        }

        return dp[N - 1] == INT32_MAX ? -1 : dp[N - 1];
    }
};

int main() {
    vi v = {1, 2, 5};
    cout << Solution().coinChange(v, 11);
    return 0;
}

