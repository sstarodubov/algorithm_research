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

struct Pair {
    int d;
    TreeNode *node;
};

class Solution {
public:
    vector<double> averageOfLevels(TreeNode *root) {
        vector<double> ans;
        deque<Pair*> dq;
        dq.push_back(new Pair{0, root});
        Pair* dummy = new Pair {-1, nullptr};
        Pair *prev = dummy;
        long long sum = 0, k = 0;
        Pair *p;
        while (!dq.empty()) {
            p = dq.front();
            dq.pop_front();
            if (prev->d == p->d) {
                sum += p->node->val;
                k++;
            } else {
                prev = p;
                if (k != 0) {
                    double d = ((double) sum) / k;
                    ans.push_back(d);
                }

                sum = p->node->val;
                k = 1;
            }

            if (p->node->left != nullptr) {
                dq.push_back(new Pair{p->d + 1, p->node->left});
            }

            if (p->node->right != nullptr) {
                dq.push_back(new Pair{p->d + 1, p->node->right});
            }
        }
        if (k != 0) {
            double d = (double) sum / k;
            ans.push_back(d);
        }
        return ans;
    }
};
int main() {
    auto *root = new TreeNode();
    buildBinaryTree(vi{970, 953, NULL_TREE_NODE, 945, NULL_TREE_NODE, 944, NULL_TREE_NODE, 928, NULL_TREE_NODE, 793,
                       NULL_TREE_NODE, 892, NULL_TREE_NODE, 887, NULL_TREE_NODE, 887, NULL_TREE_NODE, 878,
                       NULL_TREE_NODE, 852, NULL_TREE_NODE, 837, NULL_TREE_NODE, 830, 844, 828, NULL_TREE_NODE,
                       NULL_TREE_NODE, NULL_TREE_NODE, 818, NULL_TREE_NODE, 898, NULL_TREE_NODE, 775, NULL_TREE_NODE,
                       774, NULL_TREE_NODE, 725, NULL_TREE_NODE, 685, NULL_TREE_NODE, 673, NULL_TREE_NODE, 646,
                       NULL_TREE_NODE, 598, NULL_TREE_NODE, 583, NULL_TREE_NODE, 531, NULL_TREE_NODE, 516,
                       NULL_TREE_NODE, 511, NULL_TREE_NODE, 431, 512, 429, 476, NULL_TREE_NODE, NULL_TREE_NODE, 427,
                       NULL_TREE_NODE, NULL_TREE_NODE, NULL_TREE_NODE, 404, NULL_TREE_NODE, 367, NULL_TREE_NODE, 325,
                       NULL_TREE_NODE, 323, NULL_TREE_NODE, -406, NULL_TREE_NODE, 285, NULL_TREE_NODE, 258,
                       NULL_TREE_NODE, 230, NULL_TREE_NODE, 229, NULL_TREE_NODE, 205, NULL_TREE_NODE, 163,
                       NULL_TREE_NODE, 144, NULL_TREE_NODE, 106, NULL_TREE_NODE, 96, NULL_TREE_NODE, 80, NULL_TREE_NODE,
                       71, NULL_TREE_NODE, 50, NULL_TREE_NODE, -20, NULL_TREE_NODE, -51, NULL_TREE_NODE, -62,
                       NULL_TREE_NODE, -67, NULL_TREE_NODE, -70, NULL_TREE_NODE, -125, NULL_TREE_NODE, -152,
                       NULL_TREE_NODE, -156, NULL_TREE_NODE, -164, NULL_TREE_NODE, -191, NULL_TREE_NODE, -203,
                       NULL_TREE_NODE, -224, NULL_TREE_NODE, -251, NULL_TREE_NODE, -278, NULL_TREE_NODE, -279,
                       NULL_TREE_NODE, -332, NULL_TREE_NODE, -371, NULL_TREE_NODE, 297, NULL_TREE_NODE, -422,
                       NULL_TREE_NODE, -425, NULL_TREE_NODE, -433, NULL_TREE_NODE, -440, NULL_TREE_NODE, -446,
                       NULL_TREE_NODE, -672, NULL_TREE_NODE, -504, NULL_TREE_NODE, -534, NULL_TREE_NODE, -549,
                       NULL_TREE_NODE, -553, NULL_TREE_NODE, -566, NULL_TREE_NODE, -832, NULL_TREE_NODE, -606,
                       NULL_TREE_NODE, -609, NULL_TREE_NODE, -617, NULL_TREE_NODE, -650, NULL_TREE_NODE, -656,
                       NULL_TREE_NODE, -663, NULL_TREE_NODE, -488, NULL_TREE_NODE, -675, NULL_TREE_NODE, -697,
                       NULL_TREE_NODE, -703, NULL_TREE_NODE, -718, NULL_TREE_NODE, -730, NULL_TREE_NODE, -731,
                       NULL_TREE_NODE, -747, NULL_TREE_NODE, -765, NULL_TREE_NODE, -807, NULL_TREE_NODE, -819,
                       NULL_TREE_NODE, -591, NULL_TREE_NODE, -899, NULL_TREE_NODE, -907}, root);
    auto a = Solution().averageOfLevels(root);
    return 0;
}

