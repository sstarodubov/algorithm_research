from typing import List


class Trie:
    def __init__(self):
        self.root = {}

    def add(self, n: int):
        cur = self.root
        for i in range(31, -1, -1):
            bit = (n >> i) & 1
            if bit not in cur:
                cur[bit] = {}
            cur = cur[bit]
        cur["$"] = n

    def go(self, n: int):
        cur = self.root
        for i in range(31, -1, -1):
            bit = (n >> i) & 1
            if bit == 1 and 0 in cur:
                cur = cur[0]
            elif bit == 0 and 1 in cur:
                cur = cur[1]
            else:
                cur = cur[bit]
        cur_num = cur["$"]
        return n ^ cur_num


class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        trie = Trie()
        ans = float("-inf")
        for n in nums:
            trie.add(n)
        for n in nums:
            ans = max(ans, trie.go(n))

        return ans


assert 28 == Solution().findMaximumXOR([3, 10, 5, 25, 2, 8])
