from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def evaluateTree(self, n: Optional[TreeNode]) -> bool:
        if not n.left and not n.right:
            return n.val != 0

        le = self.evaluateTree(n.left)
        ri = self.evaluateTree(n.right)

        if n.val == 2:
            return le or ri

        else:
            return le and ri



