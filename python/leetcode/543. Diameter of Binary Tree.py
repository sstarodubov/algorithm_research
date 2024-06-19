from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.ans = float("-inf")

        def dfs(node: TreeNode) -> int:
            if not node:
                return 0

            lr = dfs(node.left)
            rr = dfs(node.right)

            self.ans = max(self.ans, lr + rr)
            mx = max(lr, rr)
            return mx + 1

        dfs(root)
        return self.ans
