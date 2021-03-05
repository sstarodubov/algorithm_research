# Time O(lg n)
def binary_search(arr: [int], target: int):
    left_ptr = 0
    right_ptr = len(arr) - 1
    while left_ptr <= right_ptr:
        middle_idx = (right_ptr + left_ptr) // 2
        if arr[middle_idx] == target: return middle_idx
        if arr[middle_idx] < target:
            left_ptr = middle_idx + 1
        else:
            right_ptr = middle_idx - 1

    return None


res = binary_search([0, 1, 21, 33, 45, 46, 61, 71, 72, 73], 21313)
print(res)
