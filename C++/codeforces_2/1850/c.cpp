#include <algorithm>
#include<iostream>

using namespace std;

int t, n;
char grid[8][8];

void resolve() {
    string ret;
    for (int row = 0; row < 8; ++row) {
        for (int col = 0; col < 8; ++col) {
            cin >> grid[row][col];
        }
    }

    for (int row = 0; row < 8; ++row) {
        for (int col = 0; col < 8; ++col) {
            if (grid[row][col] != '.') {
                while (row < 8 && grid[row][col] != '.') {
                    ret += grid[row][col];
                    row++;
                }

                cout << ret << endl;
                return;
            }
        }
    }
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
