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
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {
        ListNode dummy;
        ListNode *cur = &dummy;

        while (list1 != nullptr && list2 != nullptr) {
            if (list1->val < list2->val) {
                cur->next = list1;
                list1 = list1->next;
            } else {
                cur->next = list2;
                list2 = list2->next;
            }
            cur = cur->next;
        }
        while (list1 != nullptr) {
            cur->next = list1;
            list1 = list1->next;
            cur = cur->next;
        }

        while (list2 != nullptr) {
            cur->next = list2;
            list2 = list2->next;
            cur = cur->next;
        }
        auto ans = dummy.next;
        dummy.next = nullptr;
        return ans;
    }
};

int main() {
    ListNode *l1 = new ListNode();
    ListNode *l2 = new ListNode();

    buildLinkedList(vi{-9, 3}, l1);
    buildLinkedList(vi{5, 7}, l2);

    auto a = Solution().mergeTwoLists(l1, l2);

    return 0;
}

