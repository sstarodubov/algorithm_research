from typing import List

"""
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
"""


class Solution:
    # time and space O(n*2^n)
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = [[]]
        cur_idx = 0
        while cur_idx < len(nums):
            copy = self.copy(ans)
            for arr in copy:
                arr.append(nums[cur_idx])
            cur_idx += 1
            for arr in copy:
                ans.append(arr)

        return ans

    def copy(self, arr) -> List[List[int]]:
        copy = []
        for i in range(len(arr)):
            new = []
            for y in range(len(arr[i])):
                new.append(arr[i][y])
            copy.append(new)
        return copy


s = Solution()

assert s.subsets([1, 2, 3]) == [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
assert s.subsets([0]) == [[], [0]]

print("tests passed")
