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
    int minDepth(TreeNode *root) {
        if (root == nullptr) return 0;
        return dfs(root);
    }

    int dfs(TreeNode *node) {
        if (node == nullptr) return INT32_MAX;
        if (node->right == nullptr && node-> left == nullptr) return 1;
        int ld = dfs(node->left);
        int rd = dfs(node->right);

        return min(ld, rd) + 1;
    }
};

int main() {
    TreeNode head;
    vi v = {2, NULL_TREE_NODE, 3, NULL_TREE_NODE, 4, NULL_TREE_NODE, 5, NULL_TREE_NODE, 6};
    buildBinaryTree(v, &head);
    cout << Solution().minDepth(&head);
    return 0;
}

