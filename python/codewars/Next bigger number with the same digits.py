from collections import deque
from typing import List


def nextPermutation(nums: List[int]) -> None:
    def reverse(nums: List[int], start: int) -> None:
        end = len(nums) - 1
        while start < end:
            nums[end], nums[start] = nums[start], nums[end]
            end -= 1
            start += 1

    if len(nums) <= 1: return nums
    ptr = len(nums) - 2
    while ptr >= 0 and nums[ptr] >= nums[ptr + 1]:
        ptr -= 1

    start = ptr
    ptr += 1
    while 0 < ptr < len(nums) and nums[start] < nums[ptr]:
        ptr += 1

    ptr -= 1
    nums[start], nums[ptr] = nums[ptr], nums[start]

    reverse(nums, start + 1)


def next_bigger(n):
    cur_perm = deque([])
    while n:
        last = n % 10
        cur_perm.appendleft(last)
        n = n // 10
    cur_perm = list(cur_perm)

    nextPermutation(cur_perm)

    p = 10 ** (len(cur_perm) - 1)
    ans = 0
    for num in cur_perm:
        ans += p * num
        p = p // 10

    return ans


assert next_bigger(1234567980) == 1234567908
# assert next_bigger(12) == 21
# assert next_bigger(513) == 531
# assert next_bigger(2017) == 2071
# assert next_bigger(414) == 441
# assert next_bigger(144) == 414
