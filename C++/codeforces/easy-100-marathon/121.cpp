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
    int maxProfit(vector<int> &prices) {
        int l = 0, ans = 0, d;

        for (int r = 0; r < prices.size(); ++r) {
            if (prices[l] >= prices[r]) {
                l = r;
            } else {
                d = prices[r] - prices[l];
                ans = max(ans, d);
            }
        }

        return ans;
    }
};

int main() {
    vi v = {7, 1, 5, 3, 6, 4};
    cout << Solution().maxProfit(v);
    return 0;
}

