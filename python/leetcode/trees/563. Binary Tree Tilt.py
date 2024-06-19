from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def findTilt(self, root: Optional[TreeNode]) -> int:
        self.ans = 0

        def dfs(n: TreeNode):
            if not n:
                return 0

            if not n.left and not n.right:
                return n.val

            lv = dfs(n.left)
            rv = dfs(n.right)

            t = abs(lv - rv)
            self.ans += t

            return lv + rv + n.val

        dfs(root)

        return self.ans


assert 15 == Solution().findTilt(TreeNode.build_tree([4, 2, 9, 3, 5, None, 7]))
assert 1 == Solution().findTilt(TreeNode.build_tree([1, 2, 3]))
