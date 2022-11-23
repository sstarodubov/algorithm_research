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
    int n;
    cin >> n;

    int arr[n];

    for (size_t i = 0; i < n; i++)
    {
        arr[i] = i + 1;
    }

    if ((n & 1) == 0)
    {
        int t;
        for (size_t i = 1; i < n; i += 2)
        {
            t = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = t;
        }
    }
    else
    {
        int t;
        arr[0] = 3;
        arr[2] = 1;

        for (size_t i = 2; i < n; i += 2)
        {
            t = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = t;
        }
    }

    print_arr(n, arr);
}
