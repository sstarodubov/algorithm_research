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
    int removeElement(vector<int> &nums, int val) {
        if (nums.empty()) return 0;
        int l = 0, r = nums.size() - 1, t;

        while (l < r) {
            while (l < r && nums[l] != val) {
                l++;
            }

            while (r > l && nums[r] == val) {
                r--;
                if (l == r) break;
            }

            t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }

        int ans = 0;

        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == val) return ans;
            else ans++;
        }

        return ans;
    }
};

int main() {
    vi v{3};
    cout << Solution().removeElement(v, 2);
    return 0;
}

