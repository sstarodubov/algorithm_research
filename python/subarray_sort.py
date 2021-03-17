

# time O(n) Space O(1)
def sub_array_sort(arr:[int]):
    left_ptr = 0
    right_ptr = len(arr) - 1

    while arr[left_ptr] < arr[left_ptr + 1]:
        left_ptr += 1
    while arr[right_ptr] > arr[right_ptr - 1]:
        right_ptr -= 1

    left_bound = left_ptr + 1
    right_bound = right_ptr - 1
    while arr[left_bound] <= arr[left_ptr]:
        left_ptr -= 1

    while arr[right_bound] >= arr[right_ptr]:
        right_ptr += 1

    return left_ptr + 1, right_ptr - 1


sub_array_sort([1,2,4,7,10,11,7,12,6,7,16,18,19])