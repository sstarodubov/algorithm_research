def is_arr_filled(nums: [int]):
    for n in nums:
        if n is None:
            return False
    return True


# time O(n) Space O(n)
def has_single_cycle(nums: [int]) -> bool:
    ptr = 0
    match_arr = [None for x in nums]
    match_arr[0] = nums[0]
    while True:
        ptr += nums[ptr]
        if ptr >= len(nums):
            ptr = ptr % len(nums)
        elif ptr < 0:
            ptr = abs(ptr % len(nums))

        if match_arr[ptr] is not None and ptr != 0:
            return False

        if ptr == 0:
            return is_arr_filled(nums)

        if match_arr[ptr] is None:
            match_arr[ptr] = nums[ptr]


def is_arr_filled2(nums: [int]):
    for n in nums:
        if n is not None:
            return False
    return True


# time O(n) Space O(1)
def has_single_cycle_with_less_used_memory(nums: [int]) -> bool:
    ptr = 0
    ptr += nums[ptr]
    while True:
        if ptr >= len(nums):
            ptr = ptr % len(nums)
        elif ptr < 0:
            ptr = abs(ptr % len(nums))

        if nums[ptr] is None:
            return False

        if ptr == 0:
            nums[ptr] = None
            return is_arr_filled2(nums)

        if nums[ptr] is not None:
            tmp = ptr
            ptr += nums[ptr]
            nums[tmp] = None
