from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:

        self.ans, self.c = -1, 0

        def dfs(n: TreeNode):
            if not n:
                return

            dfs(n.left)

            if n.val != self.ans and self.c < k:
                self.c += 1
                self.ans = n.val

            dfs(n.right)

        dfs(root)

        return self.ans

assert Solution().kthSmallest(TreeNode.build_tree([3, 1, 4, None, 2]), k=1) == 1
assert Solution().kthSmallest(TreeNode.build_tree([5, 3, 6, 2, 4, None, None, 1]), 3) == 3
