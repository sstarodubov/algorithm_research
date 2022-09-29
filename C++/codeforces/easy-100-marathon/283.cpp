#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>
#include <unordered_set>
#include <cstring>

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
    void moveZeroes(vector<int> &nums) {
        int zeros = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == 0) zeros++;
        }

        int w = 0, r = 0;
        while (true) {
            while (r < nums.size() && nums[r] == 0 ) r++;
            if (r >= nums.size()) break;
            nums[w] = nums[r];
            w++;
            r++;
        }

        for (int i = nums.size(); i-- > 0;) {
            if (zeros == 0) {
                return;
            }
            nums[i] = 0;
            zeros--;
        }
    }
};

int main() {
    vector<int> v = {0, 1, 0, 3, 12};
    Solution().moveZeroes(v);
    return 0;
}

