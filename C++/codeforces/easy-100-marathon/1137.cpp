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

class Solution {

public:
    int tribonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int ppp = 0, pp = 1, p = 1, k = 0;

        int t = 3;

        while (t++ <= n) {
            k = p + pp + ppp;
            ppp = pp;
            pp = p;
            p = k;
        }


        return k;

    }
};


int main() {

    cout << Solution().tribonacci(25) << endl;
    return 0;
}

