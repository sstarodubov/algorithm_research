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
    vector<string> binaryTreePaths(TreeNode *root) {
        vector<string> ans;
        vector<TreeNode *> cur_path;
        dfs(root, ans, cur_path);
        return ans;
    }

    void dfs(TreeNode *node, vector<string> &v, vector<TreeNode *> cur_path) {
        if (node == nullptr) return;
        cur_path.push_back(node);
        if (node->right == nullptr && node->left == nullptr) {
            string s;
            for (int i = 0; i < cur_path.size(); ++i) {
                if (i != cur_path.size() - 1)s += to_string(cur_path[i]->val) + "->";
                else s += to_string(cur_path[i]->val);
            }
            v.push_back(s);
            cur_path.pop_back();
            return;
        }

        dfs(node->left, v, cur_path);
        dfs(node->right, v, cur_path);

    }
};

int main() {
    vi v = {1, 2, 3};
    auto *head = new TreeNode();
    buildBinaryTree(v, head);
    auto ans = Solution().binaryTreePaths(head);
    for (int i = 0; i < ans.size(); ++i) {
        cout << ans[i] << endl;
    }
    return 0;
}

