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
    int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int k = 1, p = 0, t;
        int count = 1;
        while (count++ <  n) {
            t = k + p;
            p = k;
            k = t;
        }

        return k;
    }
};
int main() {
    cout << Solution().fib(4);
    return 0;
}

