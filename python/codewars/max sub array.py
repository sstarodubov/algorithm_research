def max_sequence(arr):
    if not arr:
        return 0
    ans = arr[0]
    for i in range(1, len(arr)):
        arr[i] = max(arr[i], arr[i] + arr[i - 1])
        ans = max(arr[i], ans)
    return ans


assert max_sequence([-1, -2, 2]) == 2
assert max_sequence([-2, 1, -3, 4, -1, 2, 1, -5, 4]) == 6
print("tests passed")
