from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def findTilt(self, root: Optional[TreeNode]) -> int:

        self.s = 0

        def dfs(node: TreeNode) -> int:
            if not node:
                return 0

            lv = dfs(node.left)
            rv = dfs(node.right)
            t = node.val
            diff = abs(lv - rv)
            node.val = diff
            self.s += node.val
            return lv + rv + t

        dfs(root)

        return self.s


assert 15 == Solution().findTilt(TreeNode.build_tree([4, 2, 9, 3, 5, None, 7]))
