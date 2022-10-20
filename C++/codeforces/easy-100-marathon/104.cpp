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
    int maxDepth(TreeNode *root) {
        if (root == nullptr) return 0;

        int l = maxDepth(root->left);
        int r = maxDepth(root->right);

        return max(l, r) + 1;
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

