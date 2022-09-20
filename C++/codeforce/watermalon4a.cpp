#include <iostream>
using namespace std;


int main() {
    int t;
    cin >> t;

    while ((t--)!= 0) {
        int n;
        cin >> n;

          for (int i = 31; i >=0 ; i--) {
            if ((n & (1 << i))) {
                cout << (1 << i) - 1;
                cout << '\n';
                break;
            }
        }
    }
    
    return 0;
}