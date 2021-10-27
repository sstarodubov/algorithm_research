from typing import List


def bucket_sort(arr: List[int]) -> List[int]:
    tmp_arr = []
    for _ in arr:
        tmp_arr.append([])
    for n in arr:
        tmp_arr[n].append(n)

    arr.clear()
    for ar in tmp_arr:
        for a in ar:
            arr.append(a)
    return arr


def counting_sort(arr):
    tmp_arr = [0] * 30
    ans = [0] * len(arr)
    for el in arr:
        tmp_arr[el] += 1

    for i in range(1, len(tmp_arr)):
        prev = tmp_arr[i - 1]
        tmp_arr[i] += prev

    for el in arr:
        idx = tmp_arr[el]
        ans[idx] = el
        tmp_arr[el] -= 1

    return ans
