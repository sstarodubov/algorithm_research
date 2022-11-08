#include <iostream>
#include <vector>
#include <algorithm>
#include "helper.h"

using namespace std;

class Solution {
public:
    int ans = INT32_MIN;
    int diameterOfBinaryTree(TreeNode* root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode* node) {
        if (node == nullptr) return 0;
        if (node->left == nullptr && node->right == nullptr) return 1;

        int dl = dfs(node->left);
        int dr = dfs(node->right);
        ans = max(ans, dl + dr);
        return max(dl, dr) + 1;
    }
};

typedef vector<int> vi;
int main() {
    TreeNode* root = new TreeNode();

    buildBinaryTree(vi {1,2}, root);

    cout << Solution().diameterOfBinaryTree(root);

    return 0;
}


