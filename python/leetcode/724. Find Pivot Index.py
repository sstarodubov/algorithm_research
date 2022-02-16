from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        prefix_sum = [0] * (len(nums) + 1)
        for i in range(1, len(prefix_sum)):
            prefix_sum[i] = prefix_sum[i - 1] + nums[i - 1]

        for i in range(len(nums)):
            smlt, smrt = 0, 0
            smlt = prefix_sum[i]
            smrt = prefix_sum[-1] - prefix_sum[i + 1]
            if smrt == smlt:
                return i

        return -1


assert Solution().pivotIndex([1, 2, 3, 4, 5]) == -1
assert Solution().pivotIndex([1, 7, 3, 6, 5, 6]) == 3
