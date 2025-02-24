from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isUnivalTree(self, root: Optional[TreeNode]) -> bool:
        self.ans = True
        def dfs(node):
            if not node:
                return None

            l = dfs(node.left)
            r = dfs(node.right)

            if l and l.val != node.val:
                self.ans = False
            if r and r.val != node.val:
                self.ans = False
            if r and l and l.val != r.val:
                self.ans = False
            return node

        dfs(root)

        return self.ans