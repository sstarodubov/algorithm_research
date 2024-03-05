#include<iostream>
#include <unordered_map>
#include <unordered_set>

using namespace std;

int t;

void dec(unordered_map<char, int>&m, char k) {
    m[k]--;
    if (m[k] <= 0) {
        m.erase(k);
    }
}

void resolve() {
    int n;
    string s;
    cin >> n;
    cin >> s;

    unordered_map<char, int> lm;
    unordered_map<char, int> rm;

    lm[s[0]] = 1;
    int ret = 0;
    for (int i = 1; i < n; ++i) {
        rm[s[i]]++;
    }

    int p = 1;

    while (p < n) {
        ret = max(ret, static_cast<int>(lm.size() + rm.size()));
        lm[s[p]]++;
        dec(rm, s[p]);
        p++;
    }

    cout << ret << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
