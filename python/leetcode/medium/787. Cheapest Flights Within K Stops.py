import heapq
from collections import defaultdict, deque
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        cost = [float("inf")] * n
        cost[src] = 0
        for i in range(k + 1):
            temp = cost[:]
            for frm, to, price in flights:
                if temp[to] > cost[frm] + price:
                    temp[to] = cost[frm] + price
            cost = temp
        if cost[dst] == float("inf"):
            return -1
        return cost[dst]


assert 7 == Solution().findCheapestPrice(5, [[3, 4, 1], [0, 2, 5], [0, 1, 1], [1, 2, 1], [2, 3, 1], ], 0, 4, 2)
assert 6 == Solution().findCheapestPrice(4, [[0, 1, 1], [0, 2, 5], [1, 2, 1], [2, 3, 1]], 0, 3, 1)
assert 500 == Solution().findCheapestPrice(n=3, flights=[[0, 1, 100], [1, 2, 100], [0, 2, 500]], src=0, dst=2, k=0)
assert 700 == Solution().findCheapestPrice(n=4,
                                           flights=[[0, 1, 100], [1, 2, 100], [2, 0, 100], [1, 3, 600], [2, 3, 200]],
                                           src=0,
                                           dst=3, k=1)
