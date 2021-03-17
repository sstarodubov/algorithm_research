def make_pivot(arr: [int], left_bound, right_bound):
    pivot = arr[left_bound]
    left_ptr = left_bound + 1
    right_ptr = right_bound

    while left_ptr <= right_ptr:
        if arr[left_ptr] > pivot > arr[right_ptr]:
            arr[left_ptr], arr[right_ptr] = arr[right_ptr], arr[left_ptr]
            right_ptr -= 1
            left_ptr += 1
            continue

        if arr[left_ptr] <= pivot:
            left_ptr += 1

        if arr[right_ptr] > pivot:
            right_ptr -= 1

    arr[left_bound], arr[right_ptr] = arr[right_ptr], arr[left_bound]
    return right_ptr

# time: worst = O(n ^ 2), best = O(n * lg n), avg = O(n * lg n)
# space: O(lg n)
def quick_sort(arr:[int], left_bound, right_bound):
    if left_bound > right_bound:
        return arr

    pivot_idx = make_pivot(arr, left_bound, right_bound)
    quick_sort(arr, left_bound, pivot_idx - 1)
    quick_sort(arr, pivot_idx + 1, right_bound)
    return arr
