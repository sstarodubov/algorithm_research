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
    bool canPlaceFlowers(vector<int> &flowerbed, int n) {
        for (int i = 0; i < flowerbed.size(); ++i) {
            if (n == 0) return true;
            if (i == 0) {
                if (flowerbed.size() < 2) {
                    if (flowerbed[i] == 0) n--;
                } else {
                    if (flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
            } else if (i == flowerbed.size() - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    n--;
                    flowerbed[i] = 0;
                }
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n == 0;
    }
};

int main() {
    vi v = {0, 0, 0, 0, 1};
    cout << Solution().canPlaceFlowers(v, 2);
    return 0;
}

