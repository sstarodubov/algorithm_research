#include<iostream>
using namespace std;


int main() {
    int d =0 , sum = 0, i = 0, a[50], b[50], k = 0, x = 0;
    cin >> d >> sum;
    for (i = 0; i < d; i++) {
        cin >> a[i] >> b[i];
        k += a[i];
        x += b[i];
    }
    if (sum < k || sum > x) {
        cout << "NO";
        return 0;
    }
    cout << "YES" << endl;
    for (i = 0; i < d; i++) {
        cout << min(b[i], sum - k + a[i]) << " ";
        sum -= min(b[i], sum - k + a[i]);
        k -= a[i];
    }
}
