#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

bool contains(unordered_set<int> &set, int &val)
{
    return set.find(val) != set.end();
}

typedef vector<int> vi;
typedef vector<vector<int>> vvi;
typedef long long ll;

void print_arr(int n, int *arr)
{
    for (int i = 0; i < n; ++i)
    {
        cout << arr[i] << " ";

        if (i == n - 1)
        {
            cout << endl;
        }
    }
}

void read_arr(int n, int *a)
{
    for (int i = 0; i < n; ++i)
    {
        cin >> a[i];
    }
}

void solve();

int main()
{
    int t;

    cin >> t;

    for (size_t i = 0; i < t; i++)
    {
        solve();
    }

    return 0;
}

void solve()
{
    int arr[3];

    read_arr(3, arr);

    sort(begin(arr), end(arr));

    bool f = arr[2] - arr[0] == arr[1];
    bool s = arr[0] == arr[1] && (arr[2] & 1) == 0;
    bool d = arr[1] == arr[2] && (arr[0] & 1) == 0;

    if (s || f || d)
    {
        cout << "YES" << endl;
    }
    else
    {
        cout << "NO" << endl;
    }
}
