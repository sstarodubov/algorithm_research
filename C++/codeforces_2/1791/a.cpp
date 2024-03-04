#include<iostream>
#include <unordered_set>

using namespace std;

int t, n;
char s;
unordered_set<char> word{'c', 'o', 'd', 'e', 'f', 'o', 'r', 'c', 'e', 's'};

void resolve() {
    cin >> s;
    if (word.contains(s)) {
        cout << "yes" << endl;
    } else {
        cout << "no" << endl;
    }
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
