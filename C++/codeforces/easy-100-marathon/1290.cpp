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
    int getDecimalValue(ListNode *head) {
        int ans = 0;
        int L = 0;

        ListNode *cur = head;

        while (cur != nullptr) {
            L++;
            cur = cur->next;
        }
        int mask = 1;
        cur = head;
        for (int i = L - 1; i >= 0; --i) {
            if (cur->val == 1) {
                ans |=  (mask << i);
            }
            cur = cur->next;
        }
        return ans;
    }
};

int main() {
    auto *head = new ListNode();
    buildLinkedList(vi{1, 0, 1}, head);

    cout << Solution().getDecimalValue(head);
    return 0;
}

