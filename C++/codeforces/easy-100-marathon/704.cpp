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
    int search(vector<int> &nums, int target) {
        int l = 0, r = nums.size() - 1, m;

        while (l <= r) {
            m = (l + r) / 2;

            if (nums[m] == target) return m;

            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
};


int main() {
    vi v = {1, 2, 3, 4, 5, 6};
    cout << Solution().search(v, 2) << endl;
    return 0;
}

