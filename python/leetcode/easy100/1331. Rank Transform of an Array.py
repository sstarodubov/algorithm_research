from typing import List


class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        if not arr:
            return []
        if len(arr) == 1:
            return [1]

        s_arr = sorted(arr)
        rank = [0] * len(s_arr)
        rank[0] = 1
        r = 1
        hm = {}
        hm[s_arr[0]] = 1
        for i in range(1, len(s_arr)):
            if s_arr[i] == s_arr[i - 1]:
                rank[i] = rank[i - 1]
            else:
                rank[i] = rank[i - 1] + 1
            hm[s_arr[i]] = rank[i]
        for i in range(len(arr)):
            arr[i] = hm[arr[i]]
        return arr

Solution().arrayRankTransform([40, 40, 10, 20, 30])