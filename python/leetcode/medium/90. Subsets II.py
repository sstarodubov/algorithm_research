from typing import List


class Solution:

    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans = [[]]
        nums.sort()
        for idx, n in enumerate(nums):

            tmp = []
            for arr in ans:
                tmp.append(arr[:])

            for arr in ans:
                arr.append(n)

            for arr in tmp:
                ans.append(arr)

        def key(ar: List[int]):
            ar.sort()
            return ''.join(str(e) for e in ar)

        used = set()
        anss = []
        for arr in ans:
            k = key(arr)
            if k not in used:
                anss.append(arr)
                used.add(k)
        return anss


print(Solution().subsetsWithDup([1, 2, 2]))
