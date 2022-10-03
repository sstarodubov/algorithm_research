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
#include "helper.h"

using namespace std;

class Solution {

public:
    ListNode *middleNode(ListNode *head) {
        ListNode *sl = head, *fs = head;

        while (fs != nullptr) {
            if (fs->next == nullptr) break;
            sl = sl->next;
            fs = fs->next->next;
        }

        return sl;
    }
};


int main() {
    ListNode head;
    buildLinkedList(move(vector<int>{1, 2, 3, 4, 5}), &head);
    cout << Solution().middleNode(&head)->val << endl;
    return 0;
}

