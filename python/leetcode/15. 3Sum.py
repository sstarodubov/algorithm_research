from typing import List


class Solution:

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) <= 2:
            return []
        nums.sort()
        ans = []

        for i, a in enumerate(nums):
            if i > 0 and a == nums[i - 1]:
                continue

            l, r = i + 1, len(nums) - 1

            while l < r:
                cur_sum = a + nums[l] + nums[r]
                if cur_sum > 0:
                    r -= 1
                elif cur_sum < 0:
                    l += 1
                else:
                    ans.append([a, nums[l], nums[r]])
                    l += 1
                    while nums[l] == nums[l - 1] and l < r:
                        l += 1
        return ans


assert Solution().threeSum([1, 2, -2, -1]) == []
assert Solution().threeSum([0, 0, 0, 0]) == [[0, 0, 0]]
assert Solution().threeSum([-1, 0, 1, 2, -1, -4]) == [[-1, -1, 2], [-1, 0, 1]]
