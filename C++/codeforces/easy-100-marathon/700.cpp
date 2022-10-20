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
    TreeNode* searchBST(TreeNode* root, int val) {
        TreeNode* cur = root;
        while (cur != nullptr) {
            if (cur->val == val) {
                return cur;
            }
            if (cur->val > val) cur = cur->left;
            else cur = cur->right;
        }

        return nullptr;
    }
};
int main() {
    TreeNode* root = new TreeNode();
    vi v = { 4,2,7,1,3};
    buildBinaryTree(v, root);
    auto* ans = Solution().searchBST(root, 2);
    cout << ans->val;
    return 0;
}

