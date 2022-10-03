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

struct abs_key {
    inline bool operator()(const int &a, const int &b) {
        return abs(a) > abs(b);
    }
};

class Solution {

public:
    bool checkIfExist(vector<int> &arr) {
        unordered_set<int> uns;
        sort(arr.begin(), arr.end(), abs_key());
        for (auto &a: arr) {
            if (uns.find(a * 2) != uns.end()) {
                return true;
            } else {
                uns.insert(a);
            }
        }

        return false;
    }
};


int main() {
    vector<int> v = {-10, 12, -20, -8, 15};
    cout << Solution().checkIfExist(v) << endl;
    return 0;
}

