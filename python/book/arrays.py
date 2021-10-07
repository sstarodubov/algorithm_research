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


"""
Write a program that takes an array A and an index i into A, and rearranges the elements such
that all elements less than A[i] (the "pivot") appear first, followed by elements equal to the pivot,
followed by elements greater than the pivot.
"""


# ram O(1) , cpu O(n)
def dutch_national_flag_problem(arr: List[int], pivotidx: int) -> None:
    lptr = 0
    rptr = len(arr) - 1
    pivot = arr[pivotidx]
    while lptr < rptr:
        if arr[rptr] > pivot and arr[lptr] >= pivot:
            rptr -= 1
        elif arr[lptr] >= pivot and arr[rptr] < pivot:
            arr[lptr], arr[rptr] = arr[rptr], arr[lptr]
            lptr += 1
        elif arr[lptr] > pivot:
            arr[lptr], arr[rptr] = arr[rptr], arr[lptr]
            rptr -= 1
        elif arr[rptr] > pivot:
            rptr -= 1
        elif arr[rptr] < pivot:
            arr[rptr], arr[lptr] = arr[lptr], arr[rptr]
            lptr += 1
        elif arr[lptr] < pivot:
            lptr += 1
