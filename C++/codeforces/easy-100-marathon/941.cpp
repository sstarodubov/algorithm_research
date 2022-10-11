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
    bool validMountainArray(vector<int> &arr) {
        int mi = 0;
        for (int i = 1; i < arr.size(); ++i) {
            if (arr[i] > arr[mi]) {
                mi = i;
            }
        }

        if (mi == 0 || mi == arr.size() - 1) return false;

        for (int i = mi + 1; i < arr.size(); ++i) {
            if (arr[i - 1] <= arr[i]) return false;
        }

        for (int i = mi - 1; i >= 0; --i) {
            if (arr[i + 1] <= arr[i]) return false;
        }

        return true;
    }
};

int main() {
    vi v = {0, 2, 3, 4, 5, 2, 1};
    auto ans = Solution().validMountainArray(v);
    cout << ans;
    return 0;
}

