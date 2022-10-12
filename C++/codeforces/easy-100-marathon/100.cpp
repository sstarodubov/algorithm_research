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
    bool isSameTree(TreeNode *p, TreeNode *q) {
        if (p == nullptr && q == nullptr) return true;
        if (p == nullptr) return false;
        if (q == nullptr) return false;
        if (p->val != q->val) return false;
        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
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

