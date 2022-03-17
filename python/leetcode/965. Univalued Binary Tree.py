from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isUnivalTree(self, root: Optional[TreeNode]) -> bool:
        self.cur = None
        self.ans = True

        def dfs(node):
            if not self.ans:
                return
            if not node:
                return

            if self.cur is None:
                self.cur = node.val
            else:
                if self.cur != node.val:
                    self.ans = False
                    return
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return self.ans


assert not Solution().isUnivalTree(TreeNode.build_tree([5, 5, 5, 2]))
