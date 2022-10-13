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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    vector<string> summaryRanges(vector<int> &nums) {
        if (nums.empty()) return {};

        vector<string> ans;
        int p = 0;
        int t;
        bool d, si;
        for (int i = 1; i < nums.size(); ++i) {
            t = abs(nums[i]) - abs(nums[i - 1]);
            d = t <= 1 &&  t >= -1;
            si =  ((nums[i] >= 0 && nums[i - 1] >= 0) || (nums[i] < 0 && nums[i - 1] < 0));
            if (d && si) continue;
            if (i - 1 == p) {
                ans.emplace_back(to_string(nums[p]));
            } else {
                ans.emplace_back(to_string(nums[p]) + "->" + to_string(nums[i - 1]));
            }

            p = i;
        }

        if (p == nums.size() - 1) {
            ans.emplace_back(to_string(nums[nums.size() - 1]));
        } else {
            ans.emplace_back(to_string(nums[p]) + "->" + to_string(nums[nums.size() - 1]));
        }

        return ans;
    }
};

/*n
 * Input: nums = [0,1,2,4,5,7]
   Output: ["0->2","4->5","7"]
 */
int main() {
    vi v = {0, 1, 2, 4, 5, 7};
    vi v2 = {0, 2, 3, 4, 6, 8, 9};
    vi v3 = {-2147483648, -2147483647, 2147483647};
    vi v4 = {-1000000000, -9999, 0, 1, 2, 10, 100, 1000, 999999999, 1000000000};
    auto ans = Solution().summaryRanges(v4);
    for (auto a: ans) {
        cout << a << endl;
    }
    return 0;
}

