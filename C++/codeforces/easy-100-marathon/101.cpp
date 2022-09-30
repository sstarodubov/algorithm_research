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
    bool isSymmetric(TreeNode *node) {
        if (node == nullptr) return true;
        return dfs(node->left, node->right);
    }

    bool dfs(TreeNode *n1, TreeNode *n2) {
        if (n1 == n2) return true;
        if (n1 == nullptr) return false;
        if (n2 == nullptr) return false;
        if (n1->val != n2->val) return false;

        return dfs(n1->left, n2->right) && dfs(n1->right, n2->left);
    }
};


int main() {
    TreeNode t;
    vector<int> v = {1, 2, 2, 3, 4, 4, 3};
    vector<int> rv = {1, 2, 2, NULL_TREE_NODE, 3, NULL_TREE_NODE, 3};
    buildBinaryTree(rv, &t);
    auto ans = Solution().isSymmetric(&t);
    cout << ans;
    return 0;
}

