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

move_element_to_end([1, 3,4], 3)
