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
    int maxArea(vector<int> &height) {
        int ans = 0, sq;
        int l = 0 , r = height.size() - 1;

        while (l < r) {
            sq = min(height[l], height[r]) * (r - l);
            ans = max(ans, sq);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }
};

int main() {
    vi v = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    cout << Solution().maxArea(v);
    return 0;
}

