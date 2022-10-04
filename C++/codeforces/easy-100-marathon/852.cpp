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
    int peakIndexInMountainArray(vector<int> &arr) {
        int l = 0, r = arr.size() - 1, m;

        while (l <= r) {
            m = (l + r) / 2;

            if (m - 1 >= 0 && m + 1 < arr.size() && arr[m - 1] < arr[m] && arr[m] > arr[m + 1]) {
                return m;
            } else if (m+1 < arr.size() && arr[m] > arr[m + 1]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
};


int main() {
    vi v = {0 ,1, 2, 0};
    cout << Solution().peakIndexInMountainArray(v) << endl;
    return 0;
}

