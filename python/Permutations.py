from typing import List

"""
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]


"""


class Solution:

    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []

        def helper(idx: int):
            if idx >= len(nums):
                copy = nums[:]
                result.append(copy)
            else:
                for i in range(idx, len(nums)):
                    nums[i], nums[idx] = nums[idx], nums[i]
                    helper(idx + 1)
                    nums[i], nums[idx] = nums[idx], nums[i]
        helper(0)
        return result


s = Solution()

assert s.permute([1, 2, 3]) == [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
print("tests passed")
