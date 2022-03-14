from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        def fx(node: TreeNode, arr):
            if not node:
                return arr
            if not node.left and not node.right:
                arr.append(node.val)
                return arr

            fx(node.left, arr)
            fx(node.right, arr)
            return arr

        return fx(root1, []) == fx(root2, [])
