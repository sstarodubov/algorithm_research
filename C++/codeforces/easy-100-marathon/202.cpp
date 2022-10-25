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
    bool isHappy(int n) {
        if (n == 1) return true;

        unordered_set<int > m;

        while (n != 1) {
            if (m.find(n) == m.end()) {
                m.insert(n);
                n = get_num(n);
            } else {
                return false;
            }

        }

        return true;
    }

    int get_num(int n) {
        int ans = 0, t;
        while (n > 0) {
            t = n % 10;
            ans += t * t;
            n = n / 10;
        }
        return ans;
    }
};
int main() {
    cout << Solution().isHappy(19);
    return 0;
}

