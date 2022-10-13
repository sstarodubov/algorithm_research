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

    string addBinary(string a, string b) {
        string &gr = a.length() >= b.length() ? a : b;
        string &ls = gr == a ? b : a;
        while (ls.length() != gr.size()) {
            ls.insert(0, "0");
        }

        int k = 0;
        int s;

        for (int i = a.length() - 1; i >= 0; --i) {
            s = a[i] + b[i];
            if (s == 98 && k == 1) continue;
            else if (s == 98 && k == 0) {
                a[i] = '0';
                k = 1;
            } else if (s == 96 && k == 0) continue;
            else if (s == 96 && k == 1) {
                a[i] = '1';
                k = 0;
            } else if (s == 97 && k == 0) {
                a[i] = '1';
            } else if (s == 97 && k == 1) {
                a[i] = '0';
                k = 1;
            }
        }
        if (k == 1) a.insert(0, "1");
        return a;
    }
};

int main() {
    cout << Solution().addBinary("11", "1");
    return 0;
}

