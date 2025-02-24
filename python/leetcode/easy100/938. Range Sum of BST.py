# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.result = 0
        def dfs(node):
            if not node:
                return

            dfs(node.left)
            if node.val >= low and node.val <= high:
                self.result += node.val
            dfs(node.right)

        dfs(root)

        return self.result