#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>

using namespace std;

void read_arr_long(int n, long long *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void print_arr(int n, int *arr) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";

        if (i == n - 1) {
            cout << endl;
        }
    }
}

class Solution {
public:
    bool containsDuplicate(vector<int> &nums) {
        set<int> set;
        for (int &num: nums) {
            if (set.find(num) == set.end()) {
                set.insert(num);
            } else return true;
        }

        return false;
    }
};

int main() {
    vector<int> v = {1, 2, 3, 4, 4};
    cout << Solution().containsDuplicate(v);
    return 0;
}
