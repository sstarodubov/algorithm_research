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
    void rotate(vector<int>& nums, int k) {
        if (k == 0) return;
        if (k == nums.size()) return;
        if (k > nums.size()) {
            k %= nums.size();
        }

        int tarr[nums.size()];

        int p = nums.size() - k;

        for (int i = 0; i < k; ++i, ++p) {
            tarr[i] = nums[p];
        }

        p = 0;

        for (int i = k; i < nums.size(); ++i, ++p) {
            tarr[i] = nums[p];
        }

        for (int i = 0; i < nums.size(); ++i) {
            nums[i] = tarr[i];
        }

    }
};
int main() {
    vi v = {1,2,3,4,5,6,7};
    Solution().rotate(v, 7);
    return 0;
}