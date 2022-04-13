from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = [[]]
        for n in nums:
            tmp = []
            for arr in ans:
                tmp.append(arr[:])

            for arr in ans:
                arr.append(n)

            for arr in tmp:
                ans.append(arr)
        return ans


print(Solution().subsets([1, 2, 3]))
