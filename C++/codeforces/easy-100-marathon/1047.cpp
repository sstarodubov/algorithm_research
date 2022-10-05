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
    string removeDuplicates(string s) {
        deque<char> dq;

        for (auto &ch: s) {
            if (dq.empty()) {
                dq.push_back(ch);
            } else {
                if (dq.back() == ch) {
                    dq.pop_back();
                } else {
                    dq.push_back(ch);
                }
            }
        }

        s = "";

        while (!dq.empty()) {
            s += dq.front();
            dq.pop_front();
        }


        return s;
    }
};

int main() {
    string s = "azxxzy";
    cout << Solution().removeDuplicates(s);
    return 0;
}

