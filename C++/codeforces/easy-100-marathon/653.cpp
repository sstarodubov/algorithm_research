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
    unordered_set<int> set;
    bool flag = false;

    bool findTarget(TreeNode *root, int k) {
        dfs(root, k);
        return flag;
    }

    void dfs(TreeNode *node, int k) {
        if (flag) return;
        if (node == nullptr) return;

        int d = k - node->val;

        if (set.find(d) != set.end()) {
            flag = true;
            return;
        }

        set.insert(node->val);

        dfs(node->left, k);
        dfs(node->right, k);
    }
};

int main() {

    return 0;
}

