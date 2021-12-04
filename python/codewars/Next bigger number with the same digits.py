def next_bigger(n):
    if n < 10:
        return -1
    if n < 100:
        reverse = (n % 10) * 10 + n // 10
        if reverse > n:
            return reverse
        return -1

    arr = to_arr(n)
    perms = []
    backtrack(arr, 0, perms)

    for i in range(len(perms)):
        perms[i] = to_num(perms[i])
    perms.sort(reverse=True)

    if n == perms[0]:
        return -1

    for i in range(1, len(perms)):
        if perms[i] == n:
            return perms[i - 1]
    return -1


def backtrack(arr, idx, ans):
    if idx >= len(arr):
        ans.append(arr[:])
    else:
        for i in range(idx, len(arr)):
            arr[i], arr[idx] = arr[idx], arr[i]
            backtrack(arr, idx + 1, ans)


def to_num(arr):
    ans = 0
    for num in arr:
        ans = 10 * ans + num
    return ans


def to_arr(num):
    ans = []
    while num != 0:
        rest = num % 10
        ans.append(rest)
        num //= 10
    return list(reversed(ans))


assert next_bigger(513) == 531
# assert next_bigger(12) == 21
# assert next_bigger(2017) == 2071

print("tests passed")
