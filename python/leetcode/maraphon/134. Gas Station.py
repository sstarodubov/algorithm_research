from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1
        s, k, n = 0, 0, len(gas)
        for i in range(n):
            s += gas[i] - cost[i]
            if s < 0:
                s = 0
                k = i + 1
        return k


assert 3 == Solution().canCompleteCircuit([5, 8, 2, 8], [6, 5, 6, 6])
assert -1 == Solution().canCompleteCircuit(gas=[2, 3, 4], cost=[3, 4, 3])
assert 3 == Solution().canCompleteCircuit(gas=[1, 2, 3, 4, 5], cost=[3, 4, 5, 1, 2])
