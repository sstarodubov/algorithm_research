from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def increasingBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.dummy = TreeNode()
        self.cur = self.dummy

        def dfs(node:Optional[TreeNode]):
            if not node:
                return

            dfs(node.left)
            node.left = None
            self.cur.right = node
            self.cur = self.cur.right
            dfs(node.right)
        dfs(root)

        return self.dummy.right