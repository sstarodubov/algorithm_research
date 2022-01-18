from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:

    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.ans = float("inf")

        def dfs(node: Optional[TreeNode], depth: int):
            if not node:
                return
            cur_depth = depth + 1
            if not node.left and not node.right:
                self.ans = min(self.ans, cur_depth)
                return
            dfs(node.left, cur_depth)
            dfs(node.right, cur_depth)

        dfs(root, 0)

        return int(self.ans)


assert Solution().minDepth(TreeNode.build_tree([2, None, 3, None, 4, None, 5, None, 6])) == 5
assert Solution().minDepth(TreeNode.build_tree([3, 9, 20, None, None, 15, 7])) == 2
