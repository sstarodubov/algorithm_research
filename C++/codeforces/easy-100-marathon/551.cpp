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
    bool checkRecord(string s) {
        bool late = s.find("LLL") != string::npos;
        int k = 0;

        for (char& i : s) {
            if (i == 'A') k++;
        }

        if (late) return false;

        if (k >= 2) return false;

        return true;
    }
};


int main() {
    auto ans = Solution().checkRecord("AA");
    cout << ans << endl;
    return 0;
}

