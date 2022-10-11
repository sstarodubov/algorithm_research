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
/*
 *  1 1 0   0 1 1  1 0 0
 *  1 0 1   1 0 1  0 1 0
 *  0 0 0   0 0 0  1 1 1
 */
class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        for (int i = 0; i < image.size(); ++i) {
            std::reverse(image[i].begin(), image[i].end());

            for (int j = 0; j < image[i].size(); ++j) {
                if (image[i][j] == 1) image[i][j] = 0;
                else image[i][j] = 1;
            }
        }

        return image;
    }
};

int main() {

    auto ans = Solution().flipAndInvertImage();

    return 0;
}

