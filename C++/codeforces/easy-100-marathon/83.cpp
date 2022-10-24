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
    ListNode *deleteDuplicates(ListNode *head) {
        if (head == nullptr) return nullptr;

        ListNode *cur = head->next;
        ListNode *tail = head;

        while (cur != nullptr) {
            if (cur->val == tail->val) {
                cur = cur->next;
            } else {
                tail->next = cur;
                tail = tail->next;
            }
        }
        tail->next = nullptr;
        return head;
    }
};

int main() {
    auto *head = new ListNode();
    buildLinkedList(vi{1, 1, 2, 3, 3}, head);
    auto *ans = Solution().deleteDuplicates(head);
    return 0;
}

