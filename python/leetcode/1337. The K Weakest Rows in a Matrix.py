from collections import defaultdict
from typing import List


class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        mp = defaultdict(lambda: [])
        sol = []
        for i in range(len(mat)):
            arr = mat[i]
            s = 0
            for el in arr:
                if el == 1:
                    s += 1
                else:
                    break
            sol.append(s)
            mp[s].append(i)
        sol.sort()
        ans, c = [], 0

        used = set()
        for s in sol:
            if s in used:
                continue
            used.add(s)
            for idx in mp[s]:
                if c == k:
                    return ans
                ans.append(idx)
                c += 1
        return ans


assert Solution().kWeakestRows([[1, 0], [1, 0], [1, 0], [1, 1]], 4) == [0, 1, 2, 3]
assert Solution().kWeakestRows(mat=
                               [[1, 1, 0, 0, 0],
                                [1, 1, 1, 1, 0],
                                [1, 0, 0, 0, 0],
                                [1, 1, 0, 0, 0],
                                [1, 1, 1, 1, 1]],
                               k=3) == [2, 0, 3]
