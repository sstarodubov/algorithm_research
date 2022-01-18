# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        self.d = 0

        def dfs(node: Optional[TreeNode], depth: int):
            if not node:
                self.d = max(self.d, depth)
                return
            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)

        dfs(root, 0)

        return self.d


assert Solution().maxDepth(TreeNode.build_tree([3, 9, 20, None, None, 15, 7])) == 3
