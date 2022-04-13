from typing import List


class Solution:

    # time (n * 2 ^n)
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()
        def decision_tree(cur: List[int], idx):
            if idx >= len(nums):
                ans.append(cur)
                return

            rarr = cur[:]
            larr = cur[:]
            larr.append(nums[idx])

            decision_tree(larr, idx + 1)

            idx = idx + 1
            while idx != 0 and idx < len(nums) and nums[idx - 1] == nums[idx]:
                idx += 1
            decision_tree(rarr, idx)

        decision_tree([], 0)

        return ans


print(Solution().subsetsWithDup([1, 1]))
assert [[1, 2, 2], [1, 2], [1], [2, 2], [2], []] == Solution().subsetsWithDup([1, 2, 2])
