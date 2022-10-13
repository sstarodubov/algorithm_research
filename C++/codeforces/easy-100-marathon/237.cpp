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
    void deleteNode(ListNode *node) {
        if (node == nullptr) return;
        ListNode *prev = node;

        while (node->next != nullptr) {
            node = node->next;
            prev->val = node->val;
            if (node->next == nullptr) {
                prev->next = nullptr;
                return;
            } else {
                prev = node;
            }
        }
    }
};

int main() {
    auto *head = new ListNode(1);
    auto *n = new ListNode();
    head->next = n;
    buildLinkedList(vector<int>{2}, n);

    Solution().deleteNode(n);

    delete head;
    return 0;
}

