# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root2 and not root1:
            return None
        if not root1:
            return root2
        if not root2:
            return root1

        def dfs(n1, n2):
            if n1 and n2:
                nn = TreeNode(n1.val + n2.val)
                nn.left = dfs(n1.left, n2.left)
                nn.right = dfs(n1.right, n2.right)
                return nn
            elif n1:
                nn = TreeNode(n1.val)
                nn.left = dfs(n1.left, None)
                nn.right = dfs(n1.right, None)
                return nn
            elif n2:
                nn = TreeNode(n2.val)
                nn.left = dfs(None, n2.left)
                nn.right = dfs(None, n2.right)
                return nn
            else:
                return None

        root = dfs(root1, root2)

        return root


Solution().mergeTrees(TreeNode.build_tree([1, 3, 2, 5]), TreeNode.build_tree([2, 1, 3, None, 4, None, 7]))
Solution().mergeTrees(TreeNode.build_tree([1]), TreeNode.build_tree([1, 2]))
