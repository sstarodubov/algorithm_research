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
    int findMin(vector<int> &nums) {
        if (nums[0] <= nums[nums.size() - 1]) return nums[0];
        int L = nums.size();
        if (nums[L - 1] < nums[L - 2]) return nums[L - 1];
        int l = 0, r = nums.size() - 1, m;

        while (l <= r) {
            m = (l + (r - l) / 2);
            if (nums[m - 1] > nums[m] && nums[m + 1]) {
                return nums[m];
            } else if (nums[m] > nums[L - 1]) {
                l = m;
            } else {
                r = m;
            }
        }

        return -1;
    }
};

int main() {
    vi v = {5, 1, 2, 3, 4};
    cout << Solution().findMin(v);
    return 0;
}