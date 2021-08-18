from typing import Optional

from binarytree import build, Node

TreeNode = Node

"""

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
"""


class Solution:

    # cpu O(n) - node amount and ram O(log d) d - depth of the tree
    def diameterOfBinaryTree(self, node: TreeNode) -> int:
        avm = 0

        def dfs(n: TreeNode) -> int:
            nonlocal avm
            if not n:
                return -1
            if not n.left and not n.right:
                return 0
            ld = dfs(n.left)
            rd = dfs(n.right)
            mx = max(ld + 1, rd + 1)
            avm = max(avm, ld + rd + 2)
            return mx

        r = dfs(node)
        return max(avm, r)


s = Solution()

assert 3 == s.diameterOfBinaryTree(build([1, 2, 3, 4, 5])), 0
assert 4 == s.diameterOfBinaryTree(build([2, 1, 4, 3, None, 5])), -2
assert 0 == s.diameterOfBinaryTree(build([1])), -1
assert 2 == s.diameterOfBinaryTree(build([3, 1, None, None, 2])), 1

print("tests passed")
