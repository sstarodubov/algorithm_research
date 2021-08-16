from collections import deque
from typing import List, Optional, Deque
from binarytree import build
from binarytree import Node

TreeNode = Node

"""
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted. 
"""


class Solution:

    # Time O(n) and Space O(n)
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        ans: List[(float, int)] = []
        q: Deque[(TreeNode, int)] = deque([(root, 0)])
        while q:
            node, depth = q.popleft()
            if len(ans) == depth:
                ans.append((node.val, 1))
            else:
                ans[depth] = (node.val + ans[depth][0], ans[depth][1] + 1)
            if node.left:
                q.append((node.left, depth + 1))

            if node.right:
                q.append((node.right, depth + 1))

        for i in range(len(ans)):
            ans[i] = ans[i][0] / ans[i][1]
        return ans


s = Solution()

assert s.averageOfLevels(build([3, 9, 20, None, 15, 7])) == [3.00000, 14.50000, 11.00000], 0
assert s.averageOfLevels(build([3, 9, 20, 15, 7])) == [3.00000, 14.50000, 11.00000], 0

print("tests passed")
