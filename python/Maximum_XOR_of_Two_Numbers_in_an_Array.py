from typing import List


class TrieNode:
    def __init__(self):
        self.children = {}

    def __str__(self):
        return f"TrieNode({self.children})"


class Solution:

    def __init__(self):
        self.root = TrieNode()

    def insertBits(self, num):
        bitNum = bin(num)[2:].zfill(32)
        node = self.root
        for bit in bitNum:
            if bit not in node.children:
                node.children[bit] = TrieNode()
            node = node.children[bit]

    def findMaxXor(self, num):
        bitNum = bin(num)[2:].zfill(32)
        node = self.root
        maxXor = ""
        oppositeBit: str
        for bit in bitNum:
            oppositeBit = "1" if bit == "0" else "0"
            if oppositeBit in node.children:
                maxXor += oppositeBit
                node = node.children[oppositeBit]
            else:
                maxXor += bit
                node = node.children[bit]
        return int(maxXor, 2) ^ num

    def findMaximumXOR(self, nums: List[int]) -> int:
        for num in nums:
            self.insertBits(num)
        max_ = 0
        for num in nums:
            max_ = max(max_, self.findMaxXor(num))
        return max_


s = Solution()
print(s.findMaximumXOR([3, 10, 5, 25, 2, 8]))
