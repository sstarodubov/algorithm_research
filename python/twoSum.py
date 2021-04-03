from typing import List

class Solution:

    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     nums.sort()
    #     left = 0
    #     right = len(nums) - 1
    #     while left != right:
    #         cur_sum = nums[left] + nums[right]
    #         if cur_sum == target:
    #             return [left, right]
    #         elif cur_sum > target:
    #             right -= 1
    #         else:
    #             left += 1
    #     return []

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for idx in range(len(nums)):
            diff = target - nums[idx]
            if diff in map:
                if idx <= map[diff]:return [idx, map[diff]]
                else: return [map[diff], idx]
            else:
                map[nums[idx]] = idx
        return []

sol = Solution()

print(sol.twoSum([3,3], 6))