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
    vector<int> runningSum(vector<int> &nums) {
        vector<int> arr(nums.size());
        std::fill(arr.begin(), arr.end(), 0);

        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0) {
                arr[0] = nums[0];
            }
            else {
                arr[i] = arr[i - 1] + nums[i];
            }
        }
        return arr;
    }
};

int main() {
    vi v3 = {1, 2, 3, 4, 5};
    auto a = Solution().runningSum(v3);

    return 0;
}

