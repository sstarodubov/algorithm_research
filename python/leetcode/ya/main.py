from typing import List

def smallest_diff(arr1, arr2):
    arr1.sort()
    arr2.sort()
    cur = float("inf")
    ret = [0, 0]

    i1, i2 = 0, 0

    while i1 < len(arr1) and i2 < len(arr2):
        diff = abs(arr1[i1] - arr2[i2])
        if diff < cur:
            cur = diff
            ret[0] = arr1[i1]
            ret[1] = arr2[i2]
        if arr1[i1] < arr2[i2]:
            i1 += 1
        else:
            i2 += 2

    return ret

def move_element_to_end(arr, elem):
    l ,r = 0, len(arr) - 1

    while l < r:
        while arr[l] != elem and l < r:
            l += 1
        while arr[r] == elem and l < r:
            r -= 1
        if l >= r:
            break
        arr[l], arr[r] = arr[r], arr[l]
    print(arr)


def monotonic_array(arr):
    if len(arr) < 2:
        return True
    def check(dir, arr):
        i1, i2 = 0, 1
        match dir:
            case "inc":
                while i2 < len(arr):
                    if arr[i1] <= arr[i2]:
                        i1 += 1
                        i2 += 1
                    else:
                        return False
            case "dic" :
                while i2 < len(arr):
                    if arr[i1] >= arr[i2]:
                        i1 += 1
                        i2 += 1
                    else:
                        return False
        return True

    dir = "inc" if arr[0] < arr[-1] else "dic"
    return check(dir, arr)

def is_peak(i, arr):
    if i == 0 and len(arr) >= 2:
        return arr[0] > arr[1]
    if i == len(arr) - 1:
        return arr[len(arr) - 1] > arr[len(arr) - 2]
    return arr[i - 1] < arr[i] > arr[i + 1]

def peak_len(i, arr):
    l = i - 1
    while l >= 0 and arr[l] < arr[l + 1]:
        l -= 1
    r = i + 1
    while r < len(arr) and arr[r - 1] > arr[r]:
        r += 1

    return r - l - 1

def longest_peak(arr):
    if not arr:
        return -1
    if len(arr) == 1:
        return 0
    cur = float('-inf')
    for i in range(1, len(arr) - 1):
       if is_peak(i, arr):
           cur = max(cur, peak_len(i, arr))
    return cur

def array_of_products(arr):
    n = len(arr)
    if n <= 2 :
        return arr
    lp, rp = [0] * n, [0] * n

    lp[0] = arr[0]
    for i in range(1, n):
        lp[i] = arr[i] * lp[i - 1]

    rp[-1] = arr[-1]
    for i in range(n - 2, -1, -1):
       rp[i] = rp[i + 1] * arr[i]

    ret = [0] * n

    ret[0] = rp[1]
    ret[-1] = lp[-2]
    for i in range(1, n -1):
        ret[i] = lp[i - 1] * rp[i + 1]

    return ret

print(array_of_products([5, 1, 4, 2]))









