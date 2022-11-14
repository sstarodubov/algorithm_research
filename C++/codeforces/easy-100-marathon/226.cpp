#pragma clang diagnostic push
#pragma ide diagnostic ignored "readability-convert-member-functions-to-static"

#include <iostream>
#include <vector>
#include <algorithm>
#include "helper.h"

using namespace std;
typedef vector<int> vi;
typedef vector<vector<int>> vvi;

class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == nullptr) return nullptr;

        TreeNode* t = root->left;

        root->left = root->right;
        root->right = t;

        invertTree(root->left);
        invertTree(root->right);

        return root;
    }
};
int main() {
    vi v = {5, 1, 2, 3, 4};
    cout << Solution().findMin(v);
    return 0;
}