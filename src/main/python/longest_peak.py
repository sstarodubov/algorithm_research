array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]


def longest_peak(arr: [int]):
    longest_peak_length = 0
    i = 1
    while i < len(arr) - 1:
        is_peak = arr[i - 1] < arr[i] and arr[i] > arr[i + 1]
        if not is_peak:
            i += 1
            continue

        left_ptr = i - 2
        while left_ptr >= 0 and arr[left_ptr] < arr[left_ptr + 1]:
            left_ptr -= 1

        right_ptr = i + 2
        while right_ptr < len(arr) and arr[right_ptr] < arr[right_ptr - 1]:
            right_ptr += 1
        current_peak_length = right_ptr - left_ptr - 1
        longest_peak_length = max(longest_peak_length, current_peak_length)
        i = right_ptr
    return longest_peak_length