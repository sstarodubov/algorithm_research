#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>
#include <unordered_set>

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
    int numUniqueEmails(vector<string> &emails) {
        unordered_set<string> set;

        for (const auto &s: emails) {
            set.insert(extract(s));
        }

        return set.size();
    }

    string extract(string email) {
        string result;
        int i = 0;
        bool before = true;
        while (i < email.size()) {
            if (before && email[i] == '.') {
                i++;
                continue;
            }
            if (before && email[i] == '+') {
                i++;
                while (email[i] != '@') i++;
                result += '@';
                i++;
                before = false;
                continue;
            }

            if (email[i] == '@') before = false;

            result += email[i];
            i++;
        }

        return result;
    }
};

int main() {
    vector<string> v = {"linqmafia@leet+code.com", "linqmafia@code.com"};
    auto r = Solution().numUniqueEmails(v);
    cout << r << endl;
    return 0;
}

