#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>
#include <unordered_set>
#include <cstring>
#include "helper.h"

using namespace std;

class Solution {

public:
    vector<int> v;

    vector<int> postorderTraversal(TreeNode *root) {
        dfs(root, v);
        return v;
    }

    void dfs(TreeNode *node, vector<int> &v) {
        if (node == nullptr) return;

        dfs(node->left, v);
        dfs(node->right, v);

        v.push_back(node->val);
    }
};


int main() {
    vector<int> v = {1, NULL_TREE_NODE, 2, 3};
    TreeNode node;
    buildBinaryTree(v, &node);
    auto ans = Solution().postorderTraversal(&node);
    return 0;
}

