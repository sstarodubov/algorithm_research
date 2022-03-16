from typing import List


class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        odds, evens = [], []
        for n in nums:
            if n & 1 == 1:
                odds.append(n)
            else:
                evens.append(n)

        for i in range(len(nums)):
            if i & 1 == 1:
                nums[i] = odds.pop()
            else:
                nums[i] = evens.pop()
        return nums


Solution().sortArrayByParityII([4, 2, 5, 7])
