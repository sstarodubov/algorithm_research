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
    int findLengthOfLCIS(vector<int> &nums) {
        int ans = 0, l = 0;
        int L = nums.size();
        for (int r = 1; r < L; ++r) {
            if (nums[r] > nums[r - 1]) {

            } else {
                ans = max(ans, r - l);
                l = r;
            }
        }


        return max(ans, L - l);
    }
};

int main() {
    vi v = {1, 2, 3, 2, 7};
    cout << Solution().findLengthOfLCIS(v);

    return 0;
}

