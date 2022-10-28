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
    vector<vector<int>> threeSum(vector<int> &nums) {
        vector<vector<int>> ans;
        sort(nums.begin(), nums.end());

        for (int i = 0; i < nums.size(); ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int t = -nums[i];
            int l = i + 1;
            int r = nums.size() - 1;

            while (l < r) {
                int v = nums[l] + nums[r];
                if (v < t)l++;
                else if (v > t) r--;
                else {
                    vector<int> cur = {nums[i], nums[l], nums[r]};
                    ans.push_back(cur);
                    while (l < r && nums[l] == cur[1]) l++;
                    while (l < r && nums[r] == cur[2]) r--;
                }
            }
        }

        return ans;
    }
};

int main() {
    vi v = {-1, 0, 1, 0};
    auto ans = Solution().threeSum(v);
    return 0;
}

