#pragma clang diagnostic push
#pragma ide diagnostic ignored "readability-convert-member-functions-to-static"

#include <iostream>
#include <vector>
#include <algorithm>
#include "helper.h"

using namespace std;
typedef vector<int> vi;

class Solution {
public:
    bool isValidBST(TreeNode *root) {
        return dfs(root, INT64_MAX, INT64_MIN);
    }


    bool dfs(TreeNode *node, long long max, long long min) {
        if (node == nullptr) return true;

        if (node->val >= max) return false;
        if (node->val <= min) return false;

        return dfs(node->left, node->val, min) && dfs(node->right, max, node->val);
    }
};


int main() {
    auto *root = new TreeNode();
    buildBinaryTree(vi{2147483647}, root);
    cout << Solution().isValidBST(root);

    return 0;
}