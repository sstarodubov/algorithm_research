#pragma clang diagnostic push
#pragma ide diagnostic ignored "readability-convert-member-functions-to-static"

#include <iostream>
#include <vector>
#include <algorithm>
#include "helper.h"

using namespace std;
typedef vector<int> vi;
typedef vector<vector<int>> vvi;

class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        return dfs(root->left, root->right);
    }

    bool dfs(TreeNode* l, TreeNode* r) {
        if (l == nullptr && r == nullptr) return true;
        if (l == nullptr) return false;
        if (r == nullptr) return false;

        if (l->val != r->val) return false;

        return dfs(l->left, r->right) && dfs(l->right, r->left);
    }
};

int main() {
    vi v2 = {1, 2, 2, 3, 4, 4, 3};
    vi v = {1, 2, 2, 2, NULL_TREE_NODE, 2};
    auto *root = new TreeNode();
    buildBinaryTree(v2, root);
    cout << Solution().isSymmetric(root);
    return 0;
}