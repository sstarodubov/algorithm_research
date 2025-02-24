from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.sum = 0

        def dfs(node, p):
            if not node:
                return

            if node and not node.left and not node.right:
                self.sum += int(p + str(node.val), 2)
                return

            dfs(node.left, p + str(node.val))
            dfs(node.right, p + str(node.val))

        dfs(root, "")
        return self.sum
