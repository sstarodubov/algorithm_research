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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> xs ;
        dfs(root, xs);
        return xs;
    }

    void dfs(TreeNode* node, vector<int>& xs) {
        if (node == nullptr) return;
        dfs(node->left,xs);
        xs.push_back(node->val);
        dfs(node->right, xs);
    }
};
int main() {
    auto *p = new TreeNode();
    auto *q = new TreeNode();
    vi pv = {1, 2, 3};
    buildBinaryTree(pv, p);
    buildBinaryTree(pv, q);

    cout << Solution().isSameTree(p, q);
    return 0;
}

