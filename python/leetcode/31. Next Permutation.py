from typing import List


class Solution:
    # time O(N) , space O(1)
    def nextPermutation(self, nums: List[int]) -> None:
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


nums = [3, 2, 1]
Solution().nextPermutation(nums)
assert nums == [1, 2, 3]

numbers = [1, 5, 1]
Solution().nextPermutation(numbers)
assert numbers == [5, 1, 1]

nums = [5, 4, 7, 5, 3, 2]
Solution().nextPermutation(nums)
assert nums == [5, 5, 2, 3, 4, 7]

nums = [1, 20, 26, 1, 15, 29, 4, 29, 10, 9, 21, 7, 27, 11, 21, 5, 9, 7, 27, 16, 17, 3, 6, 5, 16, 23, 29, 14, 28, 21, 2,
        29, 3, 29, 0, 18, 28, 5, 10, 9, 6, 23, 8, 25, 26, 21, 1, 5, 29, 28, 14, 8, 1, 20, 13, 10]
Solution().nextPermutation(nums)

assert nums == [1, 20, 26, 1, 15, 29, 4, 29, 10, 9, 21, 7, 27, 11, 21, 5, 9, 7, 27, 16, 17, 3, 6, 5, 16, 23, 29, 14, 28,
                21, 2, 29, 3, 29, 0, 18, 28, 5, 10, 9, 6, 23, 8, 25, 26, 21, 1, 5, 29, 28, 14, 8, 10, 1, 13, 20]

nums = [1, 1, 5]
Solution().nextPermutation(nums)
assert nums == [1, 5, 1]
print("tests passed")
