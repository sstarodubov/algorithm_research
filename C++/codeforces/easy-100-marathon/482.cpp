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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        deque<char> dq;
        int t = 0;
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] == '-') continue;
            if (t == k) {
                t = 0;
                dq.emplace_front('-');
            }

            t++;
            if (isalpha(s[i]))
                dq.emplace_front(toupper(s[i]));
            else dq.emplace_front(s[i]);

        }
        s.clear();
        for (auto &ch: dq) {
            s += ch;
        }

        return s;
    }
};

int main() {
    cout << Solution().licenseKeyFormatting("2-5g-3-J", 2);
    return 0;
}

