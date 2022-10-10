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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    TreeNode *sortedArrayToBST(vector<int> &nums) {
        if (nums.size() == 0) return nullptr;

        int midx = nums.size() / 2;
        auto *node = new TreeNode(nums[midx]);

        if (nums.size() == 1) {
            return node;
        }
        auto mit = nums.begin() + (nums.size() / 2);
        vector<int> lv(nums.begin(), mit);
        vector<int> rv(mit + 1, nums.end());
        node->left = sortedArrayToBST(lv);
        node->right = sortedArrayToBST(rv);

        return node;
    }
};

int main() {
    vi v = {-10, -3, 0, 5, 9};
    auto ans = Solution().sortedArrayToBST(v);
    return 0;
}

