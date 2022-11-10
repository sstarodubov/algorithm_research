#pragma clang diagnostic push
#pragma ide diagnostic ignored "readability-convert-member-functions-to-static"

#include <iostream>
#include <vector>
#include <algorithm>
#include "helper.h"

using namespace std;
typedef vector<int> vi;
typedef vector<vector<int>> vvi;

class Solution {
public:
    void setZeroes(vector<vector<int>> &matrix) {

        for (int r = 0; r < matrix.size(); ++r) {
            for (int c = 0; c < matrix[0].size(); ++c) {
                if (matrix[r][c] == 0) {
                    for (int i = 0; i < matrix[0].size(); ++i) {
                        if (matrix[r][i] != 0) {
                            matrix[r][i] = INT32_MAX;
                        }
                    }

                    for (int i = 0; i < matrix.size(); ++i) {
                        if (matrix[i][c] != 0) {
                            matrix[i][c] = INT32_MAX;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[0].size(); ++j) {
                if (matrix[i][j] == INT32_MAX) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
};

int main() {
    vvi v = {{1, 1, 2, 0},
             {1, 1, 5, 2},
             {1, 0, 1, 5}};
    Solution().setZeroes(v);

    return 0;
}