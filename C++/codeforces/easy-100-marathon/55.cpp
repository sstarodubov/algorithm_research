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
    bool canJump(vector<int> &nums) {
        int cur = 0, mx = 0;

        while (cur < nums.size() && cur <= mx) {
            mx = max(mx, nums[cur] + cur);
            cur++;
        }

        return cur >= nums.size();
    }
};

int main() {
    vi v = {2,0};
    cout << Solution().canJump(v);


    return 0;
}

