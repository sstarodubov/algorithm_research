#pragma once


#include <iostream>
#include <map>
#include <string>
#include <stack>
#include <vector>
#include <set>
#include <unordered_set>

#define NULL_TREE_NODE -9

using namespace std;

class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}

    ~TreeNode() {
        delete left;
        delete right;
    }
};

void buildBinaryTree(vector<int>& nums, TreeNode* root) {
    if (nums.empty()) {
        cerr << "empty err" << endl;
        return;
    }
    int p = 0;
    root->val = nums[0];
    deque<TreeNode*> queue;
    queue.push_back(root);
    TreeNode* cur;

    while (!queue.empty()) {
        cur = queue.front();
        queue.pop_front();
        if (cur == nullptr) {
            cerr << "err" << endl;
            return;
        }
        if (cur->left == nullptr) {
            p++;
            if (p >= nums.size()) return;
            if (nums[p] != NULL_TREE_NODE) {
                auto node = new TreeNode(nums[p]);
                cur->left = node;
                queue.push_back(node);
            }
        }

        if (cur->right == nullptr) {
            p++;
            if (p >= nums.size()) return;
            if (nums[p] != NULL_TREE_NODE) {
                auto node = new TreeNode(nums[p]);
                cur->right = node;
                queue.push_back(node);
            }
        }
    }
}


class ListNode {
public:
    int val;
    ListNode* next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode* next) : val(x), next(next) {}

    ~ListNode() {
        delete next;
    }
};

void buildLinkedList(std::vector<int>& values, ListNode* head) {
    if (values.empty()) return;
    head->val = values[0];
    ListNode* cur = head;
    int i = 1;
    while (i < values.size()) {
        auto nn = new ListNode(values[i]);
        cur->next = nn;
        cur = nn;
        i++;
    }
}


void buildLinkedList(std::vector<int>&& values, ListNode* head) {
    if (values.empty()) return;
    head->val = values[0];
    ListNode* cur = head;
    int i = 1;
    while (i < values.size()) {
        auto nn = new ListNode(values[i]);
        cur->next = nn;
        cur = nn;
        i++;
    }

    values.clear();
}

void read_arr_long(int n, long long* a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void read_arr(int n, int* a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void print_arr(int n, int* arr) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";

        if (i == n - 1) {
            cout << endl;
        }
    }
}
