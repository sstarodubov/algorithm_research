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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    TreeNode *mergeTrees(TreeNode *root1, TreeNode *root2) {
        if (root1 == nullptr) return root2;
        if (root2 == nullptr) return root1;

        root1->val += root2->val;


        root1->left = mergeTrees(root1->left, root2->left);
        root1->right = mergeTrees(root1->right, root2->right);

        return root1;
    }
};

int main() {
    vi v = {1, 3, 2, 5};
    vi v2 = {2, 1, 3, NULL_TREE_NODE, 4, NULL_TREE_NODE, 7};
    auto *h1 = new TreeNode();
    auto *h2 = new TreeNode();
    buildBinaryTree(v, h1);
    buildBinaryTree(v2, h2);
    auto ans = Solution().mergeTrees(h1, h2);

    return 0;
}

