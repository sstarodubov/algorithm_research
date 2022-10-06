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

int guess(int n);

class Solution {
public:
    int guessNumber(int n) {
        long long l = 1, r = n, m;

        while (l <= r) {
            m = (r + l) / 2;

            if (guess(m) == 0) return m;

            if (guess(m) == 1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
};

int main() {

    return 0;
}

