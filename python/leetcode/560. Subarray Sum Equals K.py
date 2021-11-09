from typing import List


class Solution:

    # time O(n ^2) and space O(n)
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        prefix_sum = [0] * len(nums)
        prefix_sum[0] = nums[0]
        for i in range(1, len(nums)):
            prefix_sum[i] = prefix_sum[i - 1] + nums[i]

        for sz in range(1, len(nums)):
            begin, end = 0, sz
            while end < len(nums):
                if begin - 1 < 0:
                    smstart = 0
                else:
                    smstart = prefix_sum[begin - 1]
                sm = prefix_sum[end] - smstart
                if sm == k:
                    count += 1
                begin += 1
                end += 1
        for n in nums:
            if n == k:
                count += 1
        return count


assert Solution().subarraySum(nums=[1, 2, 3], k=3) == 2
assert Solution().subarraySum([28, 54, 7, -70, 22, 65, -6], 100) == 1
assert Solution().subarraySum([-1, -1, 1], 1) == 1
assert Solution().subarraySum([1, -1, 0], 0) == 3
assert Solution().subarraySum([-1, -1, 1], 0) == 1
assert Solution().subarraySum(nums=[1, 1, 1], k=2) == 2
print("tests passed")
