from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:

        self.ans = 0

        def dfs(n: TreeNode, d):
            if not n:
                return
            if not n.left and not n.right and d == -1:
                self.ans += n.val
                return

            if n.left:
                dfs(n.left, -1)

            if n.right:
                dfs(n.right, 1)

        dfs(root, 0)
        return self.ans


assert 24 == Solution().sumOfLeftLeaves(TreeNode.build_tree([3, 9, 20, None, None, 15, 7]))
