from typing import List


class Solution:
    # Time O(n log n) and Space O(n)
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        sortArr = sorted(arr)
        scores = {}
        k = 1
        for el in sortArr:
            if el not in scores:
                scores[el] = k
                k += 1
        for i in range(len(arr)):
            score = scores[arr[i]]
            arr[i] = score

        return arr


s = Solution()
assert [4, 1, 2, 3] == s.arrayRankTransform([40, 10, 20, 30]), "1"
assert [1, 1, 1] == s.arrayRankTransform([100, 100, 100]), "2"

print("tests passed")
