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
    bool ans = false;

    bool isSubtree(TreeNode *root, TreeNode *subRoot) {
        dfs(root, subRoot);
        return ans;
    }

    void dfs(TreeNode *node, TreeNode *sub) {
        if (ans) return;
        if (node == nullptr) return;

        if (is_same(node, sub)) {
            ans = true;
            return;
        }

        dfs(node->left, sub);
        dfs(node->right, sub);
    }

    bool is_same(TreeNode *n1, TreeNode *n2) {
        if (n1 == nullptr && n2 == nullptr) return true;
        if (n1 == nullptr) return false;
        if (n2 == nullptr) return false;
        if (n1->val != n2->val) return false;

        return is_same(n1->left, n2->left) && is_same(n1->right, n2->right);
    }
};


int main() {
    return 0;
}

