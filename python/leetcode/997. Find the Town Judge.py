from typing import List


class Solution:

    # cpu O(n) and ram O(n)
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        people = {}
        for i in range(1, n + 1):
            people[i] = set()
        for pair in trust:
            people[pair[0]].add(pair[1])

        pot_judge = -1
        for i in range(1, n + 1):
            if len(people[i]) == 0:
                pot_judge = i
        if pot_judge == -1:
            return pot_judge

        for i in range(1, n + 1):
            if pot_judge == i:
                continue
            else:
                if pot_judge not in people[i]:
                    return -1
        return pot_judge


assert Solution().findJudge(n=4, trust=[[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]]) == 3
assert Solution().findJudge(n=3, trust=[[1, 3], [2, 3], [3, 1]]) == -1
print("tests passed")
