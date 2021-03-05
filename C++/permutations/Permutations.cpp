#include <vector>

using namespace std;

void swap(vector<int>& arr, int i, int y) {
    int tmp = arr[i];
    arr[i] = arr[y];
    arr[y] = tmp;
}

void permutate(int idx, vector<int> &arr, vector<vector<int>>& permutations) {
    if (idx == arr.size() - 1) {
        auto new_vector = vector<int>();
        for (int element : arr) {
            new_vector.push_back(element);
        }
        permutations.push_back(new_vector);
    } else {
        for (int y = idx; y < arr.size(); y++) {
            swap(arr, y, idx);
            permutate(idx + 1, arr, permutations);
            swap(arr, idx, y);
        }
    }
}