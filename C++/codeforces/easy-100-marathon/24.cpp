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
    ListNode* swapPairs(ListNode* head) {
        ListNode dummy;
        ListNode *p = &dummy, *c = head, *n = head->next;
        if (n == nullptr) return head;

        while (n != nullptr) {
            p->next = n;
            c->next = n->next;
            n->next = c;

            c = c->next;
            p = p->next->next;
            n = n->next;
            if (n == nullptr) break;
            n = n->next;
            if (n == nullptr) break;
            n = n->next;
        }

        return dummy.next;
    }
};

int main() {
    ListNode * head = new ListNode();
    buildLinkedList(vi {1,2,3,4, 5}, head);

    auto ans = Solution().swapPairs(head);
    return 0;
}

