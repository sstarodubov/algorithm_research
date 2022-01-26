from typing import List


class Solution:

    # time O( n log n) , space O(1)
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        count = 0
        prev = -1
        for num in nums:
            if num != prev:
                count = 1
                prev = num
            else:
                count += 1
            if count > n // 2:
                return num
        return -1


assert Solution().majorityElement([2, 2, 1, 1, 1, 2, 2]) == 2
