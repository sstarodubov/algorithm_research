from typing import List, Optional

from tree_node import TreeNode


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
    l, r = 0, len(arr) - 1

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
            case "dic":
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
    if n <= 2:
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
    for i in range(1, n - 1):
        ret[i] = lp[i - 1] * rp[i + 1]

    return ret


def merge(intervals: List[List[int]]) -> List[List[int]]:
    if not intervals:
        return []
    intervals.sort(key=lambda x: x[0])
    arr = []
    cur = intervals[0]
    for i in range(1, len(intervals)):
        p = intervals[i]
        if p[0] > cur[1]:
            arr.append(cur)
            cur = p
        else:
            cur = [cur[0], max(cur[1], p[1])]
    arr.append(cur)
    return arr


def space(i, arr):
    l, r = i - 1, i + 1
    d = 0
    while l >= 0 and r < len(arr):
        if arr[l] == 0 and arr[r] == 0:
            d += 2
            l -= 1
            r += 1
        elif arr[l] == 1 and arr[r] == 0:
            d += 1
            return d
        elif arr[l] == 0 and arr[r] == 1:
            d += 1
            return d
        else:
            return d
    return d


def best_seat(arr):
    d = -1
    idx = -1
    for i in range(1, len(arr) - 2):
        if arr[i] == 0:
            cur = space(i, arr)
            if cur > d:
                d = cur
                idx = i

    return idx


def zero_sum_subarray(arr):
    s = {0}
    s_arr = [0] * len(arr)
    s_arr[0] = arr[0]
    for i in range(1, len(arr)):
        s_arr[i] = s_arr[i - 1] + arr[i]
    for n in s_arr:
        if n in s:
            return True
        s.add(n)

    return False


def missing_numbers(arr):
    ret = []
    n = len(arr) + 2
    sarr = set(arr)
    for i in range(1, n + 1):
        if i not in sarr:
            ret.append(i)
    return ret


def majority_elements(arr):
    m = {}
    t = len(arr) / 2
    for n in arr:
        if n in m:
            m[n] += 1
        else:
            m[n] = 1
        if m[n] > t:
            return n
    return -1


def sweat_and_savor(arr, target):
    ret = [float("inf"), float("inf")]
    for n in arr:
        if n > 0:
            if abs(n - target) < abs(ret[1] - target):
                ret[1] = n
        else:
            if abs(n - target) < abs(ret[0] - target):
                ret[0] = n
    return ret


def validate_bst(node: TreeNode):
    def _validate(node, minimum, maximum):
        if not node:
            return True
        if node.val >= maximum:
            return False
        if node.val < minimum:
            return False
        return _validate(node.left, minimum, node.val) and _validate(node.right, node.val, maximum)

    return _validate(node.left, float("-inf"), node.val) and _validate(node.right, node.val, float("inf"))


def create_bst(arr) -> Optional[TreeNode]:
    if not arr:
        return None
    else:
        mid = len(arr) // 2
        t = TreeNode(arr[mid])
        t.left = create_bst(arr[:mid])
        t.right = create_bst(arr[mid + 1:])
        return t

node = create_bst([1, 2, 5, 7, 10, 13, 14, 15, 22])
if node: node.print()
