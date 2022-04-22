from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        count = 0
        for i in nums:
            if i < 0:
                count += 1
        sign = 1 if count % 3 == 0 else -1
        for i in range(32):
            x = 0
            for j in range(len(nums)):
                x += abs(nums[j]) & 1
                nums[j] = abs(nums[j]) >> 1

            last_bit = x % 3
            last_bit = last_bit << i
            ans = ans | last_bit

        return sign * ans


assert 4 == Solution().singleNumber([-2, -2, 1, 1, 4, 1, 4, 4, 4, -2])
assert 3 == Solution().singleNumber([1, 1, 1, 2, 2, 2, 3])
assert 1 == Solution().singleNumber([2, 2, 2, 1])
