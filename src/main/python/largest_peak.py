array = [1, 2, 3, 3, 4, 0, 10, 6, 5, - 1, -3, -2, 3]


# Time O(n) Space O(1)
def find_largest_peak(arr: [int]):
    largest = -1000000000000
    lrgst_inx = 0
    for i in range(len(arr)):
        if arr[i] > largest:
            lrgst_inx = i
            largest = arr[i]

    left_ptr = lrgst_inx - 1
    right_ptr = lrgst_inx + 1

    while left_ptr > 1 and arr[left_ptr - 1] <= arr[left_ptr]:
        left_ptr -= 1
    while right_ptr < len(arr) - 1 and arr[right_ptr + 1] <= arr[right_ptr]:
        right_ptr += 1
    return (right_ptr - left_ptr) + 1


print(find_largest_peak(array))
