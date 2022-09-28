#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

void buildLinkedList(vector<int> &values, ListNode *head) {
    if (values.empty()) return;
    head->val = values[0];
    ListNode *cur = head;
    int i = 1;
    while (i < values.size()) {
        auto nn = new ListNode(values[i]);
        cur->next = nn;
        cur = nn;
        i++;
    }
}

void read_arr_long(int n, long long *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void print_arr(int n, int *arr) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";

        if (i == n - 1) {
            cout << endl;
        }
    }
}


class Solution {
public:
    ListNode *removeElements(ListNode *head, int val) {
        auto dummy = ListNode(-1);
        dummy.next = head;

        ListNode *prev = &dummy;
        ListNode *cur = head;

        while (cur != nullptr) {
            if (cur->val == val) {
                prev->next = cur->next;
                cur = cur->next;
            } else {
                cur = cur->next;
                if (prev == nullptr) break;
                prev = prev->next;
            }
        }

        return dummy.next;
    }
};

int main() {
    auto head = ListNode(0);
    vector<int> v = {1, 2, 6, 3, 4, 5, 6};
    buildLinkedList(v, &head);

    Solution().removeElements(&head, 6);
    return 0;
}

