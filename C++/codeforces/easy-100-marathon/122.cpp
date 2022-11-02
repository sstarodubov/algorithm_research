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
        int ans = 0, p = 0;
        for (int i = 1; i < prices.size(); ++i) {
            if (prices[i] <= prices[i - 1]) {
                ans += p;
                p = 0;
            } else {
                p += prices[i] - prices[i - 1];
            }
        }

        return ans + p;
    }
};

int main() {
    vi v = {7, 1, 5, 3, 6, 4};
    vi v2 = {1, 2, 3, 4, 5};
    vi v3 = {7, 6, 4, 2, 1};
    cout << Solution().maxProfit(v3);
    return 0;
}

