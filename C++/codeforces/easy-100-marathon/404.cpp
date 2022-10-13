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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    int sumOfLeftLeaves(TreeNode *root) {
        return dfs(root, 'R');
    }

    int dfs(TreeNode * node, char D) {
        if (node == nullptr) return 0;
        if (node->left == nullptr && node->right == nullptr && D == 'L') return node->val;

        auto ls = dfs(node->left, 'L');
        auto rs = dfs(node->right, 'R');

        return ls + rs;
    }
};

int main() {
    auto *root = new TreeNode();
    vi v = {3, 9, 20, NULL_TREE_NODE, NULL_TREE_NODE, 15, 7};
    buildBinaryTree(v, root);
    cout << Solution().sumOfLeftLeaves(root);

    delete root;
    return 0;
}

