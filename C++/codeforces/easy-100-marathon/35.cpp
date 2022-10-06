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
#include "helper.h"

using namespace std;

typedef vector<int> vi;


class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int l = 0 , r = nums.size() - 1, m;

        while (l <= r) {
            m = (l + r) / 2;

            if (nums[m] == target ) return m;

            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
};

int main() {
    vi v  = {1,3,5,6};
    cout << Solution().searchInsert(v, 7);
    return 0;
}

