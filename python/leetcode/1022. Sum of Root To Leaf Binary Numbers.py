from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def dfs(node: Optional[TreeNode], cur: int):
            if not node:
                return 0
            t = cur << 1
            cur = t | node.val

            if not node.left and not node.right:
                self.ans += cur
                return

            dfs(node.left, cur)
            dfs(node.right, cur)

        dfs(root, 0)
        return self.ans


assert Solution().sumRootToLeaf(TreeNode.build_tree([1, 0, 1, 0, 1, 0, 1])) == 22
