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
    bool ans = true;
    bool isBalanced(TreeNode *root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode* node) {
        if (!ans) return -1;
        if (node == NULL) return 0;

        int ld = dfs(node->left);
        int rd = dfs(node->right);

        if (abs(ld - rd) > 1) {
            ans = false;
            return -1;
        }

        return max(ld, rd) + 1;
    }
};

int main() {
    vi v = {1, 2, 2, 3, 3, NULL_TREE_NODE, NULL_TREE_NODE, 4, 4};
    auto *root = new TreeNode();
    buildBinaryTree(v, root);
    cout << Solution().isBalanced(root);

    return 0;
}

