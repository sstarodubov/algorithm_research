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
    bool isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int k = 0;
        int b;
        for (int i = 0; i < 32; ++i) {
            b = n & 1;
            n = n >> 1;
            if (b == 1) k++;
            if (k == 2) return false;
        }

        return true;
    }
};

int main() {
    cout << Solution().isPowerOfTwo(0);
    return 0;
}

