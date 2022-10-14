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
    int findMaxConsecutiveOnes(vector<int> &nums) {
        int k = nums[0] == 1 ? 1 : 0, ans = 0;

        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] == 1 && nums[i - 1] == 1) {
                k++;
            } else if (nums[i] == 1) {
                k = 1;
            } else {
                ans = max(ans, k);
                k = 0;
            }
        }

        return max(ans, k);
    }
};

int main() {
    vi v = { 1 ,1,  0 , 1};
    cout << Solution().findMaxConsecutiveOnes(v);

    return 0;
}

