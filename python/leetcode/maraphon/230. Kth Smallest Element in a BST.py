from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return 0
        self.res = 0
        self.count = 0

        def dfs(n: Optional[TreeNode]):
            if not n:
                return
            dfs(n.left)
            self.count += 1
            if self.count == k:
                self.res = n.val
                return
            dfs(n.right)

        dfs(root)
        return self.res


assert 3 == Solution().kthSmallest(TreeNode.build_tree([5, 3, 6, 2, 4, None, None, 1]), 3)
