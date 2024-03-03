#include<iostream>
#include <vector>

using namespace std;

int t, n, q;

void build_arr_sum(vector<int>&v, vector<int>&res) {
    res[0] = 0;

    for (int i = 0; i < v.size(); ++i) {
        res[i + 1] = res[i] + v[i];
    }
}

int req_sum(vector<int>&sum_arr, int l, int r) {
    int s =  sum_arr[r] - sum_arr[l - 1];

    return sum_arr[n] - s;
}

void resolve() {
    cin >> n;
    cin >> q;
    auto vec = vector<int>(n);
    for (int i = 0; i < n; ++i) {
        cin >> vec[i];
    }

    auto sum_arr = vector<int>(n + 1);
    build_arr_sum(vec, sum_arr);

    int l, r, k;
    for (int i = 0; i < q; ++i) {
        cin >> l;
        cin >> r;
        cin >> k;
        int ext_sum = req_sum(sum_arr, l, r);
        int res = ext_sum + (k * (r - l + 1));

        if ((res & 1) == 0) {
            cout << "no" << endl;
        }
        else {
            cout << "yes" << endl;
        }
    }
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
