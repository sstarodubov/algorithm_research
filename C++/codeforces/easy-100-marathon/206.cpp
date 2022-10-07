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
#include "helper.h"

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    ListNode *reverseList(ListNode *k) {
        if (k == nullptr) return k;
        ListNode dummy = ListNode(-1, nullptr);
        ListNode *n, *t;
        while (k != nullptr) {
            n = dummy.next;
            t = k->next;
            k->next = n;
            dummy.next = k;
            k = t;
        }
        auto *ans = dummy.next;
        dummy.next = nullptr;
        return ans;
    }
};

int main() {
    auto *head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, nullptr))));
    auto node = Solution().reverseList(head);
    cout << node->val;
    delete head;
    return 0;
}

