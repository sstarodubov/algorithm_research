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
    int removeDuplicates(vector<int> &nums) {
        int w = 1, r = 1;
        while (r < nums.size()) {
            while (nums[r] == nums[r - 1]) {
                r++;
                if (r >= nums.size()) return w;
            }

            nums[w++] = nums[r++];
        }

        return w;
    }
};

int main() {
    vi v = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    vi v2 = {1, 1, 2};
    vi v3 = {1 ,1};
    cout << Solution().removeDuplicates(v3);

    return 0;
}

