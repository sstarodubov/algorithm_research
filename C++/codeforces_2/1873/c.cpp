#include<iostream>

#include <cstdint>
#include <unordered_map>

using namespace std;

// 1873
int t;
int target[10][10] = {
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
    {1, 2, 3, 3, 3, 3, 3, 3, 2, 1},
    {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
    {1, 2, 3, 4, 5, 5, 4, 3, 2, 1},
    {1, 2, 3, 4, 5, 5, 4, 3, 2, 1},
    {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
    {1, 2, 3, 3, 3, 3, 3, 3, 2, 1},
    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
};

void resolve() {
    int ret = 0;
    char k;
    for (int row = 0; row < 10; ++row) {
        for (int col = 0; col < 10; ++col) {
            cin >> k;
            if (k == 'X') {
                ret += target[row][col];
            }
        }
    }

    cout << ret << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
