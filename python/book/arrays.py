from typing import List


# cpu O(n) and ram O(1)
def reorder_even_first(arr: List[int]) -> None:
    def is_even(n):
        return not n & 1

    odd_ptr = 0
    while is_even(arr[odd_ptr]) and odd_ptr < len(arr):
        odd_ptr += 1

    ptr = odd_ptr + 1

    while ptr < len(arr):
        if is_even(arr[ptr]):
            arr[ptr], arr[odd_ptr] = arr[odd_ptr], arr[ptr]
            while is_even(arr[odd_ptr]) and odd_ptr < len(arr):
                odd_ptr += 1
        ptr += 1
