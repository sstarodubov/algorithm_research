

# time O(n) Space O(1)
def subarray_sort(arr:[int]):
    min_out_of_order = float("inf")
    max_out_of_order = float("-inf")

    for i in range(len(arr)):
        num = arr[i]
        if is_out_of_order(i, num, arr):
            min_out_of_order = min(min_out_of_order, num)
            max_out_of_order = max(max_out_of_order, num)

    if min_out_of_order == float("inf"):
        return [-1, -1]

    subarray_left_idx = 0
    while min_out_of_order >= arr[subarray_left_idx]:
        subarray_left_idx+= 1
    subarray_right_idx = len(arr) - 1
    while max_out_of_order <= arr[subarray_right_idx]:
        subarray_right_idx -= 1


def is_out_of_order(i, num, arr):
    if i == 0:
        return num > arr[i+ 1]
    if i == len(arr) - 1:
        return num < arr[i - 1]

    return num > arr[i + 1] or num < arr[i - 1]