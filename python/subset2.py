from typing import List, Dict

"""
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
"""


class Solution:
    # time and space O(n*2^n)
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        tmp_arr = [[]]
        cur_idx = 0
        while cur_idx < len(nums):
            copy = self.copy(tmp_arr)
            for arr in copy:
                arr.append(nums[cur_idx])
            cur_idx += 1
            for arr in copy:
                tmp_arr.append(arr)
        ans = {}
        for ar in tmp_arr:
            ar.sort()
            ans[ar.__str__()] = ar
        return list(ans.values())

    def copy(self, arr) -> List[List[int]]:
        copy = []
        for i in range(len(arr)):
            new = []
            for y in range(len(arr[i])):
                new.append(arr[i][y])
            copy.append(new)
        return copy


s = Solution()
assert s.subsetsWithDup([1, 2, 2]) == [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
print("tests passed")
