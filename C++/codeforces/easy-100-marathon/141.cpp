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
    bool hasCycle(ListNode *node) {
        if (node == nullptr) return false;
        if (node->next == nullptr) return false;

        ListNode *sl = node, *fs = node;
        while (fs != nullptr && fs->next != nullptr && fs->next->next != nullptr) {
            sl = sl->next;
            fs = fs->next->next;
            if (sl == fs) return true;
        }

        return false;
    }
};

int main() {
    auto *head = new ListNode(1, new ListNode(2, nullptr));

    cout << Solution().hasCycle(head);

    delete head;
    return 0;
}

