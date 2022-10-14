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
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> v;
        stack<TreeNode *> stk;
        stk.push(root);

        while (!stk.empty()) {
            auto *n = stk.top();
            if (n == nullptr) continue;
            v.push_back(n->val);
            stk.push(n->right);
            stk.push(n->left);
        }

        return v;
    }
};

int main() {
    auto *root = new TreeNode();
    vi v = {1, NULL_TREE_NODE, 2, 3};
    buildBinaryTree(v, root);
    Solution().preorderTraversal(root);

    delete root;
    return 0;
}

