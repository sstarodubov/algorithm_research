from typing import List


class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        xs = sorted(score, reverse=True)
        m = {xs[i]: (i + 1) for i in range(len(xs))}
        for i in range(len(score)):
            k = score[i]
            if m[k] == 1:
                score[i] = "Gold Medal"
            elif m[k] == 2:
                score[i] = "Silver Medal"
            elif m[k] == 3:
                score[i] = "Bronze Medal"
            else:
                score[i] = str(m[k])
        return score


assert Solution().findRelativeRanks([10, 3, 8, 9, 4]) == ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
