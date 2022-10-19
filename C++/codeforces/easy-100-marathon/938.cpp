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
    int ans = 0;
    int low;
    int high;
    int rangeSumBST(TreeNode *root, int low, int high) {
        this->low = low;
        this->high = high;
        dfs(root);
        return ans;
    }

    void dfs(TreeNode* node) {
        if (node == nullptr) return;

        if (node->val >= low && node->val <= high) {
            ans += node->val;
        }

        if (node->val > low) dfs(node->left);
        if (node->val < high) dfs(node->right);
    }
};

int main() {
    TreeNode *root = new TreeNode();
    vi v = {10, 5, 15, 3, 7, 13, 18, 1, NULL_TREE_NODE, 6};
    buildBinaryTree(v, root);
    cout << Solution().rangeSumBST(root, 6, 11);
    delete root;
    return 0;
}

