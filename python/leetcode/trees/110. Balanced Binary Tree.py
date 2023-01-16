from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isBalanced(self, n: Optional[TreeNode]) -> bool:
        self.ans = True

        def dfs(node: TreeNode):
            if not node:
                return 1

            l = dfs(node.left)
            r = dfs(node.right)
            if abs(l - r) > 1:
                self.ans  = False
            return max(l, r) + 1

        dfs(n)

        return self.ans


assert not Solution().isBalanced(TreeNode.build_tree([1, 2, 2, 3, 3, None, None, 4, 4]))
assert Solution().isBalanced(TreeNode.build_tree([3, 9, 20, None, None, 15, 7]))
