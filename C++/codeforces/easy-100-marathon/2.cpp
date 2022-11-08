#include <iostream>
#include <vector>
#include <algorithm>
#include "helper.h"

using namespace std;

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode d(-1);
        ListNode* cur = &d;
        bool cf = false;
        int t;
        while (l1!= nullptr & l2 != nullptr) {
            t = l1->val + l2->val;
            if (cf) {
                t++;
                cf = false;
            }
            if (t >= 10) {
                t = t % 10;
                cf = true;
            }
            cur->next = new ListNode(t);
            cur = cur->next;
            l1 = l1->next;
            l2 = l2->next;
        }

        while (l1 != nullptr) {
            t = l1->val;
            if (cf) {
                t++;
                cf = false;
                if (t == 10) {
                    t = 0;
                    cf = true;
                }
            }
            cur->next = new ListNode(t);
            cur = cur->next;
            l1 = l1->next;
        }

        while (l2 != nullptr) {
            t = l2->val;
            if (cf) {
                t++;
                cf = false;
                if (t == 10) {
                    t = 0;
                    cf = true;
                }
            }
            cur->next = new ListNode(t);
            cur = cur->next;
            l2 = l2->next;
        }

        if (cf) {
            cur->next = new ListNode(1);
        }
        return d.next;
    }
};
typedef vector<int> vi;
int main() {
    ListNode* l1 = new ListNode();
    ListNode* l2 = new ListNode();
    buildLinkedList(vi {0, 1}, l1);
    buildLinkedList(vi {9, 9, 9, 9}, l2);

    cout << Solution().addTwoNumbers(l1, l2);

    return 0;
}


